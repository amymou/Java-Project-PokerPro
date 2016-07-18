

public class Card implements Comparable<Card> {

	public static final char CLUBS = 'c';
	public static final char DIAMONDS = 'd';
	public static final char SPADES = 's';
	public static final char HEARTS = 'h';
	public static final int LOWEST_VALUE = 2;
	public static final int HIGHEST_VALUE = 14;

	/** The value shown on the card **/
	private int value;

	/** The suit shown on the card **/
	private char suit;

	/**
	 * This method is used for sorting the cards in a player's hand in a game of
	 * Poker. Cards are sorted first by value, then by suit.
	 * 
	 * @param other
	 *            The Card object to which this Card is being compared.
	 * @return negative value if this Card should be before the other Card,
	 *         positive value if this Card should be after the other Card.
	 */
	public int compareTo(Card other) {
		if (this.value != other.value) {
			return this.value - other.value;
		} else {
			return this.suit - other.suit;
		}
	}

	/**
	 * the constructor
	 * 
	 * @param value
	 *            The value shown on the card
	 * @param suit
	 *            The suit shown on the card
	 */
	public Card(int value, char suit) {
		super();
		this.value = value;
		this.suit = suit;
	}

	/**
	 * The getter method for the instance field that knows the value of the
	 * card.
	 * 
	 * @return The value shown on the card
	 */
	public int getValue() {
		return value;
	}

	/**
	 * the getter method for the instance field that knows the suit of the card.
	 * 
	 * @return The suit shown on the card
	 */
	public char getSuit() {
		return suit;
	}

	/**
	 * This method returns the the first letter of the suit (lowercase) followed
	 * by the numeric value of the card.
	 */
	@Override
	public String toString() {
		return "" + suit + value;
	}

	/**
	 * This method returns whether this Card and o are equal. If o is not a
	 * Card, the method should return false. Cards are considered equal if they
	 * have the same value and same suit.
	 */
	public boolean equals(Object o) {
		boolean res = o instanceof Card;
		if (!res)
			return false;
		Card tmp = (Card) o;
		if (tmp.suit == this.suit && tmp.value == this.value)
			return true;
		else
			return false;
	}

	/**
	 * Main for test.
	 * @param args
	 */
	public static void main(String[] args) {
		Card ct1 = new Card(2, 'c');
		Card ct2 = new Card(3, Card.DIAMONDS);
		Card ct3 = new Card(2, 'c');
		System.out.println(ct1.getSuit());
		System.out.println(ct1.getValue());
		System.out.println(ct1.toString());
		System.out.println(ct1.compareTo(ct2));
		System.out.println(ct1.equals(ct2));
		System.out.println(ct1.equals(ct3));
	}
}
