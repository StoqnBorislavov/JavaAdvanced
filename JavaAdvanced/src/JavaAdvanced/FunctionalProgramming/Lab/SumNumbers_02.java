package JavaAdvanced.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Stream;

public class SumNumbers_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        String[] tokens = sc.nextLine().split(", ");

        Function<String[], Stream<Integer>> map =
                arr -> Arrays.stream(arr).map(Integer::parseInt);

        Function<Stream<Integer>, Integer> sum = str -> str.mapToInt(e -> e).sum();

        Function<Stream<Integer>, Long> count = str -> str.mapToInt(e -> e).count();

        System.out.println("Count = " + count.apply(map.apply(tokens)));
        System.out.println("Sum = " + sum.apply(map.apply(tokens)));

    }
}
