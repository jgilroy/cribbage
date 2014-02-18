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

    public int getRank(){
        return this.myRank;
    }

    public String getRankName(){
        return rankStrings[myRank];
    }

    public String getSuitName(){
        return suitStrings[mySuit];
    }

    public void printCard() {
        System.out.println(getRankName() + " of " + getSuitName());
    }

    public String getRankAndSuitName(){
        return getRankName() + " of " + getSuitName();
    }

    // Cribbage Specific "Count Value" -- does this belong in a CribbageCard subclass?
    public int getCountValue(){
        int rank = getRank();
        if (rank <= 9) return rank + 1;
        else return 10;
    }
}