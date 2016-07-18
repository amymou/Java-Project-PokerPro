

import java.util.ArrayList;
import java.util.Random;

public class Deck {

	public static final int CARDS_IN_DECK = 52;
	public static final int SHUFFLE_SWAPS = 500;

	/**
	 * An array of Card objects that will be used to manage the CARDS_IN_DECK
	 * cards in the deck
	 **/
	ArrayList<Card> array_cards;

	/** The index of the next card to be dealt from the array of Cards **/
	int index;

	/** The random seed **/
	int seed;

	/**
	 * The constructor
	 * 
	 * @param seed
	 */
	public Deck(int seed) {
		super();
		this.array_cards = new ArrayList<Card>(CARDS_IN_DECK);
		this.index = 0;
		this.seed = seed;
		for (int i = 2; i < 15; i++) {
			array_cards.add(new Card(i, Card.CLUBS));
		}
		for (int i = 2; i < 15; i++) {
			array_cards.add(new Card(i, Card.DIAMONDS));
		}
		for (int i = 2; i < 15; i++) {
			array_cards.add(new Card(i, Card.HEARTS));
		}
		for (int i = 2; i < 15; i++) {
			array_cards.add(new Card(i, Card.SPADES));
		}
	}

	/**
	 * This method handles resetting the deck for a new hand to be played.
	 */
	public void shuffle() {
		int max = 51;
		int min = 0;
		int index1;
		int index2;
		Random rand;
		if (seed != -1) {
			rand = new Random(seed);
		} else {
			rand = new Random();
		}
		for (int i = 0; i < Deck.SHUFFLE_SWAPS; i++) {
			index1 = rand.nextInt(max) % (max - min + 1) + min;
			index2 = rand.nextInt(max) % (max - min + 1) + min;
			Card tmp = array_cards.get(index1);
			array_cards.set(index1, array_cards.get(index2));
			array_cards.set(index2, tmp);
		}
		index = 0;
	}

	/**
	 * This method returns the next card in the deck based on the instance field
	 * that knows the position within the array where the next card to be dealt
	 * is located.
	 * 
	 * @return the next card.
	 */
	public Card nextCard() {
		return array_cards.get(index++);
	}

	/**
	 * This method returns a String representation of the Deck which will come
	 * in handy for Unit Testing.
	 */
	public String toString() {
		String res = "";
		for (int i = 0; i < CARDS_IN_DECK; i++) {
			res += "card " + i + ": " + array_cards.get(i).toString() + "\n";
		}
		return res;
	}

	/**
	 *  This method returns whether this Deck and o are equal.
	 */
	public boolean equals(Object o) {
		boolean res = o instanceof Deck;
		if (!res)
			return false;
		Deck tmp = (Deck) o;
		if (tmp.array_cards.equals(this.array_cards) && tmp.index == this.index
				&& tmp.seed == this.seed) {
			return true;
		} else {
			return false;
		}
	}
}
