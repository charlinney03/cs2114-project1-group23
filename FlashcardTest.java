import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class FlashcardTest
{

    @Test
    void testConstructor()
    {
        Flashcard card =
            new Flashcard("Array", "A collection of elements");

        assertEquals("Array", card.getTerm());
        assertEquals("A collection of elements", card.getDef());
        assertEquals(0, card.getDifficulty());
    }


    @Test
    void testGetTerm()
    {
        Flashcard card =
            new Flashcard("Array", "A collection of elements");

        assertEquals("Array", card.getTerm());
    }


    @Test
    void testGetDef()
    {
        Flashcard card =
            new Flashcard("Array", "A collection of elements");

        assertEquals("A collection of elements", card.getDef());
    }


    @Test
    void testGetDifficulty()
    {
        Flashcard card =
            new Flashcard("Array", "A collection of elements");

        assertEquals(0, card.getDifficulty());
    }


    @Test
    void testIncreaseDifficulty()
    {
        Flashcard card =
            new Flashcard("Array", "A collection of elements");

        card.increaseDifficulty();

        assertEquals(1, card.getDifficulty());

        card.increaseDifficulty();

        assertEquals(2, card.getDifficulty());
    }


    @Test
    void testToString()
    {
        Flashcard card =
            new Flashcard("Array", "A collection of elements");

        assertEquals(
            "Array : A collection of elements",
            card.toString());
    }
}