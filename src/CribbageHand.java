/**
 * Created by jason on 2/16/14.
 */

import java.util.ArrayList;

public class CribbageHand {
    public ArrayList<Card> cribbageHand = new ArrayList<Card>();

    public CribbageHand(){}

    public CribbageHand(ArrayList<Card> h){
        this.cribbageHand = h;
    }

    public void addCard(Card c){
        this.cribbageHand.add(c);
    }

    public int numCards(){
        return this.cribbageHand.size();
    }

    public void setHand(ArrayList<Card> h){
        this.cribbageHand = h;
    }

    public ArrayList<Card> getHand(){
        return this.cribbageHand;
    }

    public void printHand(){
        for(int i = 0; i < cribbageHand.size(); i++){
            Card c = getHand().get(i);
            System.out.println("Card " + i + ": " + c.getRankAndSuitName() + " with count value " + c.getCountValue());
        }
    }

    public void sendCardFromHandToCribByPosition(Crib crib, int position){
        Card card = getHand().remove(position);
        crib.addCard(card);
    }
}

