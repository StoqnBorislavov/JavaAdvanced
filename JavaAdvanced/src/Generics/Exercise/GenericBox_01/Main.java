package Generics.Exercise.GenericBox_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Box<Double> stringBox = new Box<>();
        for (int i = 0; i < n; i++) {
            stringBox.add(Double.parseDouble(sc.nextLine()));
        }

        double elementToCompare = Double.parseDouble(sc.nextLine());
        System.out.println(stringBox.countOfBiggerElements(elementToCompare));


    }
}
