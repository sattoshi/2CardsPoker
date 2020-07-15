package poker.rule;

public class Dealer {
	private GameParticipant participant;

	public Dealer() {
		participant = new GameParticipant();
	}

	public void addCard(Card card) {
		participant.addCard(card);
	}

}
