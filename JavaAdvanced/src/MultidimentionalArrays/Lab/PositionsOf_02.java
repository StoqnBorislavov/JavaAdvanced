package MultidimentionalArrays.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PositionsOf_02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rowsAndCols = readArray(sc.nextLine());
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = readMatrix(rows, cols, sc);
        int number = Integer.parseInt(sc.nextLine());
        boolean isFound = false;

        List<int[]> outPut = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int current = matrix[row][col];
                if(current == number){
                    isFound = true;
                    outPut.add(new int[]{row, col});
                }
            }
        }
        if(outPut.isEmpty()){
            System.out.println("not found");
        } else {
            for (int[] indexes : outPut) {
                System.out.println(indexes[0] + " " + indexes[1]);
            }
        }
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

    public static int[][] readMatrix(int rows, int cols, Scanner sc) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(sc.nextLine());
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

    public static int[] readArray(String line) {
        return Arrays.stream(line.
                split("\\s+")).
                mapToInt(Integer::parseInt).
                toArray();
    }
}
