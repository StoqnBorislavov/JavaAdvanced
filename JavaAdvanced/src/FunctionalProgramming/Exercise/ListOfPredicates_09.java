package FunctionalProgramming.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class ListOfPredicates_09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Predicate<Integer> predicate = x -> {
            for (int number : numbers) {
                if (x % number != 0) {
                    return false;
                }
            }
            return true;
        };
        getAllNumbersInRange(n).stream().filter(predicate).forEach(e -> System.out.print(e + " "));

    }

    public static List<Integer> getAllNumbersInRange(int n) {
        List<Integer> numbersInRange = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbersInRange.add(i);
        }
        return numbersInRange;
    }

}
