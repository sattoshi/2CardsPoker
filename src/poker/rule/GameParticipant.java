package poker.rule;

import java.util.ArrayList;

public class GameParticipant {
	private ArrayList<Card> handCards = new ArrayList<>();
	private Hand hand;
	private DiscoverHand discoverHand = new DiscoverHand();

	//手札を追加する
	public void addCard(Card card) {
		handCards.add(card);
	}

	//手札を返す
	public ArrayList<Card> getHandCard(){
		return handCards;
	}

	//役をセットする。
	public void setHand(ArrayList<Card> handCards) {
		this.hand =  discoverHand.getHand(handCards);
	}

	//役を返す
	public Hand getHand() {
		return hand;
	}

	//手札と役を表示する
	public void openHand() {
		System.out.println("[手札]");
		for(int i = 0; i < handCards.size(); i++) {
			System.out.println(handCards.get(i).toString());
		}
		System.out.println("[役]");
		System.out.println(hand.toString());
	}

}
