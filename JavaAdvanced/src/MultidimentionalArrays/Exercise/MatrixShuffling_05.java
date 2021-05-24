package MultidimentionalArrays.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MatrixShuffling_05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rowsAndCols = readArray(sc.nextLine(), "\\s+");
        int row = rowsAndCols[0];
        int col = rowsAndCols[1];
        String[][] matrix = readMatrix(row, col, sc, "\\s+");
        String command = sc.nextLine();
        while (!command.equals("END")){
            String[] tokens = command.split("\\s+");
            if(tokens.length != 5){
                System.out.println("Invalid input!");
                command = sc.nextLine();
                continue;
            }
            int row1 = Integer.parseInt(tokens[1]);
            int col1 = Integer.parseInt(tokens[2]);
            int row2 = Integer.parseInt(tokens[3]);
            int col2 = Integer.parseInt(tokens[4]);
            if(!isInBounds(row1, col1, matrix) || !isInBounds(row2, col2, matrix)){
                System.out.println("Invalid input!");
                command = sc.nextLine();
                continue;
            }
            String firstElement = matrix[row1][col1];
            matrix[row1][col1] = matrix[row2][col2];
            matrix[row2][col2] = firstElement;
            printMatrix(matrix);
            command = sc.nextLine();
        }



    }
    private static String[][] readMatrix(int rows, int cols, Scanner sc, String pattern) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] tokens = sc.nextLine().split(pattern);
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = tokens[col];
            }
        }
        return matrix;

    }

    public static boolean isInBounds(int row, int col, String[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

    public static int[][] getMaxSumSubMatrix3x3(int[][] matrix) {
        int maxSum = 0;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < matrix.length - 2; row++) {
            for (int col = 0; col < matrix[row].length - 2; col++) {

                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                        matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];

                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        return new int[][]{
                {matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1], matrix[bestRow][bestCol + 2]},
                {matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1], matrix[bestRow + 1][bestCol + 2]},
                {matrix[bestRow + 2][bestCol], matrix[bestRow + 2][bestCol + 1], matrix[bestRow + 2][bestCol + 2]}
        };
    }

    public static int[][] getMaxSumSubMatrix2x2(int[][] matrix) {
        int maxSum = 0;
        int bestRow = 0;
        int bestCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {

                int sum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];

                if (sum > maxSum) {
                    maxSum = sum;
                    bestRow = row;
                    bestCol = col;
                }
            }
        }

        return new int[][]{
                {matrix[bestRow][bestCol], matrix[bestRow][bestCol + 1]},
                {matrix[bestRow + 1][bestCol], matrix[bestRow + 1][bestCol + 1]}
        };
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

    public static void printMatrix(String[][] matrix) {
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
