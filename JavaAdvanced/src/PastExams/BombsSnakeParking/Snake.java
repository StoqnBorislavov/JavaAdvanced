package PastExams.BombsSnakeParking;

import java.util.Scanner;

public class Snake {
    static int snakeRow = 0;
    static int snakeCol = 0;
    static int eatenFood = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        char[][] matrix = new char[size][size];

        for (int i = 0; i < size; i++) {
            String line = sc.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("S")) {
                snakeRow = i;
                snakeCol = line.indexOf('S');
            }
        }
        boolean isInMatrix = true;
        while (eatenFood < 10 && isInMatrix){
            String command = sc.nextLine();
            switch (command){
                case "up":
                    isInMatrix = moveTheSnake(matrix, -1, 0);
                    break;
                case "down":
                    isInMatrix = moveTheSnake(matrix, +1, 0);
                    break;
                case "left":
                    isInMatrix = moveTheSnake(matrix, 0, -1);
                    break;
                case "right":
                    isInMatrix = moveTheSnake(matrix, 0, +1);
                    break;
            }
        }
        if(isInMatrix){
            System.out.println("You won! You fed the snake.");
        } else {
            System.out.println("Game over!");
        }
        System.out.println("Food eaten: "  + eatenFood);
        System.out.println(getMatrix(matrix));
    }

    private static boolean moveTheSnake(char[][] matrix, int rowModification, int colModification) {
        int currentRow = snakeRow + rowModification;
        int currentCol = snakeCol + colModification;
        matrix[snakeRow][snakeCol] = '.';
        if(ensureIndex(currentRow, matrix) && ensureIndex(currentCol, matrix)){

            if(matrix[currentRow][currentCol] == '*'){
                eatenFood++;
            }else if (matrix[currentRow][currentCol] == 'B'){
                matrix[currentRow][currentCol] = '.';
                for (int row = 0; row < matrix.length; row++) {
                    for (int col = 0; col < matrix[row].length; col++) {
                        if(matrix[row][col] == 'B'){
                            currentRow = row;
                            currentCol = col;
                        }
                    }
                }
            }
            snakeRow = currentRow;
            snakeCol = currentCol;
            matrix[snakeRow][snakeCol] = 'S';
            return true;
        }
        return false;
    }

    private static boolean ensureIndex(int index, char[][] matrix) {
        return index >= 0 && index < matrix.length;
    }

    private static String getMatrix(char[][] matrix) {
        StringBuilder builder = new StringBuilder();
        for (char[] arr : matrix) {
            for (char symbol : arr) {
                builder.append(symbol);
            }
            builder.append(System.lineSeparator());
        }
        return builder.toString();
    }
}
