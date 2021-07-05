package JavaAdvanced.MultidimentionalArrays.Exercise;

import java.util.Scanner;

public class TheHeiganDance_08 {
    public static int playerRow = 7;
    public static int playerCol = 7;
    public static int playerHealth = 18500;
    public static int[][] chamber = new int[15][15];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double playerDamage = Double.parseDouble(sc.nextLine());
        int previousColHit = -100;
        int previousRowHit = -100;
        double bossHealth = 3000000;
        String previousSpell = "";
        String currentSpell = "";
        while (playerHealth > 0 && bossHealth > 0){
            bossHealth -= playerDamage;

            if(bossHealth <=0){
                if(chamber[playerRow][playerCol] > 0){
                    playerHealth -= 3500;
                }
                continue;
            }
            String[] input = sc.nextLine().split("\\s+");
            currentSpell = input[0];
            int rowHit = Integer.parseInt(input[1]);
            int colHit = Integer.parseInt(input[2]);
            if (currentSpell.equals("Cloud")){
                if(chamber[playerRow][playerCol] > 0){
                    playerHealth -= 3500;
                    if(playerHealth < 0){
                        currentSpell = previousSpell;
                        continue;
                    }
                }
                if(previousSpell.equals("Cloud")){
                    spellAOE(previousRowHit, previousColHit, -1);
                }
                spellAOE(rowHit, colHit, 2);
                if(chamber[playerRow][playerCol] > 0){
                    moveThePlayer();
                }
                if(chamber[playerRow][playerCol] > 0){
                    playerHealth -= 3500;

                }
                spellAOE(rowHit, colHit, -1);

            } else if(currentSpell.equals("Eruption")){
                if(chamber[playerRow][playerCol] > 0){
                    playerHealth -= 3500;
                    if(playerHealth <= 0){
                        currentSpell = previousSpell;
                        continue;
                    }
                }
                if(previousSpell.equals("Cloud")){
                    spellAOE(previousRowHit, previousColHit, -1);
                }
                spellAOE(rowHit, colHit, 1);
                if(chamber[playerRow][playerCol] > 0){
                    moveThePlayer();
                }
                if(chamber[playerRow][playerCol] > 0) {
                playerHealth -=6000;
                }
                spellAOE(rowHit, colHit, -1);

            }
            previousRowHit =rowHit;
            previousColHit = colHit;
            previousSpell = currentSpell;

        }
        currentSpell = currentSpell.equals("Cloud") ? "Plague Cloud" : currentSpell;

        if (bossHealth <= 0) {
            System.out.printf("Heigan: Defeated!%n");
        } else {
            System.out.printf("Heigan: %.2f%n", bossHealth);
        }

        if (playerHealth <= 0) {
            System.out.printf("Player: Killed by %s%n", currentSpell);
        } else {
            System.out.printf("Player: %d%n", playerHealth);
        }

        System.out.printf("Final position: %d, %d", playerRow, playerCol);
    }
    private static void moveThePlayer() {
        if (playerRow - 1 >= 0 && chamber[playerRow - 1][playerCol] == 0) {
            playerRow--;
        } else if (playerCol + 1 < chamber[playerRow].length && chamber[playerRow][playerCol + 1] == 0) {
            playerCol++;
        } else if (playerRow + 1 < chamber.length && chamber[playerRow + 1][playerCol] == 0) {
            playerRow++;
        } else if (playerCol - 1 >= 0 && chamber[playerRow][playerCol - 1] == 0) {
            playerCol--;
        }

    }
    private static void spellAOE(int rowHit, int colHit, int duration) {
        for (int row = rowHit - 1; row <= rowHit + 1; row++) {
            for (int col = colHit - 1; col <= colHit + 1; col++) {
                if (isInChamber(row, col)) {
                    chamber[row][col] += duration;
                }
            }
        }
    }
    private static boolean isInChamber(int row, int col) {
        return row >= 0 && row < chamber.length && col >= 0 && col < chamber[row].length;
    }
}
