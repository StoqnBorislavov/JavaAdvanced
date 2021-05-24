package MultidimentionalArrays.Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation_06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rotation = sc.nextLine();
        int degrees = Integer.parseInt(rotation.substring(7, rotation.length() -1));
        List<String> words = new ArrayList<>();
        String word = sc.nextLine();
        int maxLength = 0;
        while (!word.equals("END")){
            int length = word.length();
            words.add(word);
            if(length > maxLength){
                maxLength = length;
            }
            word = sc.nextLine();
        }
        int rows = words.size();
        int cols = maxLength;
        String[][] matrix = readMatrix(rows, cols, words);
        if(degrees % 360 == 90) {
            rotateMatrixIn90Degrees(rows, cols, matrix);
        } else if (degrees % 360 == 180){
            rotateMatrixIn180Degrees(rows, cols, matrix);
        } else if (degrees % 360 == 270){
            rotateMatrixIn270Degrees(rows, cols, matrix);
        } else if(degrees % 360 == 0){
            printMatrix(matrix);
        }

    }

    private static void rotateMatrixIn270Degrees(int rows, int cols, String[][] matrix) {
        int currentRows = 0;
        int currentCols = cols - 1;
        while (currentCols >= 0){
            if(matrix[currentRows][currentCols].equals("")){
                matrix[currentRows][currentCols] = " ";
            }
            System.out.print(matrix[currentRows][currentCols]);
            currentRows++;
            if(currentRows > rows - 1){
                currentRows = 0;
                currentCols--;
                System.out.println();
            }
        }
    }

    private static void rotateMatrixIn180Degrees(int rows, int cols, String[][] matrix) {
        int currentRows = rows - 1;
        int currentCols = cols - 1;
        while (currentRows >= 0){
            if(matrix[currentRows][currentCols].equals("")){
                matrix[currentRows][currentCols] = " ";
            }
            System.out.print(matrix[currentRows][currentCols]);
            currentCols--;
            if(currentCols < 0){
                currentCols = cols - 1;
                currentRows--;
                System.out.println();
            }
        }
    }

    public static void rotateMatrixIn90Degrees(int rows, int cols, String[][] matrix){
        int currentRows = rows - 1;
        int currentCols = 0;
        while (currentCols < cols){
            if(matrix[currentRows][currentCols].equals("")){
                matrix[currentRows][currentCols] = " ";
            }
            System.out.print(matrix[currentRows][currentCols]);
            currentRows--;
            if(currentRows < 0){
                currentRows = rows - 1;
                currentCols++;
                System.out.println();
            }
        }
    }
    private static String[][] readMatrix(int rows, int cols, List<String> words) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if(col >= words.get(row).length()){
                    matrix[row][col] = "";
                } else {
                    matrix[row][col] = words.get(row).charAt(col) + "";
                }
            }
        }
        return matrix;

    }
    public static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }
}
