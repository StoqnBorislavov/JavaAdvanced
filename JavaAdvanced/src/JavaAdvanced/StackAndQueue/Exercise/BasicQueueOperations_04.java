package JavaAdvanced.StackAndQueue.Exercise;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int x = sc.nextInt();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            queue.offer(sc.nextInt());
        }
        for (int i = 0; i < s; i++) {
            queue.poll();
        }
        if(queue.contains(x)){
            System.out.println("true");
        } else {
            if(queue.size() > 0) {
                System.out.println(Collections.min(queue));
            } else {
                System.out.println(0);
            }
        }
    }
}
