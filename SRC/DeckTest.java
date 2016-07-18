
/**
 * Program to test Deck class
 * 
 * @author
 */
public class DeckTest {
    /**
     * Starts program
     * 
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {

        // Test that all 52 cards are not null
        Deck deck = new Deck(1);
        deck.shuffle();
        String id = "Test that all 52 cards are not null";
        String desc = "All cards not null";
        boolean expectedB = true;
        boolean actualB = true;
        try {
            for (int i = 0; i < Deck.CARDS_IN_DECK; i++) {
                if (deck.nextCard() == null) {
                    actualB = false;
                }
            }
        } catch (Exception e) {
            actualB = false;
        }
        testResult(id, desc, expectedB, actualB);

        // Test that deck is created in correct order
        deck = new Deck(1);
        id = "Test that deck created in correct order";
        desc = "Created in correct order";
        expectedB = true;
        actualB = true;
        try {
            char suit = Card.CLUBS;
            int value = Card.LOWEST_VALUE;
            for (int i = 0; i < Deck.CARDS_IN_DECK; i++) {
                if (i == Deck.CARDS_IN_DECK/4 ) {
                    suit = Card.DIAMONDS;
                    value = Card.LOWEST_VALUE;
                }
                if (i == 2 * Deck.CARDS_IN_DECK/4 ) {
                    suit = Card.HEARTS;
                    value = Card.LOWEST_VALUE;
                }
                if (i == 3 * Deck.CARDS_IN_DECK/4 ) {
                    suit = Card.SPADES;
                    value = Card.LOWEST_VALUE;
                }
                Card c = deck.nextCard();
                if (c.getValue() != value || c.getSuit() != suit) {
                
                    actualB = false;
                }
                value++;
            }
        } catch (Exception e) {
            actualB = false;
        }
        testResult(id, desc, expectedB, actualB);

        // Test that each card is unique
        deck = new Deck(1);
        id = "Test that each card is unique";
        desc = "All cards unique";
        expectedB = true;
        actualB = true;
        try {
            for (int i = 0; i < Deck.CARDS_IN_DECK; i++) {
                Card c1 = deck.nextCard();
                int count = 0; // count for number of matches - expect 1
                Deck deckOther = new Deck(1);
                for (int j = 0; j < Deck.CARDS_IN_DECK; j++) {
                    Card c2 = deckOther.nextCard();
                    if (c1.equals(c2)) {
                        count++;
                    }
                }
                if (count != 1) {
                    actualB = false;
                }
            }
        } catch (Exception e) {
            actualB = false;
        }
        testResult(id, desc, expectedB, actualB);

        // Tests equals method
        Deck deck1 = new Deck(5);
        Deck deck2 = new Deck(5);
        id = "Test equals true - different instances";
        desc = "deck1.equals(deck2)";
        expectedB = true;
        actualB = deck1.equals(deck2);
        testResult(id, desc, expectedB, actualB);

        deck1 = new Deck(5);
        id = "Test equals true - same instances";
        desc = "deck1.equals(deck1)";
        expectedB = true;
        actualB = deck1.equals(deck1);
        testResult(id, desc, expectedB, actualB);

        deck1 = new Deck(5);
        deck2 = new Deck(5);
        deck1.shuffle();
        id = "Test equals false - one shuffled";
        desc = "deck1.equals(deck2)";
        expectedB = false;
        actualB = deck1.equals(deck2);
        testResult(id, desc, expectedB, actualB);

        deck1 = new Deck(5);
        deck2 = new Deck(5);
        deck1.shuffle();
        deck2.shuffle();
        id = "Test equals true - both shuffled";
        desc = "deck1.equals(deck2)";
        expectedB = true;
        actualB = deck1.equals(deck2);
        testResult(id, desc, expectedB, actualB);

        // Test toString
        deck1 = new Deck(5);
        id = "Test toString()";
        desc = "deck1.toString()";
        expectedB = true;
        String expected = "card 0: c2\n" + "card 1: c3\n" + "card 2: c4\n"
                + "card 3: c5\n" + "card 4: c6\n" + "card 5: c7\n"
                + "card 6: c8\n" + "card 7: c9\n" + "card 8: c10\n"
                + "card 9: c11\n" + "card 10: c12\n" + "card 11: c13\n"
                + "card 12: c14\n" + "card 13: d2\n" + "card 14: d3\n"
                + "card 15: d4\n" + "card 16: d5\n" + "card 17: d6\n"
                + "card 18: d7\n" + "card 19: d8\n" + "card 20: d9\n"
                + "card 21: d10\n" + "card 22: d11\n" + "card 23: d12\n"
                + "card 24: d13\n" + "card 25: d14\n" + "card 26: h2\n"
                + "card 27: h3\n" + "card 28: h4\n" + "card 29: h5\n"
                + "card 30: h6\n" + "card 31: h7\n" + "card 32: h8\n"
                + "card 33: h9\n" + "card 34: h10\n" + "card 35: h11\n"
                + "card 36: h12\n" + "card 37: h13\n" + "card 38: h14\n"
                + "card 39: s2\n" + "card 40: s3\n" + "card 41: s4\n"
                + "card 42: s5\n" + "card 43: s6\n" + "card 44: s7\n"
                + "card 45: s8\n" + "card 46: s9\n" + "card 47: s10\n"
                + "card 48: s11\n" + "card 49: s12\n" + "card 50: s13\n"
                + "card 51: s14";
        String actual = deck1.toString().trim();
        actualB = expected.equals(actual);
        testResult(id, desc, expectedB, actualB);

        // Test nextCard
        deck1 = new Deck(5);
        id = "Test nextCard";
        desc = "deck1.nextCard()";
        Card expectedC = new Card(2, 'c');
        Card actualC = deck1.nextCard();
        testResult(id, desc, expectedC, actualC);

        deck1 = new Deck(5);
        id = "Test nextCard";
        desc = "deck1.nextCard() * 2";
        expectedC = new Card(3, 'c');
        actualC = deck1.nextCard();
        actualC = deck1.nextCard();
        testResult(id, desc, expectedC, actualC);

        // Add 2 more test cases here for nextCard
        deck1 = new Deck(5);
        id = "Test nextCard";
        desc = "deck1.nextCard() * 3";
        expectedC = new Card(4, 'c');
        actualC = deck1.nextCard();
        actualC = deck1.nextCard();
        actualC = deck1.nextCard();
        testResult(id, desc, expectedC, actualC);
        
        deck1 = new Deck(5);
        id = "Test nextCard";
        desc = "deck1.nextCard() * 4";
        expectedC = new Card(5, 'c');
        actualC = deck1.nextCard();
        actualC = deck1.nextCard();
        actualC = deck1.nextCard();
        actualC = deck1.nextCard();
        testResult(id, desc, expectedC, actualC);


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
    private static void testResult(String id, String desc, Card exp, Card act) {
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











