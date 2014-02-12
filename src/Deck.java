import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    // Standard Deck, no Jokers

    private ArrayList<Card> deck = new ArrayList<Card>();

    public Deck(){
        for (int r = 0; r < 13; r++)
            for(int s = 0; s < 4; s++)
                deck.add(new Card(r, s));
    }

    public Card deal() {
        return deck.remove(0);
    }

    public Card[] deal(int numcards){
        Card[] cardsToDeal = new Card[numcards];
        for (int i = 0; i < numcards; i++) {
            cardsToDeal[i] = deal();
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


    public static void main (String[] args) {

        System.out.println("Creating Deck..");
        Deck d = new Deck();
        d.shuffle();
        System.out.println("Shuffling Deck..");
        d.shuffle();
        System.out.println("Dealing Cards..");
        while(!d.isEmpty()){
            System.out.println(d.numCardsRemaining());
            d.deal().printCard();
        }
    }

}