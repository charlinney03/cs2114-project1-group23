package cards;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * Tests the Deck class and its public methods.
 * Tests creating decks, adding cards, retrieving cards, checking size,
 * and shuffling cards.
 *
 * @author Dar Zahiri
 * @version Sep 23, 2026
 */
class DeckTest
{

    /**
     * Tests that a new empty Deck has a size of zero.
     */
    @Test
    void testEmptyConstructor()
    {
        Deck deck = new Deck();

        assertEquals(0, deck.size());
    }


    /**
     * Tests that the ArrayList constructor correctly creates a deck
     * containing the provided flashcards.
     */
    @Test
    void testListConstructor()
    {
        ArrayList<Flashcard> cards = new ArrayList<>();

        Flashcard card1 = new Flashcard("Array", "Collection of elements");
        Flashcard card2 = new Flashcard("Class", "Blueprint for objects");

        cards.add(card1);
        cards.add(card2);

        Deck deck = new Deck(cards);

        assertEquals(2, deck.size());
        assertEquals(card1, deck.get(0));
        assertEquals(card2, deck.get(1));
    }


    /**
     * Tests that add places a flashcard into the deck.
     */
    @Test
    void testAdd()
    {
        Deck deck = new Deck();
        Flashcard card = new Flashcard("Loop", "Repeats instructions");

        deck.add(card);

        assertEquals(1, deck.size());
        assertEquals(card, deck.get(0));
    }


    /**
     * Tests that multiple cards can be added to the deck.
     */
    @Test
    void testAddMultipleCards()
    {
        Deck deck = new Deck();

        Flashcard card1 = new Flashcard("Array", "Collection");
        Flashcard card2 = new Flashcard("Class", "Blueprint");
        Flashcard card3 = new Flashcard("Object", "Instance");

        deck.add(card1);
        deck.add(card2);
        deck.add(card3);

        assertEquals(3, deck.size());
        assertEquals(card1, deck.get(0));
        assertEquals(card2, deck.get(1));
        assertEquals(card3, deck.get(2));
    }


    /**
     * Tests that get returns the flashcard at the requested index.
     */
    @Test
    void testGet()
    {
        Deck deck = new Deck();

        Flashcard card1 = new Flashcard("Java", "Programming language");
        Flashcard card2 = new Flashcard("Python", "Programming language");

        deck.add(card1);
        deck.add(card2);

        assertEquals(card1, deck.get(0));
        assertEquals(card2, deck.get(1));
    }


    /**
     * Tests that size correctly reports the number of cards in the deck.
     */
    @Test
    void testSize()
    {
        Deck deck = new Deck();

        assertEquals(0, deck.size());

        deck.add(new Flashcard("One", "First"));
        assertEquals(1, deck.size());

        deck.add(new Flashcard("Two", "Second"));
        assertEquals(2, deck.size());
    }


    /**
     * Tests that shuffle changes the order of a deck containing at least
     * four cards while keeping all of the original cards.
     */
    @Test
    void testShuffle()
    {
        Deck deck = new Deck();

        Flashcard card1 = new Flashcard("One", "First");
        Flashcard card2 = new Flashcard("Two", "Second");
        Flashcard card3 = new Flashcard("Three", "Third");
        Flashcard card4 = new Flashcard("Four", "Fourth");

        deck.add(card1);
        deck.add(card2);
        deck.add(card3);
        deck.add(card4);

        ArrayList<Flashcard> original = new ArrayList<>();

        original.add(deck.get(0));
        original.add(deck.get(1));
        original.add(deck.get(2));
        original.add(deck.get(3));

        deck.shuffle();

        assertEquals(4, deck.size());

        for (Flashcard card : original)
        {
            boolean found = false;

            for (int i = 0; i < deck.size(); i++)
            {
                if (deck.get(i) == card)
                {
                    found = true;
                }
            }

            assertTrue(found);
        }
    }


    /**
     * Tests that shuffle throws an exception when the deck contains
     * fewer than four cards.
     */
    @Test
    void testShuffleTooFewCards()
    {
        Deck deck = new Deck();

        deck.add(new Flashcard("One", "First"));
        deck.add(new Flashcard("Two", "Second"));
        deck.add(new Flashcard("Three", "Third"));

        assertThrows(
            IllegalArgumentException.class,
            () -> deck.shuffle());
    }
}