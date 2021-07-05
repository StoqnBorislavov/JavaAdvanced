package JavaAdvanced.FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateForNames_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int length = Integer.parseInt(sc.nextLine());

        String[] names = sc.nextLine().split("\\s+");

        Predicate<String> checkLength = name -> name.length() <= length;

        Arrays.stream(names).filter(checkLength).forEach(System.out::println);

    }
}
