

public class PokerModel {

	public static final int RANDOM_GAME = -1;
	public static final int CARDS_IN_HAND = 5;
	public static final int STARTING_POINTS = 100;
	public static final int POINTS_FOR_NEW_GAME = 10;
	public static final int ROYAL_FLUSH = 100;
	public static final int STRAIGHT_FLUSH = 60;
	public static final int FOUR_OF_A_KIND = 50;
	public static final int FULL_HOUSE = 40;
	public static final int FLUSH = 30;
	public static final int STRAIGHT = 25;
	public static final int THREE_OF_A_KIND = 15;
	public static final int TWO_PAIRS = 10;
	public static final int ONE_PAIR = 7;

	/** The Deck of cards that will be used to play the game **/
	Deck deck;

	/** The Hand of Cards in the game **/
	Hand hand;

	/** the current number of points **/
	int points;

	/**
	 * Creates a deck using the seed. Sets points to STARTING_POINTS
	 * 
	 * @param seed
	 */
	public PokerModel(int seed) {
		deck = new Deck(seed);
		points = STARTING_POINTS;
	}

	/**
	 * Returns the number of points
	 * 
	 * @return
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Returns the name of the image file for the Card at the given index in the
	 * hand.
	 * 
	 * @param index
	 * @return
	 */
	public String getCardFileName(int index) {
		return "cards/" + hand.getCard(index).toString() + ".gif";
	}

	/**
	 * Returns the card at the given index in the hand.
	 * 
	 * @param index
	 * @return
	 */
	public Card getCard(int index) {
		return hand.getCard(index);
	}

	/**
	 * Subtracts POINTS_FOR_NEW_GAME from points and shuffles the deck. A new
	 * array of CARDS_IN_HAND Cards is created and filled by calling the deck
	 * nextCard() method CARDS_IN_HAND times. The Card array is used to create a
	 * new Hand.
	 */
	public void newGame() {
		this.points -= POINTS_FOR_NEW_GAME;
		deck.shuffle();
		Card[] CARDS_IN_HAND = new Card[Hand.CARDS_IN_HAND];
		for (int i = 0; i < Hand.CARDS_IN_HAND; i++) {
			CARDS_IN_HAND[i] = deck.nextCard();
		}
		hand = new Hand(CARDS_IN_HAND);
	}

	/**
	 * Gets the next Card from the deck and requests the hand to replace the
	 * card at the given index with the new Card.
	 * 
	 * @param index
	 */
	public void replaceCard(int index) {
		hand.replace(index, deck.nextCard());
	}

	/**
	 * Returns the String given below and adds the correct number of points to
	 * the total points based on the type of hand.
	 * 
	 * @return
	 */
	public String scoreHand() {
		if (hand.isRoyalFlush()) {
			this.points += ROYAL_FLUSH;
			return "Royal Flush";
		} else if (hand.isStraightFlush()) {
			this.points += STRAIGHT_FLUSH;
			return "Straight Flush";
		} else if (hand.hasFourOfAKind()) {
			this.points += FOUR_OF_A_KIND;
			return "Four of a Kind";
		} else if (hand.isFullHouse()) {
			this.points += FULL_HOUSE;
			return "Full House";
		} else if (hand.isFlush()) {
			this.points += FLUSH;
			return "Flush";
		} else if (hand.isStraight()) {
			this.points += STRAIGHT;
			return "Straight";
		} else if (hand.hasThreeOfAKind()) {
			this.points += THREE_OF_A_KIND;
			return "Three of a Kind";
		} else if (hand.hasTwoPairs()) {
			this.points += TWO_PAIRS;
			return "Two Pairs";
		} else if (hand.hasOnePair()) {
			this.points += ONE_PAIR;
			return "One Pair";
		} else {
			return "No Pair";

		}
	}
}
