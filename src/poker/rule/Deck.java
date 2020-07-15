package poker.rule;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> cards = new ArrayList<Card>();

	//コンストラクタ(デッキの作成)
	public Deck() {
		cards.add(new Card(Suit.Spade, Rank.Ace));
		cards.add(new Card(Suit.Spade, Rank.Two));
		cards.add(new Card(Suit.Spade, Rank.Three));
		cards.add(new Card(Suit.Spade, Rank.Four));
		cards.add(new Card(Suit.Spade, Rank.Five));
		cards.add(new Card(Suit.Spade, Rank.Six));
		cards.add(new Card(Suit.Spade, Rank.Seven));
		cards.add(new Card(Suit.Spade, Rank.Eight));
		cards.add(new Card(Suit.Spade, Rank.Nine));
		cards.add(new Card(Suit.Spade, Rank.Ten));
		cards.add(new Card(Suit.Spade, Rank.Jack));
		cards.add(new Card(Suit.Spade, Rank.Queen));
		cards.add(new Card(Suit.Spade, Rank.King));

		cards.add(new Card(Suit.Heart, Rank.Ace));
		cards.add(new Card(Suit.Heart, Rank.Two));
		cards.add(new Card(Suit.Heart, Rank.Three));
		cards.add(new Card(Suit.Heart, Rank.Four));
		cards.add(new Card(Suit.Heart, Rank.Five));
		cards.add(new Card(Suit.Heart, Rank.Six));
		cards.add(new Card(Suit.Heart, Rank.Seven));
		cards.add(new Card(Suit.Heart, Rank.Eight));
		cards.add(new Card(Suit.Heart, Rank.Nine));
		cards.add(new Card(Suit.Heart, Rank.Ten));
		cards.add(new Card(Suit.Heart, Rank.Jack));
		cards.add(new Card(Suit.Heart, Rank.Queen));
		cards.add(new Card(Suit.Heart, Rank.King));

		cards.add(new Card(Suit.Club, Rank.Ace));
		cards.add(new Card(Suit.Club, Rank.Two));
		cards.add(new Card(Suit.Club, Rank.Three));
		cards.add(new Card(Suit.Club, Rank.Four));
		cards.add(new Card(Suit.Club, Rank.Five));
		cards.add(new Card(Suit.Club, Rank.Six));
		cards.add(new Card(Suit.Club, Rank.Seven));
		cards.add(new Card(Suit.Club, Rank.Eight));
		cards.add(new Card(Suit.Club, Rank.Nine));
		cards.add(new Card(Suit.Club, Rank.Ten));
		cards.add(new Card(Suit.Club, Rank.Jack));
		cards.add(new Card(Suit.Club, Rank.Queen));
		cards.add(new Card(Suit.Club, Rank.King));

		cards.add(new Card(Suit.Diamond, Rank.Ace));
		cards.add(new Card(Suit.Diamond, Rank.Two));
		cards.add(new Card(Suit.Diamond, Rank.Three));
		cards.add(new Card(Suit.Diamond, Rank.Four));
		cards.add(new Card(Suit.Diamond, Rank.Five));
		cards.add(new Card(Suit.Diamond, Rank.Six));
		cards.add(new Card(Suit.Diamond, Rank.Seven));
		cards.add(new Card(Suit.Diamond, Rank.Eight));
		cards.add(new Card(Suit.Diamond, Rank.Nine));
		cards.add(new Card(Suit.Diamond, Rank.Ten));
		cards.add(new Card(Suit.Diamond, Rank.Jack));
		cards.add(new Card(Suit.Diamond, Rank.Queen));
		cards.add(new Card(Suit.Diamond, Rank.King));

		Collections.shuffle(cards);
	}

	// デッキから一枚引く
	public Card draw() {
		var rt = cards.get(0);
		cards.remove(0);
		return rt;
	}

}
