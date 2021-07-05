package JavaAdvanced.FunctionalProgramming.Exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split("\\s+");

        Consumer<String[]> printString = array -> {
            for (String name : array) {
                System.out.println(name);
            }
        };

        printString.accept(input);
    }
}
