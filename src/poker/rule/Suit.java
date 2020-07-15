package poker.rule;

public enum Suit {
	Spade(3),
	Heart(2),
	Club(1),
	Diamond(0);

	private int value;

	private Suit(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public String toString() {
		String result = null;
		switch(value) {
		case 0:
			result = "♦︎";
			break;
		case 1:
			result = "♣︎";
			break;
		case 2:
			result = "❤";
			break;
		case 3:
			result = "︎♠";
			break;
		}
		return result;
	}

}
