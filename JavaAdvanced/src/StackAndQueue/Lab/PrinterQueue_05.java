package StackAndQueue.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        while (!command.equals("print")){
            if(command.equals("cancel")){
                if (printerQueue.isEmpty()){
                    System.out.println("Printer is on standby");
                } else {
                    System.out.println("Canceled " + printerQueue.poll());
                }
            } else {
                printerQueue.offer(command);
            }
            command = sc.nextLine();
        }
        while(!printerQueue.isEmpty()){
            System.out.println(printerQueue.poll());
        }
    }
}
