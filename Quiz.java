package cards;

import java.util.ArrayList;
import java.util.Scanner; // Import the Scanner Class

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author Andrew Kim
 * @version Sep 20, 2026
 */
public class Quiz
{

    // this way so every method in the Quiz class can access and use Scanner
    private static Scanner scanner = new Scanner(System.in);
    private static Deck deck = new Deck();

    // ~Public Methods ........................................................
    // ----------------------------------------------------------
    /**
     * main method
     * 
     * @param args
     */
    public static void main(String[] args)
    {

        System.out.println(
            "Welcome to Memorix! You will create flashcards and test it. "
                + "You need to make more than four cards to start the quiz.");

        int questionCount = 0;
        int userWantsMore = -1;

        while (questionCount < 4) // just force user to make 4 cards, no other
                                  // options
        {
            String term = promptForTerm("Enter the terminology of the card: ");
            String def =
                promptForDef("Enter the definition of the terminology: ");
            questionCount++;

            deck.add(new Flashcard(term, def));

        }

        // user finished entering four cards. Prompts the user to make more
        // cards or start quiz.

        while (userWantsMore != 0)
        {
            userWantsMore = promptMoreCards(
                "You can make more cards. Input 0 to start the quiz, 1 to make more cards");

            if (userWantsMore == 1)
            {
                String term =
                    promptForTerm("Enter the terminology of the card: ");
                String def =
                    promptForDef("Enter the definition of the terminology: ");
                questionCount++;

                deck.add(new Flashcard(term, def));
            }

        }

        // where the code reached this point, user entered all cards. start
        // the quiz.

        runQuiz(deck);

    }


    private static void runQuiz(Deck currentDeck)
    {
        currentDeck.shuffle();

        Deck missed = new Deck(); // cards the user got wrong, for the next
                                  // round
        int correct = 0;
        int wrong = 0;

        for (int i = 0; i < currentDeck.size(); i++)
        {
            Flashcard card = currentDeck.get(i);
            System.out.print("Term: " + card.getTerm() + "\nYour answer: ");
            String answer = scanner.nextLine();

            if (answer.trim().equalsIgnoreCase(card.getDef().trim()))
            {
                System.out.println("Correct!");
                correct++;
            }
            else
            {
                System.out
                    .println("Incorrect. The answer was: " + card.getDef());
                card.increaseDifficulty();
                missed.add(card);
                wrong++;
            }
        }

        System.out.println(
            "You got " + correct + " correct and " + wrong + " wrong.");

        if (missed.size() > 0)
        {
            System.out.println("Let's review the ones you missed.");
            // shuffle() requires more than 4 cards, so only shuffle if enough
            // remain
            if (missed.size() > 4)
            {
                runQuiz(missed);
            }
            else
            {
                runQuizNoShuffle(missed);
            }
        }
        else
        {
            System.out.println("You got everything right! Great job.");
        }
    }


    private static void runQuizNoShuffle(Deck currentDeck)
    {
        Deck missed = new Deck();
        int correct = 0;
        int wrong = 0;

        for (int i = 0; i < currentDeck.size(); i++)
        {
            Flashcard card = currentDeck.get(i);
            System.out.print("Term: " + card.getTerm() + "\nYour answer: ");
            String answer = scanner.nextLine();

            if (answer.trim().equalsIgnoreCase(card.getDef().trim()))
            {
                System.out.println("Correct!");
                correct++;
            }
            else
            {
                System.out
                    .println("Incorrect. The answer was: " + card.getDef());
                card.increaseDifficulty();
                missed.add(card);
                wrong++;
            }
        }

        System.out.println(
            "You got " + correct + " correct and " + wrong + " wrong.");

        if (missed.size() > 0)
        {
            System.out.println("Let's review the ones you missed.");
            runQuizNoShuffle(missed);
        }
        else
        {
            System.out.println("You got everything right! Great job.");
        }
    }


    // ----------------------------------------------------------
    /**
     * This method will take the terminology of the card
     * 
     * @param term
     * @return input: will passed on to the constructor as terminology
     */
    public static String promptForTerm(String term)
    {
        System.out.print(term);
        String input = scanner.nextLine();
        while (input == null || input.trim().isEmpty())
        {
            System.out.println(
                "Input cannot be null or blank. Please enter valid data.");
            System.out.print(term);
            input = scanner.nextLine();
        }

        return input;
    }


    // ----------------------------------------------------------
    /**
     * This method will take the definition of the card
     * 
     * @param def
     * @return input: will passed on to the constructor as definition
     */
    public static String promptForDef(String def)
    {
        System.out.print(def);
        String input = scanner.nextLine();
        while (input == null || input.trim().isEmpty())
        {
            System.out.println(
                "Input cannot be null or blank. Please enter valid data.");
            System.out.print(def);
            input = scanner.nextLine();
        }

        return input;
    }


    // ----------------------------------------------------------
    /**
     * This method is for asking if the user wants to make more cards, 
     * or start the quiz
     * 
     * @param more
     * @return result
     */
    public static int promptMoreCards(String more)
    {

        System.out.print(more);
        String input = scanner.nextLine();
        while (input == null || (!input.equals("0") && !input.equals("1")))
        {
            System.out.println(
                "Input should be either 0 or 1. Check if there are any blanks.");
            System.out.print(more);
            input = scanner.nextLine();
        }

        int result = Integer.parseInt(input);
        return result;
    }

}
