package MultidimentionalArrays.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FillTheMatrix_01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> command = readArrayInList(sc.nextLine(), ", ");
        int n = Integer.parseInt(command.get(0));
        String pattern = command.get(1);
        int[][] matrix = new int[n][n];
        switch (pattern){
            case "A":
                matrix = fillTheMatrixPatternA(matrix);
                printMatrix(matrix);
                break;
            case "B":
                matrix = fillTheMatrixPatternB(matrix);
                printMatrix(matrix);
                break;
        }
    }

    private static int[][] fillTheMatrixPatternB(int[][] matrix) {
        int row = 0;
        int col = 0;
        int counter =0;
        int colCount = 1;
        while (col < matrix[row].length){
            matrix[row][col]= ++counter;
            if(row + 1 < matrix.length && colCount % 2 != 0) {
                row++;
            } else if (row > 0 && colCount % 2 == 0){
                row--;
            } else {
                colCount++;
                col++;
            }
        }
        return matrix;
    }

    private static int[][] fillTheMatrixPatternA(int[][] matrix) {
        int row = 0;
        int col = 0;
        int counter =0;
        while (col < matrix[row].length){
            matrix[row][col]= ++counter;
            if(row + 1 < matrix.length){
                row++;
            } else{
                row = 0;
                col++;
            }
        }
        return matrix;
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

    public static List<String> readArrayInList(String line, String pattern) {
        return Arrays.stream(line.
                split(pattern)).collect(Collectors.toList());
    }
}
