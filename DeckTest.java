package cards;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class DeckTest
{

    @Test
    void testEmptyDeck()
    {
        Deck deck = new Deck();

        assertEquals(0, deck.size());
    }


    @Test
    void testAdd()
    {
        Deck deck = new Deck();
        Flashcard card = new Flashcard("Term", "Definition");

        deck.add(card);

        assertEquals(1, deck.size());
        assertSame(card, deck.get(0));
    }


    @Test
    void testGet()
    {
        Deck deck = new Deck();
        Flashcard card = new Flashcard("Term", "Definition");

        deck.add(card);

        assertEquals(card, deck.get(0));
    }


    @Test
    void testSize()
    {
        Deck deck = new Deck();

        deck.add(new Flashcard("Term 1", "Definition 1"));
        deck.add(new Flashcard("Term 2", "Definition 2"));

        assertEquals(2, deck.size());
    }


    @Test
    void testListConstructor()
    {
        ArrayList<Flashcard> list = new ArrayList<>();

        Flashcard card1 = new Flashcard("Term 1", "Definition 1");
        Flashcard card2 = new Flashcard("Term 2", "Definition 2");

        list.add(card1);
        list.add(card2);

        Deck deck = new Deck(list);

        assertEquals(2, deck.size());
        assertSame(card1, deck.get(0));
        assertSame(card2, deck.get(1));
    }


    @Test
    void testShuffleTooFewCards()
    {
        Deck deck = new Deck();

        deck.add(new Flashcard("Term 1", "Definition 1"));
        deck.add(new Flashcard("Term 2", "Definition 2"));
        deck.add(new Flashcard("Term 3", "Definition 3"));

        assertThrows(
            IllegalArgumentException.class,
            () -> deck.shuffle());
    }


    @Test
    void testShuffle()
    {
        Deck deck = new Deck();

        Flashcard card1 = new Flashcard("Term 1", "Definition 1");
        Flashcard card2 = new Flashcard("Term 2", "Definition 2");
        Flashcard card3 = new Flashcard("Term 3", "Definition 3");
        Flashcard card4 = new Flashcard("Term 4", "Definition 4");

        deck.add(card1);
        deck.add(card2);
        deck.add(card3);
        deck.add(card4);

        deck.shuffle();

        assertEquals(4, deck.size());

        assertTrue(deck.get(0) == card1
            || deck.get(0) == card2
            || deck.get(0) == card3
            || deck.get(0) == card4);
    }
}