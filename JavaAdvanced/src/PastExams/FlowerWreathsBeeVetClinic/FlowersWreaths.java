package PastExams.FlowerWreathsBeeVetClinic;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FlowersWreaths {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> lilies = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(lilies::push);


        ArrayDeque<Integer> roses = Arrays.stream(sc.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));


        int numberOfWreaths = 0;
        int storedFlowers = 0;
        while (!lilies.isEmpty() && !roses.isEmpty()) {
            int numberOfLilies = lilies.pop();
            int numberOfRoses = roses.poll();
            int sum = numberOfLilies + numberOfRoses;

            while (sum > 15) {
                sum -= 2;
            }

            if (sum == 15) {
                numberOfWreaths++;
            } else {
                storedFlowers += sum;
            }
        }

        if (storedFlowers > 0) {
            numberOfWreaths = numberOfWreaths + storedFlowers / 15;
        }
        if (numberOfWreaths >= 5) {
            System.out.println("You made it, you are going to the competition with " + numberOfWreaths + " wreaths!");
        } else {
            System.out.println("You didn't make it, you need " + (5 - numberOfWreaths) + " wreaths more!");
        }

    }
}
