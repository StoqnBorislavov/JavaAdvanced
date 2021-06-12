package Generics.Exercise.GenericBox_01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Box<Integer> stringBox = new Box<>();
        for (int i = 0; i < n; i++) {
            stringBox.add(Integer.parseInt(sc.nextLine()));
        }

        String[] indexes = sc.nextLine().split("\\s+");
        int firstIndex = Integer.parseInt(indexes[0]);
        int secondIndex = Integer.parseInt(indexes[1]);

        stringBox.swapToElements(firstIndex, secondIndex);


        System.out.println(stringBox.toString());
    }
}
