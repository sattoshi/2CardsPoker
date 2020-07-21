package poker.rule;

import java.util.ArrayList;

public class Dealer implements GameParticipantInterface{
	private GameParticipant participant;
	//コンストラクタ
	public Dealer() {
		participant = new GameParticipant();
	}

	//手札を追加
	public void addCard(Card card) {
		participant.addCard(card);
	}

	//手札を返す
	public ArrayList<Card> getHandCard() {
		return participant.getHandCard();
	}

	//手札と役を表示する。
	public void openHand() {
		participant.openHand();
	}

}
