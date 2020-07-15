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
		if(getRank().getValue() == card.getRank().getValue() + 1 || getRank().getValue() == card.getRank().getValue() - 1) {
			return true;
		}else {
			return false;
		}
	}

}
