package JavaOOP.Polymorphism.Lab.Shapes_02;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Shape shape = new Rectangle(13.00, 2.00);
        Shape shape1 = new Circle(30.00);

        List<Shape> shapes = new ArrayList<>();

        shapes.add(shape);
        shapes.add(shape1);

        for (Shape s : shapes) {
            System.out.println(s.getPerimeter());
            System.out.println(s.getArea());
        }
    }
}
