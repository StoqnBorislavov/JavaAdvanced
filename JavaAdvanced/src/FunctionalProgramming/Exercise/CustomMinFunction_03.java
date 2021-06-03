package FunctionalProgramming.Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

public class CustomMinFunction_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int[] numbers = Arrays.stream(input.split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        Consumer<int[]> findMinElement = array ->
                System.out.println(Arrays.stream(array).min().orElse(0));
          findMinElement.accept(numbers);
    }
}
