package JavaAdvanced.PastExams.CookingSellingOpenning;

import java.util.Scanner;

public class Selling_02 {
    public static int currentRow = 0;
    public static int currentCol = 0;
    public static int money = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        char [][] matrix = new char[size][size];
        for (int i = 0; i < size; i++) {
            String line = sc.nextLine();
            matrix[i] = line.toCharArray();
            if(line.contains("S")){
                currentRow = i;
                currentCol = line.indexOf("S");
            }
        }
        boolean isInBounds = true;
        while (money < 50){
            String command = sc.nextLine();
                switch (command){
                    case "up":
                       isInBounds =  moveTheWorm(matrix, -1, 0);
                        break;
                    case "down":
                        isInBounds =  moveTheWorm(matrix, +1, 0);
                        break;
                    case "left":
                        isInBounds =  moveTheWorm(matrix, 0, -1);
                        break;
                    case "right":
                        isInBounds =  moveTheWorm(matrix, 0, +1);
                        break;
                }
                if(!isInBounds){
                    break;
                }
        }

        if(!isInBounds){
            System.out.println("Bad news, you are out of the bakery.");
        }

        if(money >= 50){
            System.out.println("Good news! You succeeded in collecting enough money!");

        }
        System.out.println("Money: " + money);
        System.out.println(getMatrix(matrix));

    }

    private static boolean moveTheWorm(char[][] matrix, int rowModification, int colModification) {
        matrix[currentRow][currentCol] = '-';
       if( ensureIndexIsInBounds(currentRow + rowModification, matrix) && ensureIndexIsInBounds(currentCol + colModification, matrix)){
           if(matrix[currentRow + rowModification][currentCol + colModification] == 'O'){
               matrix[currentRow + rowModification][currentCol + colModification] = '-';
               for (int i = 0; i < matrix.length; i++) {
                   for (int j = 0; j < matrix[i].length; j++) {
                       if(matrix[i][j] == 'O'){
                           matrix[i][j] = 'S';
                           currentRow = i;
                           currentCol = j;
                           return  true;
                       }
                   }
               }
           } else if (matrix[currentRow + rowModification][currentCol + colModification] != '-'){
               money += Integer.parseInt(matrix[currentRow + rowModification][currentCol + colModification] + "");
               matrix[currentRow + rowModification][currentCol + colModification] = 'S';
           } else {
               matrix[currentRow + rowModification][currentCol + colModification] = 'S';
           }

           currentRow += rowModification;
           currentCol += colModification;
           return true;
       } else {
           return false;
       }
    }

    private static boolean ensureIndexIsInBounds(int index, char[][] matrix) {
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
