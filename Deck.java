package cards;

import java.util.ArrayList;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author user
 * @version Sep 23, 2026
 */
public class Deck
{

    private ArrayList<Flashcard> cards;

    // ----------------------------------------------------------
    /**
     * Create a new empty Deck
     */
    public Deck()
    {
        this.cards = new ArrayList<>();
    }


    // ----------------------------------------------------------
    /**
     * Constructor for creating a new card
     * 
     * @param list
     */
    public Deck(ArrayList<Flashcard> list)
    {
        this.cards = new ArrayList<>(list);
    }


    // ----------------------------------------------------------
    /**
     * Adds the card to the Deck
     * 
     * @param card
     */
    public void add(Flashcard card)
    {
        cards.add(card);
    }


    // ----------------------------------------------------------
    /**
     * Randomizes the Flashcards
     */
    public void shuffle()
    {
        if (cards.size() < 4)
        {
            throw new IllegalArgumentException("Needs more cards.");
        }

        ArrayList<Flashcard> original = new ArrayList<>(cards);

        while (cards.equals(original))
        {
            for (int i = 0; i < cards.size(); i++)
            {
                int randomIndex = (int)(Math.random() * cards.size());

                Flashcard temp = cards.get(i);
                cards.set(i, cards.get(randomIndex));
                cards.set(randomIndex, temp);
            }
        }
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @param index
     * @return card at the given index
     */
    public Flashcard get(int index)
    {
        return cards.get(index);
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     * 
     * @return the size of the deck
     */
    public int size()
    {
        return cards.size();
    }
}
