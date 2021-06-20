package PastExams.TheGardenMakeASaladHealtyHeaven;

import java.util.Arrays;
import java.util.Scanner;

public class TheGarden_01 {
    public static int harmedVegetables = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = Integer.parseInt(sc.nextLine());
        char[][] matrix = new char[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = sc.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        String command = sc.nextLine();
        int lettuce = 0;
        int potatoes = 0;
        int carrots = 0;
        while (!command.equals("End of Harvest")) {
            String[] tokens = command.split("\\s+");
            String realCommand = tokens[0];
            int row = Integer.parseInt(tokens[1]);
            int col = Integer.parseInt(tokens[2]);
            if (realCommand.equals("Harvest")) {
                if (ensureCoordinates(row, col, matrix)) {
                    char harvest = matrix[row][col];
                    if (harvest != ' ') {
                        matrix[row][col] = ' ';
                    }
                    if (harvest == 'L') {
                        lettuce++;
                    } else if (harvest == 'P') {
                        potatoes++;
                    } else if (harvest == 'C') {
                        carrots++;
                    }
                }
            } else if (realCommand.equals("Mole")) {
                String direction = tokens[3];
                switch (direction) {
                    case "up":
                        mollMove(row, col, matrix, -2, 0);
                        break;
                    case "down":
                        mollMove(row, col, matrix, +2, 0);
                        break;
                    case "left":
                        mollMove(row, col, matrix, 0, -2);
                        break;
                    case "right":
                        mollMove(row, col, matrix, 0, +2);
                        break;
                }

            }
            command = sc.nextLine();
        }
        printMatrix(matrix);
        System.out.println("Carrots: " + carrots);
        System.out.println("Potatoes: " + potatoes);
        System.out.println("Lettuce: " + lettuce);
        System.out.println("Harmed vegetables: " + harmedVegetables);

    }

    private static void mollMove(int row, int col, char[][] matrix, int rowModification, int colModification) {

        while (ensureCoordinates(row, col, matrix)) {
            if (matrix[row][col] != ' ') {
                matrix[row][col] = ' ';
                harmedVegetables++;
            }
            row += rowModification;
            col += colModification;

        }
    }

    private static boolean ensureCoordinates(int row, int col, char[][] matrix) {
        return (row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[row].length);
    }

    private static void printMatrix(char[][] matrix) {
        Arrays.stream(matrix).forEach(line -> System.out.println(Arrays.toString(line)
                .replaceAll("[\\[\\]]", "").replaceAll(", ", " ")));
    }
//    public static void printMatrix() {
//        for (int i = 0; i < matrix.length; i++) {
//            for (int j = 0; j < matrix[i].length; j++) {
//                if (j == matrix[i].length - 1) {
//                    System.out.print(matrix[i][j]);
//                } else {
//                    System.out.print(matrix[i][j] + " ");
//                }
//            }
//            System.out.println();
//        }
//    }
}
