package JavaOOP.Abstraction.Lab.PointInRectangle_02;

public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y =y;
    }

    public boolean greaterOrEqual(Point a) {
        return a.x <= x && a.y <= y;
    }

    public boolean lessOrEqual(Point a) {
        return x <= a.x && y <= a.y;
    }
}
