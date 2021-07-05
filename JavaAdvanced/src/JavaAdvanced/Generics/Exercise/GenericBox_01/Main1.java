package JavaAdvanced.Generics.Exercise.GenericBox_01;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Box<String> stringBox = new Box<>();
        for (int i = 0; i < n; i++) {
            stringBox.add(sc.nextLine());
        }

        String elementToCompare = sc.nextLine();
        System.out.println(stringBox.countOfBiggerElements(elementToCompare));


    }
}
