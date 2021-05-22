package MultidimentionalArrays.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindTheRealQueen_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] matrix = readMatrix(8, 8, sc, "\\s+");
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 'q' && validPosition(row, col, matrix)) {
                    System.out.println(row + " " + col);
                    break;
                }
            }
        }
    }

    private static boolean validPosition(int row, int col, char[][] matrix) {
        boolean isValid = true;
        char element = matrix[row][col];
        // iterates over the row on the left side
        int currentRow = row;
        int currentCol = col - 1;
        while (currentCol >= 0) {
            if (matrix[currentRow][currentCol] == element) {
                return false;
            }
            currentCol--;
        }
        // iterates over the row on the right side
        currentRow = row;
        currentCol = col + 1;
        while (currentCol < matrix[currentRow].length) {

            if (matrix[currentRow][currentCol] == element) {
                return false;
            }
            currentCol++;
        }
        // iterates over the col on the up
        currentRow = row - 1;
        currentCol = col;
        while (currentRow >= 0) {
            if (matrix[currentRow][currentCol] == element) {
                return false;
            }
            currentRow--;
        }
        // iterates over the col on the down
        currentRow = row + 1;
        currentCol = col;
        while (currentRow < matrix.length) {
            if (matrix[currentRow][currentCol] == element) {
                return false;
            }
            currentRow++;
        }
        // iterates over the firstDiagonal on the left
        currentRow = row - 1;
        currentCol = col - 1;
        while (currentRow >= 0 && currentCol >= 0) {
            if (matrix[currentRow][currentCol] == element) {
                return false;
            }
            currentRow--;
            currentCol--;
        }
        // iterates over the firstDiagonal on the right
        currentRow = row + 1;
        currentCol = col + 1;
        while (currentRow < matrix.length && currentCol < matrix[currentRow].length) {
            if (matrix[currentRow][currentCol] == element) {
                return false;
            }
            currentRow++;
            currentCol++;
        }
        // iterates over the secondDiagonal on the left
        currentRow = row + 1;
        currentCol = col - 1;
        while (currentRow < matrix.length && currentCol >= 0) {
            if (matrix[currentRow][currentCol] == element) {
                return false;
            }
            currentRow++;
            currentCol--;
        }
        // iterates over the secondDiagonal on the right
        currentRow = row - 1;
        currentCol = col + 1;
        while (currentRow >= 0 && currentCol < matrix[currentRow].length) {
            if (matrix[currentRow][currentCol] == element) {
                return false;
            }
            currentRow--;
            currentCol++;
        }
        return true;

    }


    public static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static char[][] readMatrix(int rows, int cols, Scanner sc, String pattern) {
        char[][] matrix = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] tokens = sc.nextLine().split(pattern);
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = tokens[col].charAt(0);
            }
        }
        return matrix;

    }

    private static int getClosestItemsSum(int row, int col, int[][] matrix, int wrongValue) {

        int sum = 0;
        if (col + 1 < matrix[row].length && matrix[row][col + 1] != wrongValue) {
            sum += matrix[row][col + 1];
        }
        if (col - 1 >= 0 && matrix[row][col - 1] != wrongValue) {
            sum += matrix[row][col - 1];
        }
        if (row + 1 < matrix.length && matrix[row + 1][col] != wrongValue) {
            sum += matrix[row + 1][col];
        }
        if (row - 1 >= 0 && matrix[row - 1][col] != wrongValue) {
            sum += matrix[row - 1][col];
        }
        return sum;
    }

    public static List<int[]> findNumberOccurrences(int[][] matrix, int number) {
        List<int[]> outPut = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                if (current == number) {
                    outPut.add(new int[]{row, col});
                }
            }
        }
        return outPut;
    }

    private static boolean matricesAreEqual(int[][] first, int[][] second) {
        if (first.length != second.length) {
            return false;
        }

        for (int row = 0; row < first.length; row++) {
            int[] firstArray = first[row];
            int[] secondArray = second[row];
            if (firstArray.length != secondArray.length) {
                return false;
            }
            for (int col = 0; col < firstArray.length; col++) {
                if (firstArray[col] != secondArray[col]) {
                    return false;
                }
            }
        }
        return true;
    }

//    public static int[][] readMatrix(int rows, int cols, Scanner sc, String pattern) {
//        int[][] matrix = new int[rows][cols];
//
//        for (int i = 0; i < rows; i++) {
//            matrix[i] = readArray(sc.nextLine(), pattern);
//        }
//        return matrix;
//    }

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
