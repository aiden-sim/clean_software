package chater2.ocp2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by simjunbo on 2018-02-18.
 */
public class DrawAllShapes {
    public static void main(String[] args) {
        List<Shape> list = new ArrayList<Shape>();
        list.add(new Circle());
        list.add(new Square());
        list.add(new Square());
        list.add(new Circle());

        getShape(list);
    }

    public static void getShape(List<Shape> list) {
        for (Shape shape : list) {
            shape.draw();
        }
    }

}

abstract class Shape {
    public abstract void draw();
    public abstract boolean precedes(Shape shape);
}

class Square extends Shape {
    public void draw() {
        System.out.println("Square");
    }

    public boolean precedes(Shape shape) {
        return false;
    }
}

class Circle extends Shape {
    public void draw() {
        System.out.println("Circle");
    }

    public boolean precedes(Shape shape) {
        return false;
    }
}