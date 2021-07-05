package JavaAdvanced.MyExam;

import java.util.Scanner;

public class Python {
    public static int currentRow;
    public static int currentCol;
    public static int pythonLength = 1;
    public static int food;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        //List<String> commands = Arrays.stream(sc.nextLine().split(",")).collect(Collectors.toList());
        String[] commands = sc.nextLine().split(",\\s+");
        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            String line = sc.nextLine().replaceAll(" ", "");
            matrix[i] = line.toCharArray();
            if (line.contains("s")) {
                currentRow = i;
                currentCol = line.indexOf("s");
            }
        }
        for (char[] chars : matrix) {
            for (char c : chars) {
                if (c == 'f') {
                    food++;
                }
            }
        }
        boolean isOnEnemy = false;
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            if (!isOnEnemy && food > 0) {
                switch (command) {
                    case "up":
                        isOnEnemy = moveTheWorm(matrix, -1, 0);
                        break;
                    case "down":
                        isOnEnemy = moveTheWorm(matrix, +1, 0);
                        break;
                    case "left":
                        isOnEnemy = moveTheWorm(matrix, 0, -1);
                        break;
                    case "right":
                        isOnEnemy = moveTheWorm(matrix, 0, +1);
                        break;
                }
            } else {
                break;
            }
        }

        if (isOnEnemy) {
            System.out.println("You lose! Killed by an enemy!");
            return;
        }

        if (food == 0) {
            System.out.println("You win! Final python length is " + pythonLength);
        } else {
            System.out.printf("You lose! There is still %d food to be eaten.%n", food);
        }


    }

    private static boolean moveTheWorm(char[][] matrix, int rowModification, int colModification) {
        matrix[currentRow][currentCol] = '*';
        currentRow = ensureIndexIsInBounds(currentRow + rowModification, matrix.length);
        currentCol = ensureIndexIsInBounds(currentCol + colModification, matrix.length);

        if (matrix[currentRow][currentCol] == 'e') {
            matrix[currentRow][currentCol] = 's';
            return true;
        } else if (matrix[currentRow][currentCol] == 'f') {
            matrix[currentRow][currentCol] = 's';
            food--;
            pythonLength++;
            return false;
        }
        matrix[currentRow][currentCol] = 's';
        return false;

    }

    private static int ensureIndexIsInBounds(int index, int bounds) {
        if (index < 0) {
            index = bounds - 1;
        } else if (index >= bounds) {
            index = 0;
        }
        return index;
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
