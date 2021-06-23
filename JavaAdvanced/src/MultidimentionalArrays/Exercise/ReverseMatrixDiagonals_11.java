package MultidimentionalArrays.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReverseMatrixDiagonals_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rowsAndCols = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int row = rowsAndCols[0];
        int col = rowsAndCols[1];
        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int currentRow = row - 1;
        int currentCol = col - 1;
        int counter = 0;

        while (currentRow >= 0 && currentCol >= 0) {
            counter++;
            while (currentCol < col && currentRow < row && currentRow >= 0) {
                System.out.print(matrix[currentRow][currentCol] + " ");
                currentRow--;
                currentCol++;
            }
            System.out.println();
            currentRow = row - 1;
            currentCol = col - 1 - counter;
        }

        currentRow = row - 2;
        currentCol = 0;
        counter = 0;

        while (currentRow >= 0 && currentCol >= 0) {
            counter++;
            while (currentCol < col && currentRow < row && currentRow >= 0) {
                System.out.print(matrix[currentRow][currentCol] + " ");
                currentRow--;
                currentCol++;
            }
            System.out.println();
            currentRow = row - 2 - counter;
            currentCol = 0;
        }

        //printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
