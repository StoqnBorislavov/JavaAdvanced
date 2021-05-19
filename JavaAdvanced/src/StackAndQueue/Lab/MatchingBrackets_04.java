package StackAndQueue.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String expression = sc.nextLine();
        ArrayDeque<Integer> matchingBracketIndex = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            char currentChar = expression.charAt(i);
            if(currentChar == '('){
                matchingBracketIndex.push(i);
            } else if(currentChar == ')'){
                System.out.println(expression.substring
                        (matchingBracketIndex.pop(), i + 1));
            }
        }
    }
}
