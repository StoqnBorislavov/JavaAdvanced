package JavaOOP.Abstraction.Exercise.JediGalaxy_05;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int n = dimensions[0];
        int m = dimensions[1];

        int[][] matrix = new int[n][m];

        fillMatrix(n, m, matrix);

        String command = scanner.nextLine();
        long sum = 0;

        while (!command.equals("Let the Force be with you")) {
            int[] playerPosition = Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] evilPosition = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int evilRow = evilPosition[0];
            int evilCol = evilPosition[1];

            while (evilRow >= 0 && evilCol >= 0) {
                if (isInRange(matrix, evilRow, evilCol)) {
                    matrix[evilRow][evilCol] = 0;
                }
                evilRow--;
                evilCol--;
            }

            int playerRow = playerPosition[0];
            int playerCol = playerPosition[1];

            while (playerRow >= 0 && playerCol < matrix[1].length) {
                if (isInRange(matrix, playerRow, playerCol)) {
                    sum += matrix[playerRow][playerCol];
                }
                playerCol++;
                playerRow--;
            }
            command = scanner.nextLine();
        }

        System.out.println(sum);

    }

    private static boolean isInRange(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length;
    }

    private static void fillMatrix(int n, int m, int[][] matrix) {
        int value = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                matrix[row][col] = value++;
            }
        }
    }
}
