package JavaAdvanced.FunctionalProgramming.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SortEvenNumbers_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .toArray();
        StringBuilder out =  new StringBuilder();
        Function<IntStream, String> formatNumbers = str -> str
                                                            .mapToObj(String::valueOf)
                                                            .collect(Collectors.joining(", "));

        String functionalOutput = formatNumbers.apply(Arrays.stream(numbers));
        System.out.println(functionalOutput);
        String sortedNumbers = formatNumbers.apply(Arrays.stream(numbers).sorted());
        System.out.println(sortedNumbers);
    }
}
