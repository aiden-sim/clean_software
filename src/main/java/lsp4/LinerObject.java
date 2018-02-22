package lsp4;

/**
 * Created by simjunbo on 2018-02-19.
 */
public class LinerObject {

    private Point itsP1;
    private Point itsP2;

    public LinerObject(Point p1, Point p2) {

    }

    public double getSlope() {
        return 0.0;
    }

    public double getIntercept() {
        return 0.0;
    }

    public Point getP1() {
        return itsP1;
    }

    public Point getP2() {
        return itsP2;
    }

    public boolean isOn(Point point) {
        return true;
    }
}

class Line extends LinerObject {
    public Line(Point p1, Point p2) {
        super(p1, p2);
    }

    @Override
    public boolean isOn(Point point) {
        return true;
    }
}

class LineSegment extends LinerObject {
    public LineSegment(Point p1, Point p2) {
        super(p1, p2);
    }

    public double getLength() {
        return 0.0;
    }

    @Override
    public boolean isOn(Point point) {
        return true;
    }
}

class Point {
    double x, y;
}