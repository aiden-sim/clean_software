package bowling;

public class Game {
    private int itsCurrentFrame = 1; // 현재 프레임 계산
    private boolean firstThrowInFrame = true; // 프레임에서 첫번째 투구 여부 확인
    private Scorer itsScorer = new Scorer();

    public int score() {
        return scoreForFrame(itsCurrentFrame);
    }

    public void add(int pins) {
        itsScorer.addThrow(pins);
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (lastBallInFrame(pins)) {
            advanceFrame();
        } else {
            firstThrowInFrame = false;
        }
    }

    public int getCurrentFrame() {
        return itsCurrentFrame;
    }

    public int scoreForFrame(int theFrame) {
        return itsScorer.scoreForFrame(theFrame);
    }

    private void advanceFrame() {
        itsCurrentFrame = Math.min(10, itsCurrentFrame + 1); // itsCurrentFrame은 종료의미기 때문에 10frame 인경우 11로 되어 있다.
    }

    private boolean strike(int pins) {
        return (firstThrowInFrame && pins == 10);
    }

    private boolean lastBallInFrame(int pins) {
        return strike(pins) || !firstThrowInFrame;
    }
}
