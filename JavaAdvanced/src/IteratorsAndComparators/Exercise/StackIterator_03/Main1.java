package IteratorsAndComparators.Exercise.StackIterator_03;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String command = sc.nextLine();

        Stack<Integer> stack = new Stack<>();

        while (!command.equals("END")){
            String[] tokens = command.split("[, ]+");
            switch (tokens[0]){
                case "Push":
                    for (int i = 1; i < tokens.length; i++) {
                        stack.push(Integer.parseInt(tokens[i]));
                    }
                    break;
                case "Pop":
                    try {
                        stack.pop();
                    }catch (Exception e){
                        System.out.print("No elements");
                    }
                    break;
            }
            command = sc.nextLine();
        }
        for (int i = 0; i < 2; i++) {
            for (Integer number : stack) {
                System.out.println(number);
            }
        }
    }
}
