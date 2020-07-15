package poker.rule;

import java.util.ArrayList;

public class GameParticipant {
	private ArrayList<Card> handCards = new ArrayList<>();
	private  Hand hand;
	private DiscoverHand discoverHand;

	//手札を追加するメソッド
	public void addCard(Card card) {
		handCards.add(card);
	}

	//役を追加
	public void setHand() {
		this.hand = discoverHand.getHand(handCards);
	}

	//役のvalueを返す。
	public Hand getHand() {
		return hand;
	}


}
