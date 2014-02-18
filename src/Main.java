import java.util.ArrayList;

/**
 * Created by jason on 2/17/14.
 */
public class Main {
    public static void main(String [] args){
        Player pOne = new Player("Jason");
        Player pTwo = new Player("Al");
        ArrayList<Player> testPlayers = new ArrayList<Player>();
        testPlayers.add(pOne);
        testPlayers.add(pTwo);
        CribbageGame g = new CribbageGame(testPlayers);
        CribbageScorer cs = new CribbageScorer();
        ArrayList<Player> playerList = g.getPlayerList();
        Deck d = g.getDeck();
        d.shuffle();
        Card cutCard = d.deal();
        System.out.println("Cut card: " + cutCard.getRankAndSuitName());
        for(Player player : playerList){
            System.out.println(player.getName());
            System.out.println("dealing...");
            player.setHand(d.deal(6));
            System.out.println("dealt...");
            System.out.println(player.hasCards());
            player.printHand();
            System.out.println("sending to crib...");
            player.sendCardToCribByPosition(g.getCrib(), 0);
            player.sendCardToCribByPosition(g.getCrib(), 1);
            System.out.println("sent to crib...");
            player.printHand();
            System.out.println(player.getName() + " score: " + cs.score(player.getHand(), cutCard));
        }
        g.getCrib().printCrib();
        System.out.println("Crib score: " + cs.score(g.getCrib(), cutCard));
    }
}
