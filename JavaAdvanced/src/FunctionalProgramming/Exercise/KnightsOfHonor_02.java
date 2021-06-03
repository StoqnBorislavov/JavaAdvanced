package FunctionalProgramming.Exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");
        Consumer<String[]> printSir = arrays -> {
            for (String name : arrays) {
                System.out.println("Sir " + name);
            }
        };
        printSir.accept(input);
    }
}
