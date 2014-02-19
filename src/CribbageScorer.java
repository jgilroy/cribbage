import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jason on 2/17/14.
 */
public class CribbageScorer {

    public int score(CribbageHand hand, Card cutCard){
        return scoreFlushes(hand, cutCard) + scoreNobs(hand, cutCard) + scorePairs(hand, cutCard) + scoreFifteens(hand, cutCard) + scoreRuns(hand, cutCard);
    }

    public int score(Crib crib, Card cutCard){
        return scoreFlushes(crib, cutCard) + scoreNobs(crib, cutCard) + scorePairs(crib, cutCard) + scoreFifteens(crib, cutCard) + scoreRuns(crib, cutCard);
    }

    public int scoreFlushes(CribbageHand hand, Card cutCard){
        boolean handFlush = true;
        boolean fullFlush = false;
        Card flushTestCard = hand.getHand().get(0);
        for(Card c : hand.getHand())
            if (!(c.getSuitName().equals(flushTestCard.getSuitName())))
                handFlush = false;

        if (handFlush)
            if (flushTestCard.getSuitName().equals(cutCard.getSuitName()))
                fullFlush = true;

        if (fullFlush) return 5;
        else if (handFlush) return 4;
        else return 0;
    }

    public int scoreFlushes(Crib crib, Card cutCard){
        boolean isFlush = true;
        for(Card c: crib.getCrib().getHand())
            if (!(c.getSuitName().equals(cutCard.getSuitName())))
                isFlush = false;

        if (isFlush) return 5;
        else return 0;
    }

    public int scoreNobs(CribbageHand hand, Card cutCard){
        if (cutCard.getRankName().equals("Jack")) return 0;
        for (Card c: hand.getHand()){
            if (c.getRankName().equals("Jack") && c.getSuitName().equals(cutCard.getSuitName()))
                return 1;
        }
        return 0;
    }

    public int scoreNobs(Crib crib, Card cutCard){
        return this.scoreNobs(crib.getCrib(), cutCard);
    }

    public int scorePairs(CribbageHand hand, Card cutCard){
        ArrayList<Card> forCopy = new ArrayList<Card>();
        forCopy = (ArrayList<Card>) hand.getHand().clone();
        CribbageHand tempHand = new CribbageHand();
        tempHand.setHand(forCopy);
        tempHand.addCard(cutCard);
	    int score = 0;
        for(int i = 0; i < tempHand.getHand().size(); i++){
            for(int j = i + 1; j < tempHand.getHand().size(); j++){
                if (tempHand.getHand().get(i).getRankName().equals(tempHand.getHand().get(j).getRankName())){
                    score += 2;
                }
            }
        }
        return score;
    }

    public int scorePairs(Crib crib, Card cutCard){
        return scorePairs(crib.getCrib(), cutCard);
    }

    public int scoreFifteens(CribbageHand hand, Card cutCard){
        ArrayList<Card> forCopy = new ArrayList<Card>();
        forCopy = (ArrayList<Card>) hand.getHand().clone();
        CribbageHand tempHand = new CribbageHand();
        tempHand.setHand(forCopy);
        tempHand.addCard(cutCard);
        int score = 0;
        int [][] cardCombos = { {0,1,2,3,4} , {0,1,2,3} , {0,1,2,4} , {0,1,3,4} , {0,2,3,4} , {1,2,3,4} , {0,1,2} , {0,1,3} , {0,1,4} , {0,2,3} , {0,2,4} , {0,3,4} , {1,2,3} , {1,2,4} , {1,3,4} , {2,3,4} , {0,1} , {0,2} , {0,3} , {0,4} , {1,2} , {1,3} , {1,4} , {2,3}, {2,4} , {3,4} };
        for(int [] combo: cardCombos){
            int total = 0;
            for(int index: combo){
                total = total + tempHand.getHand().get(index).getCountValue();
            }
            if (total == 15) score = score + 2;
        }
        return score;
    }

    public int scoreFifteens(Crib crib, Card cutCard){
        return scoreFifteens(crib.getCrib(), cutCard);
    }

    public int scoreRuns(CribbageHand hand, Card cutCard){
        ArrayList<Card> forCopy = new ArrayList<Card>();
        forCopy = (ArrayList<Card>) hand.getHand().clone();
        CribbageHand tempHand = new CribbageHand();
        tempHand.setHand(forCopy);
        tempHand.addCard(cutCard);
        for(Card c: tempHand.getHand()){
            System.out.println(c.getRankAndSuitName());
        }
        Collections.sort(tempHand.getHand());

        int [][] fiveCardCombos = { {0,1,2,3,4} };
        int [][] fourCardCombos = { {0,1,2,3}, {0,1,2,4}, {0,1,3,4} , {0,2,3,4} , {1,2,3,4} };
        int [][] threeCardCombos = { {0,1,2} , {0,1,3} , {0,1,4} , {0,2,3} , {0,2,4} , {0,3,4} , {1,2,3} , {1,2,4} , {1,3,4} , {2,3,4} };

        int runScore = 0;
        for(int [] combo: fiveCardCombos){
            runScore = runScore + testRunAndReturnScore(tempHand, combo);
        }
        if (runScore > 0) return runScore;

        for(int [] combo: fourCardCombos){
            runScore = runScore + testRunAndReturnScore(tempHand, combo);
        }
        if (runScore > 0) return runScore;

        for(int [] combo: threeCardCombos){
            runScore = runScore + testRunAndReturnScore(tempHand, combo);
        }
        return runScore;
    }

    public int scoreRuns(Crib crib, Card cutCard){
        return scoreRuns(crib.getCrib(), cutCard);
    }

    public int testRunAndReturnScore(CribbageHand hand, int [] oneCombo){
        ArrayList<Card> cardsToExamine = new ArrayList<Card>();
        for(int i=0; i<oneCombo.length; i++) {
            cardsToExamine.add(hand.getHand().get(oneCombo[i]));
        }
        Collections.sort(cardsToExamine);
        int currentRank = cardsToExamine.get(0).getRank();
        for(int i=1; i<cardsToExamine.size(); i++){
            if (cardsToExamine.get(i).getRank() == currentRank+1) currentRank++;
            else return 0;
        }
        return cardsToExamine.size();
    }
}
