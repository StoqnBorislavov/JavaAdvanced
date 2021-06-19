package PastExams.FlowerWreathsBeeVetClinic;

import java.sql.Struct;
import java.util.Scanner;

public class Bee {
    static int beeRow = 0;
    static int beeCol = 0;
    static int pollinatedFlowers = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String colElement = sc.nextLine();
            matrix[row] = colElement.toCharArray();
            if (colElement.contains("B")) {
                beeRow = row;
                beeCol = colElement.indexOf('B');
            }
        }
        String command = sc.nextLine();
        boolean isInBounds = true;
        while (!command.equals("End")) {
            switch (command) {
                case "up":
                    isInBounds = moveTheBee(matrix, -1, 0);
                    break;
                case "down":
                    isInBounds = moveTheBee(matrix, +1, 0);
                    break;
                case "left":
                    isInBounds = moveTheBee(matrix, 0, -1);
                    break;
                case "right":
                    isInBounds = moveTheBee(matrix, 0, +1);
                    break;
            }
            if (!isInBounds) {
                System.out.println("The bee got lost!");
                break;
            }

            command = sc.nextLine();
        }
        if (pollinatedFlowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinatedFlowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", (5 - pollinatedFlowers));
        }
        printMatrix(matrix);
    }

    private static boolean moveTheBee(char[][] matrix, int rowModification, int colModification) {
        int currentRow = beeRow;
        int currentCol = beeCol;

        beeRow += rowModification;
        beeCol += colModification;
        matrix[currentRow][currentCol] = '.';

        if (!ensureIndexIsInBounds(beeRow, matrix) || !ensureIndexIsInBounds(beeCol, matrix)) {
            return false;
        }
        if (matrix[beeRow][beeCol] == 'f') {
            pollinatedFlowers++;
        } else if (matrix[beeRow][beeCol] == 'O') {
            moveTheBee(matrix, rowModification, colModification);
        }
        matrix[beeRow][beeCol] = 'B';
        return true;
    }

    private static boolean ensureIndexIsInBounds(int index, char[][] matrix) {
        if (index < 0 || index >= matrix.length) {
            return false;
        }
        return true;
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] row : matrix) {
            for (char element : row) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
