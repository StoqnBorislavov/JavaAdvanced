package JavaOOP.Polymorphism.Lab.Shapes_02;

public class Circle extends Shape{
    private Double radius;

    public Circle(Double radius) {
        this.radius = radius;

    }

    @Override
    protected void calculatePerimeter() {
        Double result = 2 * Math.PI * this.radius;
        super.setPerimeter(result);
    }

    @Override
    protected void calculateArea() {
        Double result = Math.PI * this.radius * this.radius;
        super.setArea(result);
    }

    public final Double getRadius() {
        return radius;
    }
}
