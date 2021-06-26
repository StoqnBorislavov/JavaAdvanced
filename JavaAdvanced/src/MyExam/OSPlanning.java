package MyExam;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(tasks::push);

        ArrayDeque<Integer> threads = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int taskToBeKilled = Integer.parseInt(sc.nextLine());
        int currentTask = tasks.peek();
        int currentThread = threads.peek();

        while (currentTask != taskToBeKilled){
            if(currentThread >= currentTask){
                tasks.pop();
            }
            threads.poll();
            currentTask = tasks.peek();
            currentThread = threads.peek();
        }
        int threadThatKilledTask = threads.peek();
        System.out.printf("Thread with value %d killed task %d%n", threadThatKilledTask, taskToBeKilled);
        System.out.println(String.join(" ", String.valueOf(threads))
                .replaceAll("[\\[\\]]", "")
                .replaceAll(",", ""));
    }
}
