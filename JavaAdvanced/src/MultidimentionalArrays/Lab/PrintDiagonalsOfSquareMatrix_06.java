package MultidimentionalArrays.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int[][] matrix = readMatrix(n, n, sc, "\\s+");
        int row = 0;
        int col = 0;
        while (row < n && col < n){
            System.out.print(matrix[row++][col++]);
        }
        System.out.println();
        row = matrix.length - 1;
        col = 0;
        while (row < n && col < n) {
            System.out.print(matrix[row--][col++]);
        }


    }
    private static int getClosestItemsSum(int row, int col, int[][] matrix, int wrongValue) {

        int sum = 0;
        if(col + 1 < matrix[row].length && matrix[row][col + 1] != wrongValue){
            sum += matrix[row][col + 1];
        }
        if(col -1 >= 0 && matrix[row][col - 1] != wrongValue){
            sum += matrix[row][col - 1];
        }
        if(row + 1 < matrix.length && matrix[row + 1][col] != wrongValue){
            sum += matrix[row + 1][col];
        }
        if(row - 1 >= 0 && matrix[row - 1][col] != wrongValue){
            sum += matrix[row - 1][col];
        }
        return sum;
    }

    public static List<int[]> findNumberOccurrences(int[][]matrix, int number){
        List<int[]> outPut = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                if(current == number){
                    outPut.add(new int[]{row, col});
                }
            }
        }
        return outPut;
    }
    private static boolean matricesAreEqual(int[][] first, int[][] second) {
        if(first.length != second.length){
            return false;
        }

        for (int row = 0; row < first.length; row++) {
            int[] firstArray = first[row];
            int[] secondArray = second[row];
            if(firstArray.length != secondArray.length){
                return  false;
            }
            for (int col = 0; col < firstArray.length; col++) {
                if(firstArray[col] != secondArray[col]){
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] readMatrix(int rows, int cols, Scanner sc, String pattern) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(sc.nextLine(), pattern);
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static int[] readArray(String line, String pattern) {
        return Arrays.stream(line.
                split(pattern)).
                mapToInt(Integer::parseInt).
                toArray();
    }
}
