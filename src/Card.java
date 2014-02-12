public class Card {

    private int myRank;
    private int mySuit;
    // private Image myCardImage;

    public Card(int rank, int suit){
        myRank = rank;
        mySuit = suit;
    }

    private static final String[] rankStrings = {
            "Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Jack", "Queen", "King" };

    private static final String[] suitStrings = {
            "Spades", "Hearts", "Diamonds", "Clubs" };

    public String getRankName(){
        return rankStrings[myRank];
    }

    public String getSuitName(){
        return suitStrings[mySuit];
    }

    public void printCard() {
        System.out.println(getRankName() + " of " + getSuitName());
    }
}