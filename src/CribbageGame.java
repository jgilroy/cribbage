/**
 * Created by jason on 2/15/14.
 */
import java.util.ArrayList;

public class CribbageGame {
    public Deck deck;
    public Crib crib;
    public ArrayList<Player> playerList;

    public CribbageGame(ArrayList<Player> pList){
        this.deck = new Deck();
        this.crib = new Crib();
        playerList = pList;
    }

    public Crib getCrib(){
        return this.crib;
    }

    public Deck getDeck(){
        return this.deck;
    }

    public ArrayList<Player> getPlayerList(){
        return this.playerList;
    }


}
