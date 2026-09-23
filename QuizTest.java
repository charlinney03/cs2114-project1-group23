package cards;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

/**
 * Tests the public input methods in the Quiz class.
 * Tests entering terminology, definitions, and the user's choice
 * to create more cards or begin the quiz.
 *
 * @author Dar Zahiri
 * @version Sep 23, 2026
 */
class QuizTest
{

    /**
     * Replaces the Quiz class's Scanner with a Scanner containing
     * controlled test input.
     *
     * @param input the input that should be provided to the Quiz
     * @throws Exception if the Scanner field cannot be accessed
     */
    private void setInput(String input)
        throws Exception
    {
        Field scannerField = Quiz.class.getDeclaredField("scanner");
        scannerField.setAccessible(true);

        Scanner testScanner = new Scanner(
            new ByteArrayInputStream(
                input.getBytes(StandardCharsets.UTF_8)));

        scannerField.set(null, testScanner);
    }


    /**
     * Tests that promptForTerm returns a valid terminology entered
     * by the user.
     */
    @Test
    void testPromptForTerm()
        throws Exception
    {
        setInput("Array\n");

        assertEquals(
            "Array",
            Quiz.promptForTerm("Enter term: "));
    }


    /**
     * Tests that promptForTerm rejects blank input and continues
     * until valid terminology is entered.
     */
    @Test
    void testPromptForTermRejectsBlank()
        throws Exception
    {
        setInput("\nArray\n");

        assertEquals(
            "Array",
            Quiz.promptForTerm("Enter term: "));
    }


    /**
     * Tests that promptForDef returns a valid definition entered
     * by the user.
     */
    @Test
    void testPromptForDef()
        throws Exception
    {
        setInput("A collection of elements\n");

        assertEquals(
            "A collection of elements",
            Quiz.promptForDef("Enter definition: "));
    }


    /**
     * Tests that promptForDef rejects blank input and continues
     * until a valid definition is entered.
     */
    @Test
    void testPromptForDefRejectsBlank()
        throws Exception
    {
        setInput("\nA collection of elements\n");

        assertEquals(
            "A collection of elements",
            Quiz.promptForDef("Enter definition: "));
    }


    /**
     * Tests that promptMoreCards returns zero when the user chooses
     * to start the quiz.
     */
    @Test
    void testPromptMoreCardsZero()
        throws Exception
    {
        setInput("0\n");

        assertEquals(
            0,
            Quiz.promptMoreCards("More cards? "));
    }


    /**
     * Tests that promptMoreCards returns one when the user chooses
     * to create another card.
     */
    @Test
    void testPromptMoreCardsOne()
        throws Exception
    {
        setInput("1\n");

        assertEquals(
            1,
            Quiz.promptMoreCards("More cards? "));
    }


    /**
     * Tests that promptMoreCards rejects an invalid choice and
     * continues until the user enters either zero or one.
     */
    @Test
    void testPromptMoreCardsRejectsInvalidInput()
        throws Exception
    {
        setInput("2\n1\n");

        assertEquals(
            1,
            Quiz.promptMoreCards("More cards? "));
    }
}