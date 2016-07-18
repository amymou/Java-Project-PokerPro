

/**
 * Program to test Hand class
 * 
 * @author
 */
public class HandTest {

	/**
	 * Starts program
	 * 
	 * @param args
	 *            command line arguments
	 */
	public static void main(String[] args) {

		// Test case for getCard()
		Card[] cards = { new Card(2, 'c'), new Card(4, 's'), new Card(10, 'c'),
				new Card(11, 'h'), new Card(6, 'c') };
		Hand hand = new Hand(cards);
		Card card = hand.getCard(3);
		String id = "Test getCard()";
		String desc = "hand.getCard(3)";
		String expected = "h11";
		String actual = card.toString();
		testResult(id, desc, expected, actual);

		// Test case for replace()
		Card[] replaceCards = { new Card(2, 'c'), new Card(4, 's'),
				new Card(10, 'c'), new Card(10, 's'), new Card(6, 'c') };
		hand = new Hand(replaceCards);
		hand.replace(1, new Card(9, 'd'));
		card = hand.getCard(1);
		id = "Test replace()";
		desc = "hand.replace(1, new Card(9, 'd'))";
		expected = "d9";
		actual = card.toString();
		testResult(id, desc, expected, actual);

		// Test cases for equals
		// Same instance
		hand = new Hand(replaceCards);
		id = "Test equals - same instance";
		desc = "hand.equals(hand)";
		boolean expectedB = true;
		boolean actualB = hand.equals(hand);
		testResult(id, desc, expectedB, actualB);
		// Different instances of same cards
		hand = new Hand(replaceCards);
		Hand hand2 = new Hand(replaceCards);
		id = "Test equals - diff instances";
		desc = "hand.equals(hand2)";
		expectedB = true;
		actualB = hand.equals(hand2);
		testResult(id, desc, expectedB, actualB);

		// Different instances of different cards
		hand = new Hand(replaceCards);
		hand2 = new Hand(cards);
		id = "Test equals - diff instances and cards";
		desc = "hand.equals(hand2)";
		expectedB = false;
		actualB = hand.equals(hand2);
		testResult(id, desc, expectedB, actualB);

		// Test case for toString()
		Card[] toStringCards = { new Card(2, 'c'), new Card(3, 's'),
				new Card(4, 'c'), new Card(10, 's'), new Card(6, 'c') };
		hand = new Hand(toStringCards);
		id = "Test toString()";
		desc = "hand.toString()";
		expected = "[c2, s3, c4, s10, c6]";
		actual = hand.toString();
		testResult(id, desc, expected, actual);

		// Example test cases for isFlush() method
		Card[] flush = { new Card(2, 'c'), new Card(4, 'c'), new Card(10, 'c'),
				new Card(14, 'c'), new Card(6, 'c') };
		hand = new Hand(flush);
		id = "Test isFlush() - true";
		desc = "hand.isFlush()";
		expectedB = true;
		actualB = hand.isFlush();
		testResult(id, desc, expectedB, actualB);

		Card[] notFlush = { new Card(2, 'c'), new Card(4, 's'),
				new Card(10, 'h'), new Card(14, 'c'), new Card(6, 'c') };
		hand = new Hand(notFlush);
		id = "Test isFlush() - false";
		desc = "hand.isFlush()";
		expectedB = false;
		actualB = hand.isFlush();
		testResult(id, desc, expectedB, actualB);

		// Add 16 more test cases here, 2 for each of the other methods that
		// determine the type of hand,
		// 1 test case should return true, the other false

		// test cases for isStraight() method
		Card[] Straight = { new Card(6, 'c'), new Card(7, 'c'),
				new Card(8, 'c'), new Card(9, 'c'), new Card(10, 'c') };
		hand = new Hand(Straight);
		id = "Test isStraight() - true";
		desc = "hand.isStraight()";
		expectedB = true;
		actualB = hand.isStraight();
		testResult(id, desc, expectedB, actualB);

		Card[] notStraight = { new Card(2, 'c'), new Card(4, 's'),
				new Card(10, 'h'), new Card(14, 'c'), new Card(6, 'c') };
		hand = new Hand(notStraight);
		id = "Test isStraight() - false";
		desc = "hand.isStraight()";
		expectedB = false;
		actualB = hand.isStraight();
		testResult(id, desc, expectedB, actualB);

		// test cases for isStraightFlush() method
		Card[] StraightFlush = { new Card(6, 'c'), new Card(7, 'c'),
				new Card(8, 'c'), new Card(9, 'c'), new Card(10, 'c') };
		hand = new Hand(StraightFlush);
		id = "Test isStraightFlush() - true";
		desc = "hand.isStraightFlush()";
		expectedB = true;
		actualB = hand.isStraightFlush();
		testResult(id, desc, expectedB, actualB);

		Card[] notStraightFlush = { new Card(2, 'c'), new Card(3, 's'),
				new Card(4, 'h'), new Card(5, 'c'), new Card(6, 'c') };
		hand = new Hand(notStraightFlush);
		id = "Test isStraightFlush() - false";
		desc = "hand.isStraightFlush()";
		expectedB = false;
		actualB = hand.isStraightFlush();
		testResult(id, desc, expectedB, actualB);

		// test cases for isRoyalFlush() method
		Card[] RoyalFlush = { new Card(10, 'c'), new Card(11, 'c'),
				new Card(12, 'c'), new Card(13, 'c'), new Card(14, 'c') };
		hand = new Hand(RoyalFlush);
		id = "Test isRoyalFlush() - true";
		desc = "hand.isRoyalFlush()";
		expectedB = true;
		actualB = hand.isRoyalFlush();
		testResult(id, desc, expectedB, actualB);

		Card[] notRoyalFlush = { new Card(10, 'c'), new Card(11, 's'),
				new Card(12, 'h'), new Card(13, 'c'), new Card(14, 'c') };
		hand = new Hand(notRoyalFlush);
		id = "Test isRoyalFlush() - false";
		desc = "hand.isRoyalFlush()";
		expectedB = false;
		actualB = hand.isRoyalFlush();
		testResult(id, desc, expectedB, actualB);

		// test cases for hasFourOfAKind() method
		Card[] FourOfAKind = { new Card(6, 'c'), new Card(5, 'c'),
				new Card(6, 'd'), new Card(6, 'h'), new Card(6, 's') };
		hand = new Hand(FourOfAKind);
		id = "Test hasFourOfAKind() - true";
		desc = "hand.hasFourOfAKind()";
		expectedB = true;
		actualB = hand.hasFourOfAKind();
		testResult(id, desc, expectedB, actualB);

		Card[] notFourOfAKind = { new Card(10, 'c'), new Card(11, 's'),
				new Card(12, 'h'), new Card(13, 'c'), new Card(14, 'c') };
		hand = new Hand(notFourOfAKind);
		id = "Test hasFourOfAKind() - false";
		desc = "hand.hasFourOfAKind()";
		expectedB = false;
		actualB = hand.hasFourOfAKind();
		testResult(id, desc, expectedB, actualB);

		// test cases for hasThreeOfAKind() method
		Card[] ThreeOfAKind = { new Card(7, 'c'), new Card(5, 'c'),
				new Card(6, 's'), new Card(6, 'd'), new Card(6, 'c') };
		hand = new Hand(ThreeOfAKind);
		id = "Test hasThreeOfAKind() - true";
		desc = "hand.hasThreeOfAKind()";
		expectedB = true;
		actualB = hand.hasThreeOfAKind();
		testResult(id, desc, expectedB, actualB);

		Card[] notThreeOfAKind = { new Card(2, 'c'), new Card(2, 's'),
				new Card(12, 'h'), new Card(13, 'c'), new Card(14, 'c') };
		hand = new Hand(notThreeOfAKind);
		id = "Test hasThreeOfAKind() - false";
		desc = "hand.hasThreeOfAKind()";
		expectedB = false;
		actualB = hand.hasThreeOfAKind();
		testResult(id, desc, expectedB, actualB);

		// test cases for hasTwoPairs() method
		Card[] TwoPairs = { new Card(7, 'c'), new Card(7, 'd'),
				new Card(6, 'c'), new Card(6, 'd'), new Card(9, 'c') };
		hand = new Hand(TwoPairs);
		id = "Test hasTwoPairs() - true";
		desc = "hand.hasTwoPairs()";
		expectedB = true;
		actualB = hand.hasTwoPairs();
		testResult(id, desc, expectedB, actualB);

		Card[] notTwoPairs = { new Card(2, 'c'), new Card(2, 's'),
				new Card(12, 'h'), new Card(13, 's'), new Card(14, 'c') };
		hand = new Hand(notTwoPairs);
		id = "Test hasTwoPairs() - false";
		desc = "hand.hasTwoPairs()";
		expectedB = false;
		actualB = hand.hasTwoPairs();
		testResult(id, desc, expectedB, actualB);

		// test cases for hasOnePair() method
		Card[] OnePair = { new Card(7, 'c'), new Card(7, 'd'),
				new Card(3, 'c'), new Card(6, 'd'), new Card(9, 'c') };
		hand = new Hand(OnePair);
		id = "Test hasOnePair() - true";
		desc = "hand.hasOnePair()";
		expectedB = true;
		actualB = hand.hasOnePair();
		testResult(id, desc, expectedB, actualB);

		Card[] notOnePair = { new Card(8, 'c'), new Card(2, 's'),
				new Card(12, 'h'), new Card(13, 's'), new Card(14, 'c') };
		hand = new Hand(notOnePair);
		id = "Test hasOnePair() - false";
		desc = "hand.hasOnePair()";
		expectedB = false;
		actualB = hand.hasOnePair();
		testResult(id, desc, expectedB, actualB);

		// test cases for isFullHouse() method
		Card[] FullHouse = { new Card(2, 'c'), new Card(2, 'd'),
				new Card(3, 'c'), new Card(3, 'd'), new Card(3, 's') };
		hand = new Hand(FullHouse);
		id = "Test isFullHouse() - true";
		desc = "hand.isFullHouse()";
		expectedB = true;
		actualB = hand.isFullHouse();
		testResult(id, desc, expectedB, actualB);

		Card[] notFullHouse = { new Card(8, 'c'), new Card(2, 's'),
				new Card(12, 'h'), new Card(13, 's'), new Card(14, 'c') };
		hand = new Hand(notFullHouse);
		id = "Test isFullHouse() - false";
		desc = "hand.isFullHouse()";
		expectedB = false;
		actualB = hand.isFullHouse();
		testResult(id, desc, expectedB, actualB);

		// Invalid parameter test cases are provided for you below - You do NOT
		// need to add additional invalid tests. Just make sure these
		// pass!
		Card[] oneCard = { new Card(2, 'c') };
		id = "Test Hand Constructor Illegal Argument";
		desc = "new Hand(oneCard)";
		try {
			hand = new Hand(oneCard);
			actual = hand.toString();
		} catch (IllegalArgumentException e) {
			actual = e.getClass().toString();
		}
		expected = "class java.lang.IllegalArgumentException";
		testResult(id, desc, expected, actual);

		Card[] nullCard = { new Card(2, 'c'), null, new Card(10, 'h'),
				new Card(14, 'c'), new Card(6, 'c') };
		id = "Test Hand Constructor null Card";
		desc = "new Hand(nullCard)";
		try {
			hand = new Hand(nullCard);
			actual = hand.toString();
		} catch (NullPointerException e) {
			actual = e.getClass().toString();
		}
		expected = "class java.lang.NullPointerException";
		testResult(id, desc, expected, actual);

		Card[] badIndex = { new Card(2, 'c'), new Card(4, 's'),
				new Card(10, 'c'), new Card(11, 'h'), new Card(6, 'c') };
		hand = new Hand(badIndex);
		id = "Test getCard - bad index";
		desc = "hand.getCard(5)";
		try {
			card = hand.getCard(5);
			actual = card.toString();
		} catch (IllegalArgumentException e) {
			actual = e.getClass().toString();
		}
		expected = "class java.lang.IllegalArgumentException";
		testResult(id, desc, expected, actual);

		Card[] badIndexReplaceCards = { new Card(2, 'c'), new Card(4, 's'),
				new Card(10, 'c'), new Card(11, 'h'), new Card(6, 'c') };
		hand = new Hand(badIndexReplaceCards);
		card = new Card(4, 'c');
		id = "Test replace - bad index";
		desc = "hand.replace(7, card)";
		try {
			hand.replace(7, card);
		} catch (IllegalArgumentException e) {
			actual = e.getClass().toString();
		}
		expected = "class java.lang.IllegalArgumentException";
		testResult(id, desc, expected, actual);

		Card[] badCardReplaceCards = { new Card(2, 'c'), new Card(4, 's'),
				new Card(10, 'c'), new Card(11, 'h'), new Card(6, 'c') };
		hand = new Hand(badCardReplaceCards);
		id = "Test replace - null";
		desc = "hand.replace(3, null)";
		try {
			hand.replace(3, null);
		} catch (NullPointerException e) {
			actual = e.getClass().toString();
		}
		expected = "class java.lang.NullPointerException";
		testResult(id, desc, expected, actual);
	}

	/**
	 * Prints the test information.
	 * 
	 * @param id
	 *            id of the test
	 * @param desc
	 *            description of the test (e.g., method call)
	 * @param exp
	 *            expected result of the test
	 * @param act
	 *            actual result of the test
	 */
	private static void testResult(String id, String desc, String exp,
			String act) {
		System.out.printf("\n%-40s%-35s%-45s%-45s%-10s\n", id, desc, exp, act,
				exp.equals(act));
	}

	/**
	 * Prints the test information.
	 * 
	 * @param id
	 *            id of the test
	 * @param desc
	 *            description of the test (e.g., method call)
	 * @param exp
	 *            expected result of the test
	 * @param act
	 *            actual result of the test
	 */
	private static void testResult(String id, String desc, boolean exp,
			boolean act) {
		System.out.printf("\n%-40s%-35s%-45s%-45s%-10s\n", id, desc, exp, act,
				exp == act);
	}
}