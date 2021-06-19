package PastExams.LootBoxReVoltGuilt;

import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());

        int linesCount = Integer.parseInt(sc.nextLine());

        int[] position = new int[2];

        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String line = sc.nextLine();
            matrix[row] = line.toCharArray();

            if (line.contains("f")) {
                position[0] = row;
                position[1] = line.indexOf("f");

            }

        }

        boolean playerWon = false;
        while (linesCount-- > 0 && !playerWon) {
            String command = sc.nextLine();
            if (command.equals("up")) {
                playerWon = movePlayer(position, matrix, -1, 0);
            } else if (command.equals("down")) {
                playerWon = movePlayer(position, matrix, +1, 0);
            } else if (command.equals("left")) {
                playerWon = movePlayer(position, matrix, 0, -1);
            } else if (command.equals("right")) {
                playerWon = movePlayer(position, matrix, 0, +1);
            }

        }
        if (playerWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }


        printMatrix(matrix);
    }

    private static boolean movePlayer(int[] position, char[][] matrix, int rowModification, int colModification) {

        //up row - 1, col
        int row = position[0];
        int col = position[1];
        int newRow = ensureIndexIsInBounds(row + rowModification, matrix.length);
        int newCol = ensureIndexIsInBounds(col + colModification, matrix.length);
        boolean hasWon = false;
        if (matrix[newRow][newCol] == 'B') {
            newRow = ensureIndexIsInBounds(newRow + rowModification, matrix.length);
            newCol = ensureIndexIsInBounds(newCol + colModification, matrix.length);
        } else if (matrix[newRow][newCol] == 'T') {
            newRow = row;
            newCol = col;
        }
        if (matrix[newRow][newCol] == 'F') {
            hasWon = true;
        }
        matrix[newRow][newCol] = 'f';
        matrix[row][col] = '-';
        position[0] = newRow;
        position[1] = newCol;
        return hasWon;
    }

    private static int ensureIndexIsInBounds(int index, int bounds) {
        if (index < 0) {
            index = bounds - 1;
        } else if (index >= bounds) {
            index = 0;
        }
        return index;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char symbol : arr) {
                System.out.print(symbol);
            }
            System.out.println();
        }
    }
}
