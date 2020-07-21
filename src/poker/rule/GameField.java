package poker.rule;

import java.util.ArrayList;
import java.util.Collections;

public class GameField {
	GameParticipantInterface player;
	GameParticipantInterface dealer;
	private Deck deck = null;


	 //ゲームスタート
	 public void startGame() {
		 Hand playerHand;
		 Hand dealerHand;
		//初期化
		init();

		//プレイヤーのカードと役の表示
		System.out.println("===Player===");
		System.out.println("[手札]");

		for(int i = 0; i < player.getHandCard().size(); i++) {
			System.out.println(player.getHandCard().get(i).toString());
		}

		System.out.println("[役]");
		playerHand = judgeHand(player.getHandCard());
		System.out.println(playerHand.toString());

		System.out.println();

		//ディーラーのカードと役の表示
		System.out.println("===Dealer===");
		System.out.println("[手札]");

		for(int j = 0; j < dealer.getHandCard().size(); j++) {
			System.out.println(dealer.getHandCard().get(j).toString());
		}

		System.out.println("[役]");
		dealerHand = judgeHand(dealer.getHandCard());
		System.out.println(dealerHand.toString());
		System.out.println();

		//役の比較
		System.out.println(judgeWinner(playerHand,dealerHand));
	 }

	 //初期設定の処理
	 public void init() {
		player = new Player();
		dealer =new Dealer();
		deck = new Deck();
		//各プレイヤーが2枚引く
		for(int i = 0; i < 2; i++) {
			player.addCard(deck.draw());
			dealer.addCard(deck.draw());
		}
	 }

	 //役を判断するメソッド
	 public Hand judgeHand(ArrayList<Card> handCards) {
			Hand result;

			Card card1 = handCards.get(0);
			Card card2 = handCards.get(1);

			//ストレートフラッシュ
			if(card1.hasConsecutiveRank(card2) && card1.hasSameSuit(card2)) {
				result = Hand.StraightFlush;
			}
			//ペア
			else if(card1.hasSameRank(card2)) {
				result =  Hand.Pair;
			}
			//ストレート
			else if(card1.hasConsecutiveRank(card2)) {
				result = Hand.Straight;
			}
			//フラッシュ
			else if(card1.hasSameSuit(card2)) {
				result = Hand.Flush;
			}
			//ハイカード
			else {
				result = Hand.HiCard;
			}
			return result;
		}


	 //勝敗を判断するメソッド
	 public String judgeWinner(Hand playerHand ,Hand dealerHand) {

		if(playerHand.getValue() > dealerHand.getValue()) {
			return "You Win!!";
		}

		//役の強さが同じだった場合の処理
		else if(playerHand.getValue() == dealerHand.getValue()) {
			//プレイヤーの手札処理
			ArrayList<Card> playerHandCards = player.getHandCard();
			//手札のカードのバリューのみのListを作成
			ArrayList<Integer> playerHandCardsRank = new ArrayList<Integer>();
			for(int i = 0 ; i < playerHandCards.size(); i++) {
				playerHandCardsRank.add(playerHandCards.get(i).getRank().getValue());
			}
			//手札を降順にソート
			Collections.sort(playerHandCardsRank);
	        Collections.reverse(playerHandCardsRank);

	        //ディーラーの手札処理
			ArrayList<Card> dealerHandCards = dealer.getHandCard();
			//手札のカードのバリューのみのListを作成
			ArrayList<Integer> dealerHandCardsRank = new ArrayList<Integer>();
			for(int j = 0 ; j < dealerHandCards.size(); j++) {
				dealerHandCardsRank.add(dealerHandCards.get(j).getRank().getValue());
			}
			//手札を降順にソート
			Collections.sort(dealerHandCardsRank);
	        Collections.reverse(dealerHandCardsRank);

	        int playerMostCard = 0;
	        int dealerMostCard = 0;

			switch (playerHand) {
				case StraightFlush:
				case Straight:
					if(playerHandCardsRank.get(0) == 13 && playerHandCardsRank.get(playerHandCardsRank.size()-1) == 1) {
						playerMostCard = 1;
					}else {
						playerMostCard = playerHandCardsRank.get(0);
					}

					if(dealerHandCardsRank.get(0) == 13 && dealerHandCardsRank.get(dealerHandCardsRank.size()-1) == 1) {
						dealerMostCard = 1;
					}else {
						dealerMostCard = dealerHandCardsRank.get(0);
					}

					if(playerMostCard > dealerMostCard) {
						return "You Win!!";
					}else if(playerMostCard == dealerMostCard) {
						return "Drow";
					}else {
						return "You Lose...";
					}

				case Pair:
					playerMostCard = playerHandCardsRank.get(0);
					dealerMostCard = dealerHandCardsRank.get(0);
					if(playerMostCard > dealerMostCard) {
						return "You Win!!";
					}else if(playerMostCard == dealerMostCard) {
						return "Drow";
					}else {
						return "You Lose...";
					}

				case Flush:
				case HiCard:
					for(int k = 0; k < playerHandCardsRank.size(); k++) {
						playerMostCard = playerHandCardsRank.get(k);
						dealerMostCard = dealerHandCardsRank.get(k);

						if(playerMostCard > dealerMostCard) {
							return "You Win!!";
						}else if(playerMostCard == dealerMostCard) {
							continue;
						}else {
							return "You Lose...";
						}
					}
					return "Drow";

				default: return null;
			}
		}
		else {
			return "You Lose...";
		}
	 }

}
