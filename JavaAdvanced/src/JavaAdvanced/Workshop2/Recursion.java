package JavaAdvanced.Workshop2;

import java.util.Arrays;
import java.util.Scanner;

public class Recursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        for (int i = 1; i <= 10; i++) {
//            System.out.println(i);
//        }
        //printNumber(1);
        int power = pow(2, 6);
        System.out.println(power);

        int[] arr = new int[]{13, 42, 69, 73};
        int sum = sumArr(arr, 0);
        System.out.println(sum);

        int[] dimensions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = sc.nextLine().replaceAll("\\s+", "").toCharArray();

        }
        dimensions = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        char color = sc.nextLine().charAt(0);
        int startRow = dimensions[0];
        int startCol = dimensions[1];

        char oldColor = matrix[startRow][startCol];

        colorPlane(matrix, startRow, startCol, color, oldColor);

        printMatrix(matrix);

    }

    private static void colorPlane(char[][] matrix, int row, int col, char color, char oldColor) {
        if(isOutOfBounds(matrix, row, col)){
            return;
        }
        if(matrix[row][col] != oldColor){
            return;
        }

        matrix[row][col] = color;
        //down
        colorPlane(matrix, row +1, col, color, oldColor);
        //up
        colorPlane(matrix, row -1, col, color, oldColor);
        //right
        colorPlane(matrix, row, col +1, color, oldColor);
        //left
        colorPlane(matrix, row, col - 1, color, oldColor);

    }

    private static boolean isOutOfBounds(char[][] matrix, int row, int col) {
        return row >= matrix.length || row < 0 || col>= matrix[row].length || col < 0;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static int sumArr(int[] arr, int index) {
        if(index == arr.length){
            return  0;
        }
        return arr[index] + sumArr(arr, index + 1);
    }

    private static int pow(int x, int n) {
        if(n == 1){
            return x;
        }
       return x * pow(x, n - 1);
    }

    public static void printNumber(int i){
        if(i <= 10) {
            System.out.println(i);
            printNumber(i + 1);
        }
    }



}
