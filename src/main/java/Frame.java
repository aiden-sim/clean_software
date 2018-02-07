/**
 * Created by simjunbo on 2018-02-07.
 */
public class Frame {
    private int itsScore = 0;

    public int getScore() {
        return itsScore;
    }

    // public void add(Throw t) => f.add(new Throw(5))
    public void add(int pins) {
        itsScore += pins;
    }
}
