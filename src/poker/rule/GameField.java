package poker.rule;

import java.util.ArrayList;
import java.util.Collections;

public class GameField {
	GameParticipantInterface player;
//	private Player player;
	GameParticipantInterface dealer;
//	private Dealer dealer;
	private Deck deck = null;


	 //ゲームスタート
	 public void startGame() {
		//初期化
		init();

		//各プレイヤーの役をセット
		player.setHand(player.getHandCard());
		dealer.setHand(dealer.getHandCard());

		//プレイヤーのカードと役の表示
		System.out.println("===Player===");
		player.openHand();
		System.out.println();

		//ディーラーのカードと役の表示
		System.out.println("===Dealer===");
		dealer.openHand();
		System.out.println();

		//役の比較
		System.out.println(judgeWinner());
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
	 //勝敗を判断するメソッド
	 public String judgeWinner() {
		Hand playerHand = player.getHand();
		Hand dealerHand = dealer.getHand();

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
