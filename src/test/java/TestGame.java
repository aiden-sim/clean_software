import junit.framework.TestCase;

public class TestGame extends TestCase {
    public TestGame(String name) {
        super(name);
    }

    private Game g;

    public void setUp() {
        g = new Game();
    }

    public void testOneThrow() {
        g.add(5);
        // 테스트 케이스는 목적에 부합하지 않으면 삭제가능
        // assertEquals(5, g.score()); 처음 프레임의 첫 투구만으로는 score를 계산할 수 없다.
        assertEquals(1, g.getCurrentFrame());
    }

    public void testTwoThrowsNoMark() {
        g.add(5);
        g.add(4);
        assertEquals(9, g.score());
        assertEquals(2, g.getCurrentFrame());
    }

    public void testFourThrowsNoMark() {
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertEquals(18, g.score());
        assertEquals(9, g.scoreForFrame(1));
        assertEquals(18, g.scoreForFrame(2));
        assertEquals(3, g.getCurrentFrame());
    }

    public void testSimpleSpare() {
        Game g = new Game();
        g.add(3);
        g.add(7);
        g.add(3);
        assertEquals(13, g.scoreForFrame(1));
        assertEquals(2, g.getCurrentFrame());
    }

    public void testSimpleFrameAfterSpare() {
        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);
        assertEquals(13, g.scoreForFrame(1));
        assertEquals(18, g.scoreForFrame(2));
        assertEquals(18, g.score());
        assertEquals(3, g.getCurrentFrame());
    }
}
