package StackAndQueue.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        ArrayDeque<String> history = new ArrayDeque<>();
        ArrayDeque<String> queueForForward = new ArrayDeque<>();

        String currentURL = "";

        while (!command.equals("Home")) {
            if (command.equals("back")) {
                if (history.isEmpty()) {
                    System.out.println("no previous URLs");
                    command = sc.nextLine();
                    continue;
                }
                if (!currentURL.equals("")) {
                    queueForForward.addFirst(currentURL);
                }
                String prevURL = history.pop();
                currentURL = prevURL;

            } else if (command.equals("forward")) {
                if (!queueForForward.isEmpty()) {
                    currentURL = queueForForward.poll();
                } else {
                    System.out.println("no next URLs");

                    command = sc.nextLine();
                    continue;
                }
            } else {
                 queueForForward.clear();
                if (!currentURL.equals("")) {

                    history.push(currentURL);
                }
                currentURL = command;
            }
            System.out.println(currentURL);
            command = sc.nextLine();
        }
    }
}
