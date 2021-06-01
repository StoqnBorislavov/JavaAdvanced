package FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Predicate<String> startWithCapitalLetter = str -> Character.isUpperCase(str.charAt(0));

        String[] words = Arrays.stream(sc.nextLine().split("\\s+"))
                .filter(startWithCapitalLetter)
                .toArray(String[]::new);
        System.out.println(words.length);
        Arrays.stream(words).forEach(System.out::println);

    }
}
