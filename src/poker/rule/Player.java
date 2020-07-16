package poker.rule;

import java.util.ArrayList;

public class Player implements GameParticipantInterface{
	private GameParticipant participant;

	//コンストラクタ
	public Player() {
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

	//役をセットする
	public void setHand(ArrayList<Card> handCards) {
		participant.setHand(handCards);
	}

	//役を返す
	public Hand getHand() {
		return participant.getHand();
	}

	//手札と役を表示する。
	public void openHand() {
		participant.openHand();
	}

}
