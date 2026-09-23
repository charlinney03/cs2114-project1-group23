package cards;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.junit.jupiter.api.Test;

class QuizTest
{

    @Test
    void testPromptForTerm()
    {
        InputStream original = System.in;

        try
        {
            System.setIn(
                new ByteArrayInputStream("Array\n".getBytes()));

            assertEquals("Array", Quiz.promptForTerm("Enter term: "));
        }
        finally
        {
            System.setIn(original);
        }
    }


    @Test
    void testPromptForDef()
    {
        InputStream original = System.in;

        try
        {
            System.setIn(
                new ByteArrayInputStream(
                    "A collection of elements\n".getBytes()));

            assertEquals(
                "A collection of elements",
                Quiz.promptForDef("Enter definition: "));
        }
        finally
        {
            System.setIn(original);
        }
    }


    @Test
    void testPromptMoreCardsZero()
    {
        InputStream original = System.in;

        try
        {
            System.setIn(
                new ByteArrayInputStream("0\n".getBytes()));

            assertEquals(0, Quiz.promptMoreCards("More? "));
        }
        finally
        {
            System.setIn(original);
        }
    }


    @Test
    void testPromptMoreCardsOne()
    {
        InputStream original = System.in;

        try
        {
            System.setIn(
                new ByteArrayInputStream("1\n".getBytes()));

            assertEquals(1, Quiz.promptMoreCards("More? "));
        }
        finally
        {
            System.setIn(original);
        }
    }
}