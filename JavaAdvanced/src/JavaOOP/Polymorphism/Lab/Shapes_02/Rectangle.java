package JavaOOP.Polymorphism.Lab.Shapes_02;

public class Rectangle extends Shape{
    private Double height;
    private Double width;


    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    protected void calculatePerimeter() {
        Double result = this.height * 2 + this.width * 2;
        super.setPerimeter(result);
    }

    @Override
    protected void calculateArea() {
        Double result = this.height *  this.width;
        super.setArea(result);
    }

    public final Double getHeight() {
        return height;
    }

    public final Double getWidth() {
        return width;
    }
}
