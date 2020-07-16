package poker.rule;

import java.util.ArrayList;

public interface GameParticipantInterface {

	void addCard(Card card) ;

	ArrayList<Card> getHandCard();

	void setHand(ArrayList<Card> handCards);

	Hand getHand();

	void openHand();

}
