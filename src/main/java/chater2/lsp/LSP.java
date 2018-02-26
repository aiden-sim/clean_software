package chater2.lsp;

/**
 * Created by simjunbo on 2018-02-18.
 */
public class LSP {
    public void drawShape(Shape s) {
        if (s.itsType == Shape.ShapeType.SQUARE) {
            Square square = (Square) s;
            square.draw();
        } else if (s.itsType == Shape.ShapeType.CIRCLE) {
            Circle circle = (Circle) s;
            circle.draw();
        }
    }
}

class Point {
    double x, y;
}

abstract class Shape {
    enum ShapeType {
        SQUARE, CIRCLE
    }

    ShapeType itsType;

    Shape(ShapeType type) {
        this.itsType = type;
    }
}

class Circle extends Shape {
    Point itsCenter;
    double itsRadius;

    Circle(ShapeType type) {
        super(type);
    }

    public void draw() {
        System.out.println("Circle");
    }
}

class Square extends Shape {
    Point itsTopLeft;
    double itsSide;

    Square(ShapeType type) {
        super(type);
    }

    public void draw() {
        System.out.println("Square");
    }
}