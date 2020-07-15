package poker.rule;

public class Player {
	private GameParticipant participant;

	public Player() {
		participant = new GameParticipant();
	}

	public void addCard(Card card) {
		participant.addCard(card);
	}

	public void getHand()

}
