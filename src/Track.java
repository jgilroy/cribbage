/**
 * Created by jason on 2/15/14.
 */
public class Track {

    public int winningHole;
    public int frontPegPosition;
    public int rearPegPosition;

    public Track(){
        this(121);
    }

    public Track(int n) {
        winningHole = n;
        frontPegPosition = 0;
        rearPegPosition = 0;
    }

    public String toString() {
        return "Winning Hole: " + this.winningHole + ". Front peg at " + this.frontPegPosition + ", back peg at " + this.rearPegPosition;
    }

    public int getWinningHole() {
        return winningHole;
    }

    public void setWinningHole(int winningHole) {
        this.winningHole = winningHole;
    }

    public int getFrontPegPosition() {
        return frontPegPosition;
    }

    public void setFrontPegPosition(int frontPegPosition) {
        this.frontPegPosition = frontPegPosition;
    }

    public int getRearPegPosition() {
        return rearPegPosition;
    }

    public void setRearPegPosition(int rearPegPosition) {
        this.rearPegPosition = rearPegPosition;
    }

    public boolean isInWinningHole() {
        return (this.frontPegPosition >= this.winningHole);
    }

//    public static void main(String[] args) {
//        Track t = new Track();
//        t.toString();
//    }


}
