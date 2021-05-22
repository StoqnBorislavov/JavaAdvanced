package StackAndQueue.Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci_07 {
    public static long[] memory; //this is for memorisation

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        memory = new long[n + 1]; //this is for memorisation
        System.out.println(getFibonacci(n));
    }

    private static long getFibonacci(int n) {
        if (n <= 1) {
            return 1;
        }
        if (memory[n] != 0) { //this is for memorisation
            return memory[n];
        }
        return memory[n] = getFibonacci(n - 1) + getFibonacci(n - 2);

    }
}
