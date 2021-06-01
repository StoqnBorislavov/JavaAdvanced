package FunctionalProgramming.Lab;

import javax.naming.PartialResultException;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class FindEvensOrOdds_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split("\\s+");
        int lower = Integer.parseInt(tokens[0]);
        int upper = Integer.parseInt(tokens[1]);
        String oddOrEven = sc.nextLine();
        Predicate<Integer> filter = filter(oddOrEven);
        Consumer<Integer> printer = x -> System.out.print(x + " ");

        IntStream
                .rangeClosed(lower, upper)
                .boxed()
                .filter(filter)
                .forEach(printer);

    }
    public static Predicate<Integer> filter(String oddOrEven){
        if(oddOrEven.equals("odd")){
            return x -> x  % 2 != 0;
        }
        return x -> x  % 2 == 0;
    }
}
