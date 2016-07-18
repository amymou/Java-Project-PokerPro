

import java.util.Arrays;

public class Hand {

	private Card[] hand;
	public static final int CARDS_IN_HAND = 5;

	/**
	 * Counts the number of cards with each value in the hand
	 * 
	 * @return tally array containing number of cards of each value from 2 to
	 *         14.
	 */
	public int[] getCounts() {
		int[] counts = new int[Card.HIGHEST_VALUE + 1];
		for (int i = 0; i < hand.length; i++) {
			counts[hand[i].getValue()]++;
		}
		return counts;
	}

	/**
	 * Creates a copy of the hand sorted first by value, then by suit
	 * 
	 * @return copy of the hand sorted first by value, then by suit
	 */
	public Card[] getSortedHand() {
		Card[] sortedHand = Arrays.copyOf(hand, hand.length);
		Arrays.sort(sortedHand);
		return sortedHand;
	}

	/**
	 * The constructor
	 * 
	 * @param hand
	 *            an array of Cards
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	public Hand(Card[] hand) throws IllegalArgumentException,
			NullPointerException {
		super();
		if (hand.length != Hand.CARDS_IN_HAND) {
			throw new IllegalArgumentException("IllegalArgumentException");
		} else {
			for (int i = 0; i < Hand.CARDS_IN_HAND; i++) {
				if (hand[i] == null) {
					throw new NullPointerException("NullPointerException");
				}
			}
		}
		this.hand = hand;
	}

	/**
	 * This method simply returns the card from the hand array at the index
	 * specified by the parameter.
	 * 
	 * @param index
	 * @return
	 * @throws IllegalArgumentException
	 */
	public Card getCard(int index) throws IllegalArgumentException {
		if (index < 0 || index >= Hand.CARDS_IN_HAND)
			throw new IllegalArgumentException("IllegalArgumentException");
		return hand[index];
	}

	/**
	 * This method replaces the card at the given index in the hand array with
	 * the card passed to the method.
	 * 
	 * @param index
	 *            The position for replace
	 * @param card
	 *            The card for replace
	 * @throws IllegalArgumentException
	 * @throws NullPointerException
	 */
	public void replace(int index, Card card) throws IllegalArgumentException,
			NullPointerException {
		if (index < 0 || index >= Hand.CARDS_IN_HAND) {
			throw new IllegalArgumentException("IllegalArgumentException");
		}
		if (card == null)
			throw new NullPointerException("NullPointerException");
		hand[index] = card;
	}

	/**
	 * This method creates a String representation of the hand, for example,
	 * [c2, h12, d8, s2, c13]
	 */
	public String toString() {
		String res = "[";
		for (int i = 0; i < Hand.CARDS_IN_HAND; i++) {
			res += hand[i].toString() + ", ";
		}
		res = res.substring(0, res.length() - 2);
		res += "]";
		return res;
	}

	/**
	 * This method returns whether this Hand and o are equal.
	 */
	public boolean equals(Object o) {
		boolean res = o instanceof Hand;
		if (!res)
			return false;
		Hand tmp = (Hand) o;
		Card[] a = this.getSortedHand();
		Card[] b = tmp.getSortedHand();
		for (int i = 0; i < Hand.CARDS_IN_HAND; i++) {
			if (!a[i].equals(b[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns true if all the cards in the hand have the same suit; false
	 * otherwise.
	 * 
	 * @return
	 */
	public boolean isFlush() {
		char suit1 = hand[0].getSuit();
		for (int i = 1; i < Hand.CARDS_IN_HAND; i++) {
			if (hand[i].getSuit() != suit1)
				return false;
		}
		return true;
	}

	/**
	 * Returns true if the values of the cards in the hand are in sequence, for
	 * example, 6, 7, 8, 9 10; false otherwise.
	 * 
	 * @return
	 */
	public boolean isStraight() {
		Card[] tmp = this.getSortedHand();
		for (int i = 0; i < Hand.CARDS_IN_HAND - 1; i++) {
			if ((tmp[i].getValue() + 1) != tmp[i + 1].getValue())
				return false;
		}
		return true;
	}

	/**
	 * Returns true if the cards in the hand have the same suit and are in
	 * sequence; false otherwise.
	 * 
	 * @return
	 */
	public boolean isStraightFlush() {
		return isFlush() && isStraight();
	}

	/**
	 * Returns true if the cards in the hand have the same suit and the values
	 * 10, 11, 12, 13, 14; false otherwise.
	 * 
	 * @return
	 */
	public boolean isRoyalFlush() {
		if (!isFlush())
			return false;
		Card[] tmp = this.getSortedHand();
		for (int i = 0; i < Hand.CARDS_IN_HAND; i++) {
			if (tmp[i].getValue() != i + 10)
				return false;
		}
		return true;
	}

	/**
	 * Returns true if the hand has four cards with the same value; false
	 * otherwise.
	 * 
	 * @return
	 */
	public boolean hasFourOfAKind() {
		int[] counts = this.getCounts();
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] == 4)
				return true;
		}
		return false;
	}

	/**
	 * Returns true if the hand has exactly three cards with the same value;
	 * false otherwise.
	 * 
	 * @return
	 */
	public boolean hasThreeOfAKind() {
		int[] counts = this.getCounts();
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] == 3)
				return true;
		}
		return false;
	}

	/**
	 * Returns true if the hand has exactly two pairs (two cards with the same
	 * value, two cards with the same, but a different value from the first
	 * pair, and a card whose value is not the same as that of either pair);
	 * false otherwise.
	 * 
	 * @return
	 */
	public boolean hasTwoPairs() {
		int[] counts = this.getCounts();
		int count = 0;
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] == 2)
				count++;
		}
		if (count == 2)
			return true;
		return false;
	}

	/**
	 * Returns true if the hand contains exactly one pair (two cards with the
	 * same value); false otherwise. For example, the hands [c2, d2, c5, d5, h5]
	 * and [c2, d2, c5, d4, h10] would be considered to contain exactly one
	 * pair; the hand [c2, d2, c5, d5, h10] would not.
	 * 
	 * @return
	 */
	public boolean hasOnePair() {
		int[] counts = this.getCounts();
		int count = 0;
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] == 2)
				count++;
		}
		if (count == 1)
			return true;
		return false;
	}

	/**
	 * Returns true if the hand contains three cards with the same value and two
	 * other cards with the same value, but different from that of the three
	 * cards, for example, [c2, d2, c5, d5, h5]; false otherwise.
	 * 
	 * @return
	 */
	public boolean isFullHouse() {
		if (hasOnePair() && hasThreeOfAKind())
			return true;
		return false;
	}
}
