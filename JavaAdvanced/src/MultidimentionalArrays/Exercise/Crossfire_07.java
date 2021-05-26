package MultidimentionalArrays.Exercise;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire_07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] rowsAndCols = readArray(sc.nextLine(), "\\s+");
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        List<List<Integer>> matrix = new ArrayList<>();
        fillMatrix(sc, matrix, rows, cols);

        String command = sc.nextLine();

        while (!command.equals("Nuke it from orbit")){
            String[] tokens = command.split("\\s+");
            int row = Integer.parseInt(tokens[0]);
            int col = Integer.parseInt(tokens[1]); // index on element in the list
            int radius = Integer.parseInt(tokens[2]);

            // removing elements from top and bottom
            for (int currentRow = row - radius; currentRow <= row + radius; currentRow++) {
                if(isInMatrix(currentRow, col, matrix)) {
                    matrix.get(currentRow).remove(col);
                }
            }
            // removing elements from left to right
            for (int currentCol = col + radius; currentCol >= col - radius; currentCol--){
                if(isInMatrix(row, currentCol, matrix)) {
                    matrix.get(row).remove(currentCol);
                }
            }
            command = sc.nextLine();
        }
        matrix.removeIf(List::isEmpty);

        // print matrix
        printMatrix(matrix, rows, cols);


    }

    private static boolean isInMatrix(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() && col >= 0 && col < matrix.get(row).size();
    }

    public static void printMatrix(List<List<Integer>> matrix, int rows, int cols){
        for (List<Integer> row : matrix) {
            for (Integer element : row) {
                System.out.print(element + " ");
            }
            System.out.println();

        }
    }

    private static void fillMatrix(Scanner sc, List<List<Integer>> matrix, int rows, int cols) {
        int number = 1;
        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
               matrix.get(row).add(number++);
            }
        }
    }

    public static int[][] readMatrix(int rows, int cols, Scanner sc, String pattern) {
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            matrix[i] = readArray(sc.nextLine(), pattern);
        }
        return matrix;
    }

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
