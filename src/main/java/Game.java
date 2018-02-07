
public class Game {
    private int itsScore = 0;
    private int[] itsThrows = new int[21]; // 최대 투구 횟수
    private int itsCurrentThrow = 0;

    private int itsCurrentFrame = 1; // 현재 프레임 계산
    private boolean firstThrow = true; // 프레임에서 첫번째 투구 여부 확인

    public int score() {
        return scoreForFrame(getCurrentFrame() - 1);
    }

    public void add(int pins) {
        itsThrows[itsCurrentThrow++] = pins;
        itsScore += pins;
        adjustCurrentFrame();
    }

    private void adjustCurrentFrame() {
        if (firstThrow == true) {
            firstThrow = false;
        } else {
            firstThrow = true;
            itsCurrentFrame++;
        }
    }

    public int getCurrentFrame() {
        return itsCurrentFrame;
    }

    public int scoreForFrame(int theFrame) {
        int ball = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
            int firstThrow = itsThrows[ball++];
            int secondThrow = itsThrows[ball++];

            int frameScore = firstThrow + secondThrow;
            if (frameScore == 10) {
                score += frameScore + itsThrows[ball];
            } else {
                score += frameScore;
            }
        }

        return score;
    }
}
