package JavaAdvanced.PastExams.DatingAppBookWormRabbits;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DatingApp_01 {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayDeque<Integer> maleStack = new ArrayDeque<>();
        Arrays.stream(sc.nextLine()
                .split("\\s+"))
            .mapToInt(Integer::parseInt)
                .forEach(maleStack::push);
    ArrayDeque<Integer> femaleQueue = Arrays.stream(sc.nextLine().split("\\s+"))
            .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
    int matches = 0;
        while (!maleStack.isEmpty() && !femaleQueue.isEmpty()){
        int currentMale = maleStack.peek();
        int currentFemale = femaleQueue.peek();
        if (currentFemale <= 0){
            femaleQueue.poll();
            continue;
        }
        if (currentMale <= 0){
            maleStack.pop();
           continue;
        }
        if(currentMale % 25 == 0){
            maleStack.pop();
            maleStack.pop();
            continue;
        }
        if(currentFemale % 25 == 0){
            femaleQueue.poll();
            femaleQueue.poll();
            continue;
        }
        if(currentMale == currentFemale){
            matches += 1;
            maleStack.pop();
            femaleQueue.poll();
        } else{
            femaleQueue.poll();
            maleStack.push(maleStack.pop() - 2);
        }
    }
        System.out.println("Matches: " + matches);
        if(maleStack.isEmpty()){
        System.out.println("Males left: none");
    } else {
        System.out.println("Males left: " + String.join(" ", String.valueOf(maleStack)).replaceAll("[\\[\\]]", ""));
    }
        if(femaleQueue.isEmpty()){
        System.out.println("Females left: none");
    } else {
        System.out.println("Females left: " + String.join(" ", String.valueOf(femaleQueue)).replaceAll("[\\[\\]]", ""));
    }
}
}
