package StackAndQueue.Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MathPotato_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        List<String> names = Arrays.stream(sc.nextLine().
                split("\\s+")).collect(Collectors.toList());
        int n = Integer.parseInt(sc.nextLine());
        for (String name : names) {
            queue.offer(name);
        }
        int count = 0;
        while (queue.size() > 1) {
            count++;
            if (!isPrime(count)) {
                for (int i = 1; i < n; i++) {
                    queue.offer(queue.poll());
                }
                System.out.println("Removed " + queue.poll());
            } else {
                for (int i = 1; i < n; i++) {
                    queue.offer(queue.poll());
                }
                System.out.println("Prime " + queue.peek());
            }
        }
        System.out.println("Last is " + queue.poll());

    }

    private static boolean isPrime(int count) {
        int factorCount = 0;
        for (int i = 1; i <= count; i++) {
            if (count % i == 0) {
                factorCount++;
            }
        }
        return factorCount == 2;
    }
}
