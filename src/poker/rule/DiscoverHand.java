package poker.rule;

import java.util.ArrayList;

public class DiscoverHand {

	//役を返すメソッド
	public Hand getHand(ArrayList<Card> handCards) {
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
}
