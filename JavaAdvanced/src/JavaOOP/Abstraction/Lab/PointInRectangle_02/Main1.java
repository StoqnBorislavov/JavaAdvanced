package JavaOOP.Abstraction.Lab.PointInRectangle_02;

import JavaOOP.input.Reader;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rectanglePoints = Reader.readIntArray("\\s+");
        Point A = new Point(rectanglePoints[0], rectanglePoints[1]);
        Point B = new Point(rectanglePoints[2], rectanglePoints[3]);

        Rectangle rect = new Rectangle(A, B);

        int count = Reader.readIntArray("\\s+")[0];

        while (count-- > 0){
            int[] singlePoint = Reader.readIntArray("\\s+");
            Point p = new Point(singlePoint[0], singlePoint[1]);

            boolean isWithIn = rect.contains(p);

            System.out.println(isWithIn);
        }

    }
}
