package poker.rule;

public enum Hand {
	StraightFlush(4),
	Pair(3),
	Straight(2),
	Flush(1),
	HiCard(0);

	/**
	 * value は役の大きさを表す
	 */
	private int value;

	private Hand(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}

	public String toString() {
		String result = null;
		switch(value) {
		case 0:
			result = "Hi Card︎";
			break;
		case 1:
			result = "Flush";
			break;
		case 2:
			result = "Straight";
			break;
		case 3:
			result = "︎Pair";
			break;
		case 4:
			result = "Straight Flush";
			break;
		}
		return result;
	}
}
