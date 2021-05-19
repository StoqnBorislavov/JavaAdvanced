package StackAndQueue.Lab;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class HotPotato_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> queue = new ArrayDeque<>();

        List<String> names = Arrays.stream(sc.nextLine().
                split("\\s+")).collect(Collectors.toList());
        int n = Integer.parseInt(sc.nextLine());
        for (String name : names) {
            queue.offer(name);
        }
        while (queue.size() > 1){
            for (int i = 1; i < n; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());

    }
}
