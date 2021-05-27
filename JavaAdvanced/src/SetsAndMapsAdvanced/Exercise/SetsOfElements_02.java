package SetsAndMapsAdvanced.Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split("\\s+");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>(n);
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>(m);
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(sc.nextLine());
            firstSet.add(number);
        }
        for (int i = 0; i < m; i++) {
            int number = Integer.parseInt(sc.nextLine());
            secondSet.add(number);
        }
         firstSet.retainAll(secondSet);
        for (Integer number : firstSet) {
            System.out.print(number + " ");
        }
    }
}
