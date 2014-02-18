import java.util.ArrayList;

/**
 * Created by jason on 2/15/14.
 */

public class Player {
    private String name;
    private Track track;
    private CribbageHand hand;

    public Player(String name){
        this(name, 121);
    }

    public Player(String name, int playerWinningHole){
        this.name = name;
        this.track = new Track(playerWinningHole);
        this.hand = new CribbageHand();
    }

    public String getName(){
        return this.name;
    }

    public Track getTrack(){
        return this.track;
    }

    public CribbageHand getHand(){
        return this.hand;
    }

    public void setHand(ArrayList<Card> hand){
        this.hand.setHand(hand);
    }

    public void addCardToHand(Card c){
        this.getHand().addCard(c);
    }

    public int getScore(){
        return getTrack().getFrontPegPosition();
    }

    public boolean hasWon(){
        return getTrack().isInWinningHole();
    }

    public boolean hasCards(){
        return getHand().numCards() > 0;
    }

    public void printHand(){
        getHand().printHand();
    }

    public void sendCardToCribByPosition(Crib c, int i){
        this.getHand().sendCardFromHandToCribByPosition(c, i);
    }
}
