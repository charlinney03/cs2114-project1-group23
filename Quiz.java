package cards;
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
    // ~ Fields ................................................................
    static int questionCount;
    static int userWantsMore;
    // this way so every method in the Quiz class can access and use Scanner
    private static Scanner scanner = new Scanner(System.in);

    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @param args
     */

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    public static void main(String[] args)
    {

        System.out.println(
            "Welcome to Memorix! You will create flashcards and test it. "
                + "You need to make more than four cards to start the quiz.");

        questionCount = 0;
        userWantsMore = -1;

        while (questionCount < 4) // just force user to make 4 cards, no other
                                  // options
        {
            String term = promptForTerm("Enter the terminology of the card: ");
            String def =
                promptForDef("Enter the definition of the terminology: ");
            questionCount++;

            super(term, def); // pass into Deck's constructor

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
                
                super(term, def); // pass into Deck's constructor
            }

            

        }

        // where the code reached this point, user entered all cards. start
        // the quiz.
        
        
        
        

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
     * Place a description of your method here.
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
