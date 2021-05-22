package MultidimentionalArrays.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SumMatrixElements_04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rowsAndCols = readArray(sc.nextLine(), ", ");
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] matrix = readMatrix(rows, cols, sc, ", ");
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(getSumOfMatrixElements(matrix));


    }

    public static int getSumOfMatrixElements(int[][] matrix) {
        int sum = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    public static int[][] getMaxSumSubMatrix2x2(int[][] matrix){
        int maxSum = 0;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum =
                        matrix[row][col] +
                                matrix[row][col+1] +
                                matrix[row+1][col] +
                                matrix[row+1][col+1];

                if(sum>maxSum){
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        return new int[][]{
                {matrix[bestRow][bestCol], matrix[bestRow][bestCol+1]},
                {matrix[bestRow+1][bestCol], matrix[bestRow+1][bestCol+1]}
        };
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
