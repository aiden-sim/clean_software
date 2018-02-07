
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
        adjustCurrentFrame(pins);
    }

    private void adjustCurrentFrame(int pins) {
        if (firstThrow == true) {
            if (pins == 10) {  // 스트라이크
                itsCurrentFrame++; // 스트라이크는 한번만 투구하고 종료되기 때문에
            } else {
                firstThrow = false;
            }
        } else {
            firstThrow = true;
            itsCurrentFrame++;
        }
        itsCurrentFrame = Math.min(11, itsCurrentFrame); // itsCurrentFrame은 종료의미기 때문에 10frame 인경우 11로 되어 있다.
    }

    public int getCurrentFrame() {
        return itsCurrentFrame;
    }

    public int scoreForFrame(int theFrame) {
        int ball = 0;
        int score = 0;
        for (int currentFrame = 0; currentFrame < theFrame; currentFrame++) {
            int firstThrow = itsThrows[ball++];
            if (firstThrow == 10) {
                score += 10 + itsThrows[ball] + itsThrows[ball + 1];
            } else {
                int secondThrow = itsThrows[ball++];

                int frameScore = firstThrow + secondThrow;
                if (frameScore == 10) {
                    score += frameScore + itsThrows[ball];
                } else {
                    score += frameScore;
                }
            }
        }

        return score;
    }
}
