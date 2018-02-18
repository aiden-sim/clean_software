package ocp;

import java.util.ArrayList;
import java.util.List;

public class DrawAllShapes {

    public static void main(String[] args) {
        List<Shape> list = new ArrayList<Shape>();
        list.add(new Shape(ShapeType.CIRCLE));
        list.add(new Shape(ShapeType.SQUARE));

        getShape(list, 2);
    }

    public static void getShape(List<Shape> list, int n) {
        for (int i = 0; i < n; i++) {
            Shape shape = list.get(i);
            switch (shape.itsType) {
                case CIRCLE:
                    Circle circle = new Circle();
                    circle.drawCircle();
                    break;
                case SQUARE:
                    Square square = new Square();
                    square.drawSquare();
                    break;
                default:
                    System.out.print("No Matched");
            }
        }
    }
}

enum ShapeType {
    CIRCLE, SQUARE
}

class Shape {
    ShapeType itsType;

    Shape(ShapeType type) {
        this.itsType = type;
    }
}

class Square {
    public void drawSquare() {
        System.out.println("Square");
    }
}

class Circle {
    public void drawCircle() {
        System.out.println("Circle");
    }
}