package part2.lsp3;

/**
 * Created by simjunbo on 2018-02-19.
 */
public class Line {
    private Point itsP1;
    private Point itsP2;

    public Line(Point p1, Point p2) {
    }

    public double getSlope() {
        return 0.0;
    }

    public double getIntercept() {
        return 0.0;
    }

    Point getP1() {
        return itsP1;
    }

    Point getP2() {
        return itsP2;
    }

    boolean isOn(Point point) {
        return true;
    }
}

class LineSegment extends Line {
    public LineSegment(Point p1, Point p2) {
        super(p1, p2);
    }

    public double getLength() {
        return 0.0;
    }

    @Override
    boolean isOn(Point point) {
        return true;
    }
}

class Point {
    double x, y;
}