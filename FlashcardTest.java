package cards;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Tests the Flashcard class and its public methods.
 * Tests the constructor, getters, difficulty tracking, and toString method.
 *
 * @author Dar Zahiri
 * @version Sep 23, 2026
 */
class FlashcardTest
{

    /**
     * Tests that the constructor correctly stores the term and definition
     * and initializes the difficulty to zero.
     */
    @Test
    void testConstructor()
    {
        Flashcard card = new Flashcard("Array", "A collection of elements");

        assertEquals("Array", card.getTerm());
        assertEquals("A collection of elements", card.getDef());
        assertEquals(0, card.getDifficulty());
    }


    /**
     * Tests that getTerm returns the correct terminology.
     */
    @Test
    void testGetTerm()
    {
        Flashcard card = new Flashcard("Inheritance", "A class receiving properties from another class");

        assertEquals(
            "Inheritance",
            card.getTerm());
    }


    /**
     * Tests that getDef returns the correct definition.
     */
    @Test
    void testGetDef()
    {
        Flashcard card = new Flashcard("Encapsulation", "Hiding internal data");

        assertEquals(
            "Hiding internal data",
            card.getDef());
    }


    /**
     * Tests that getDifficulty initially returns zero.
     */
    @Test
    void testGetDifficulty()
    {
        Flashcard card = new Flashcard("Class", "A blueprint for objects");

        assertEquals(0, card.getDifficulty());
    }


    /**
     * Tests that increaseDifficulty increases the difficulty by one.
     */
    @Test
    void testIncreaseDifficulty()
    {
        Flashcard card = new Flashcard("Object", "An instance of a class");

        card.increaseDifficulty();

        assertEquals(1, card.getDifficulty());

        card.increaseDifficulty();

        assertEquals(2, card.getDifficulty());
    }


    /**
     * Tests that toString returns the term and definition in the
     * expected format.
     */
    @Test
    void testToString()
    {
        Flashcard card = new Flashcard("Polymorphism", "Many forms");

        assertEquals(
            "Polymorphism : Many forms",
            card.toString());
    }
}