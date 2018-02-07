import junit.framework.TestCase;

public class TestGame extends TestCase {
    public TestGame(String name) {
        super(name);
    }

    public void testOneThrow() {
        Game g = new Game();
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertEquals(18, g.score());
        assertEquals(9, g.scoreForFrame(1));
        assertEquals(18, g.scoreForFrame(2));
    }
}
