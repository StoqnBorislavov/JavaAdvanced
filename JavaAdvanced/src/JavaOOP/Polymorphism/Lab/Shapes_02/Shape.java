package JavaOOP.Polymorphism.Lab.Shapes_02;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    protected void setPerimeter(Double perimeter) {
        this.perimeter = perimeter;
    }

    protected void setArea(Double area) {
        this.area = area;
    }

    protected abstract void calculatePerimeter();
    protected abstract void calculateArea();

    public Double getArea() {
        if(this.area == null) {
            calculateArea();
        }
        return area;
    }

    public Double getPerimeter() {
        if(this.perimeter == null) {
            calculatePerimeter();
        }
        return perimeter;
    }
}
