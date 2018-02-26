package chater2.lsp2;

/**
 * Created by simjunbo on 2018-02-19.
 */
public class Rectangle {
    private Point itsTopLeft;
    private double itsWidth;
    private double itsHeight;

    public void setWidth(double w) {
        this.itsWidth = w;
    }

    public void setHeight(double h) {
        this.itsHeight = h;
    }

    double getWidth() {
        return itsWidth;
    }

    double getHeight() {
        return itsHeight;
    }
}

class Point {
    double x, y;
}
