package StackAndQueue.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        ArrayDeque<String> history = new ArrayDeque<>();

        String currentURL = "";

        while (!command.equals("Home")){
            if(command.equals("back")){
                if(history.isEmpty()){
                    System.out.println("No previous URLs");
                    command = sc.nextLine();
                    continue;
                }
                String prevURL = history.pop();
                currentURL = prevURL;

            } else {
                if(!currentURL.equals("")){

                    history.push(currentURL);
                }
                currentURL = command;
            }
            System.out.println(currentURL);
            command = sc.nextLine();
        }
    }
}
