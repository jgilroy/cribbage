import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    // Standard Deck, no Jokers

    public ArrayList<Card> deck;

    public Deck(){
        deck = new ArrayList<Card>();
        for (int r = 0; r < 13; r++)
            for(int s = 0; s < 4; s++)
                deck.add(new Card(r, s));

    }

    public Deck(ArrayList<Card> cardArrayList){
        deck = cardArrayList;
    }

    public Card deal() {
        return deck.remove(0);
    }

    public ArrayList<Card> deal(int numcards){
        ArrayList<Card> cardsToDeal = new ArrayList<Card>();
        for (int i = 0; i < numcards; i++) {
            cardsToDeal.add(this.deck.remove(0));
        }
        return cardsToDeal;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public int numCardsRemaining() {
        return deck.size();
    }

    public boolean isEmpty() {
        return this.numCardsRemaining() == 0;
    }



}