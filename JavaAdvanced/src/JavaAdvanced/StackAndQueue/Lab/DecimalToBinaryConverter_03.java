package JavaAdvanced.StackAndQueue.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class DecimalToBinaryConverter_03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int decimalNumber = Integer.parseInt(sc.nextLine());
        ArrayDeque<Integer> binaryConverter = new ArrayDeque<>();

        while (decimalNumber > 0){
            binaryConverter.push(decimalNumber % 2);
            decimalNumber = decimalNumber / 2;
        }
        if(!binaryConverter.isEmpty()) {
            for (Integer integer : binaryConverter) {
                System.out.print(integer);
            }
        } else {
            System.out.println(0);
        }
    }
}
