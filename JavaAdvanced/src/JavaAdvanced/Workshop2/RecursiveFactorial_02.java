package JavaAdvanced.Workshop2;

import java.util.Scanner;

public class RecursiveFactorial_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = Integer.parseInt(sc.nextLine());

        System.out.println(recursiveFactorial(x));
    }

    private static int recursiveFactorial(int x) {
        if(x == 1){
            return 1;
        } else {
           return x * recursiveFactorial(x - 1);
        }

    }
}
