package PastExams.DatingAppBookWormRabbits;

import java.util.Scanner;

public class BookWorm_02 {
    public static int currentRow = 0;
    public static int currentCol = 0;
    public static String finalString = "";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        finalString = sc.nextLine();
        int size = Integer.parseInt(sc.nextLine());
        char[][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
             String line= sc.nextLine();
            matrix[i] = line.toCharArray();
            if(line.contains("P")){
                currentRow = i;
                currentCol = line.indexOf("P");
            }
        }
        String command = sc.nextLine();
        while (!command.equals("end")){
            switch (command){
                case "up":
                    moveTheWorm(matrix, -1, 0);
                    break;
                case "down":
                    moveTheWorm(matrix, +1, 0);
                    break;
                case "left":
                    moveTheWorm(matrix, 0, -1);
                    break;
                case "right":
                    moveTheWorm(matrix, 0, +1);
                    break;
            }
            command = sc.nextLine();
        }


        System.out.println(finalString);
        System.out.println(getMatrix(matrix));
    }

    private static void moveTheWorm(char[][] matrix, int rowModification, int colModification) {
        if(ensureIndexOutOfBounds(currentRow + rowModification, matrix) && ensureIndexOutOfBounds(currentCol+ colModification, matrix)){
          if(matrix[currentRow + rowModification][currentCol+ colModification] != '-'){
              finalString = finalString + matrix[currentRow + rowModification][currentCol+ colModification];
            }
        } else {
            finalString = finalString.substring(0,finalString.length() - 1);
            return;
        }
        matrix[currentRow][currentCol] = '-';
        matrix[currentRow + rowModification][currentCol+ colModification] = 'P';
        currentRow += rowModification;
        currentCol += colModification;

    }

    private static boolean ensureIndexOutOfBounds(int index, char[][] matrix) {
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
