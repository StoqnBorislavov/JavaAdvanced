package JavaAdvanced.StackAndQueue.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor_08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<String> stack = new ArrayDeque<>();
        int n = Integer.parseInt(sc.nextLine());
        StringBuilder text = new StringBuilder("");
        stack.push(text.toString());
        for (int i = 0; i < n; i++) {
            String command = sc.nextLine();
            String[] partOfCommand = command.split("\\s+");
            String realCommand = partOfCommand[0];
            switch (realCommand){
                case "1":
                    String textForAppending = partOfCommand[1];
                    text.append(textForAppending);
                    stack.push(text.toString());
                    break;
                case "2":
                    int elementsForErase = Integer.parseInt(partOfCommand[1]);
                    int startIndex = text.length() - elementsForErase;
                    if(isValidIndex(startIndex, text)) {
                        text.delete(startIndex, text.length());
                        stack.push(text.toString());
                    }
                    break;
                case "3":
                    int index = Integer.parseInt(partOfCommand[1]);
                    if(isValidIndex(index, text)) {
                        System.out.println(text.toString().charAt(index - 1));
                    }
                    break;
                case "4":
                    stack.pop();
                    text = new StringBuilder(stack.peek());
                    break;
            }
        }
    }

    private static boolean isValidIndex(int startIndex, StringBuilder text) {
        if(startIndex >= 0 && startIndex <= text.length()){
            return true;
        }
        return false;
    }
}
