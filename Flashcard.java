package cards;

/*
 * Flashcard class represents a flashcard with one term and one definition that
 * tracks its own difficulty.
 */
// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author user
 *  @version Sep 23, 2026
 */
public class Flashcard
{

    private String term;
    private String def;
    private int difficulty;


    // ----------------------------------------------------------
    /**
     * Create a new Flashcard object.
     * @param term
     * @param def
     */
    public Flashcard(String term, String def) {
        
        this.term = term;
        this.def = def;
        difficulty = 0;
    }


    /*
     * Gets term
     */
    public String getTerm()
    {
        return term;
    }


    /*
     * Gets def
     */
    public String getDef()
    {
        return def;
    }


    /*
     * Gets difficulty
     */
    public int getDifficulty()
    {
        return difficulty;
    }


    /*
     * Increases difficulty of card
     */
    public void increaseDifficulty()
    {
        difficulty++;
    }


    /*
     * Turns term and def into string
     */
    @Override
    public String toString()
    {
        return term + " : " + def;
    }
}
