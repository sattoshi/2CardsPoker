package poker.rule;

public class Card {
	private Suit suit;
	private Rank rank;

	public Card(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}
	// カードのスート(マーク、シンボル)を取得する
	public Suit getSuit() {
		return suit;
	}

	// カードのランク(数字)を取得する
	public Rank getRank() {
		return rank;
	}

	public String toString() {
		return suit.toString() + rank.toString();
	}

	//スートが同じか確認するメソッド
	public boolean hasSameSuit(Card card) {
		if(getSuit() == card.getSuit()) {
			return true;
		}else {
			return false;
		}
	}

	//ランクが同じか確認するメソッド
	public boolean hasSameRank(Card card) {
		if(getRank() == card.getRank()) {
			return true;
		}else {
			return false;
		}
	}

	//ランクが連続しているか確認するメソッド
	public boolean hasConsecutiveRank(Card card) {
		int card1RankValue = getRank().getValue();
		int card2RankValue = card.getRank().getValue();

		if(card1RankValue == 1) {
			if(card2RankValue == 2 || card2RankValue == 13) {
				return true;
			}else {
				return false;
			}
		}
		else if( card1RankValue == 13 ) {
			if(card2RankValue == 12 || card2RankValue == 1) {
				return true;
			}else {
				return false;
			}
		}
		else if (card2RankValue == 1 ){
			if(card1RankValue == 2 || card1RankValue == 13) {
				return true;
			}else {
				return false;
			}
		}
		else if(card2RankValue == 13) {
			if(card1RankValue == 12 || card1RankValue == 1) {
				return true;
			}else {
				return false;
			}
		}
		else {
			if(card1RankValue == card2RankValue + 1 || card1RankValue == card2RankValue - 1) {
				return true;
			}else {
				return false;
			}
		}
	}

}
