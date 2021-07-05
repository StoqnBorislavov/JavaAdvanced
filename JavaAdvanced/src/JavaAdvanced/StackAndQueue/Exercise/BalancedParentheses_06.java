package JavaAdvanced.StackAndQueue.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        ArrayDeque<Character> openedBrackets = new ArrayDeque<>();
        boolean areBalanced = false;

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                openedBrackets.push(currentChar);
            } else if (currentChar == ')' || currentChar == '}' || currentChar == ']') {
                if(openedBrackets.isEmpty()) {
                    areBalanced = false;
                    break;
                }
                char lastOpenedBracket = openedBrackets.pop();
                if (lastOpenedBracket == '(' && currentChar == ')') {
                    areBalanced = true;
                } else if (lastOpenedBracket == '{' && currentChar == '}') {
                    areBalanced = true;
                } else if (lastOpenedBracket == '[' && currentChar == ']') {
                    areBalanced = true;
                } else {
                    areBalanced = false;
                    break;
                }
            }
        }
        if(areBalanced){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
