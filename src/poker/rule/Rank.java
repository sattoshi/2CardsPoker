package poker.rule;

public enum Rank {
	Ace(13),
	Two(1),
	Three(2),
	Four(3),
	Five(4),
	Six(5),
	Seven(6),
	Eight(7),
	Nine(8),
	Ten(9),
	Jack(10),
	Queen(11),
	King(12);


	 // id はRankの強さを表す。
	private int id;

	private Rank(int id) {
		this.id = id;
	}

	public int getValue() {
		return this.id;
	}

	public String toString() {

		id = this.getValue();
		String result = null;
		switch(id) {
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
			result = String.valueOf(id+1);
			break;
		case 10:
			result = "J";
			break;
		case 11:
			result = "Q";
			break;
		case 12:
			result = "K";
			break;
		case 13:
			result = "A";
			break;
		default:
			result = null;
			break;
		}

		return result;

	}
}