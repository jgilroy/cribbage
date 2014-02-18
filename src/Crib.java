/**
 * Created by jason on 2/16/14.
 */
public class Crib {

    CribbageHand crib = new CribbageHand();

    public void addCard(Card c){
        crib.addCard(c);
    }

    public CribbageHand getCrib(){
        return this.crib;
    }

    public void printCrib(){
        getCrib().printHand();
    }


}
