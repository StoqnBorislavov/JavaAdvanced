package PastExams.BombsSnakeParking;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Bombs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayDeque<Integer> effects = Arrays.stream(sc.nextLine().split(",\\s+"))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));
        ArrayDeque<Integer> casing = new ArrayDeque<>();
        Arrays.stream(sc.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .forEach(casing::push);
        int daturaBombs = 0;
        int cherryBombs = 0;
        int smokeDecoyBombs = 0;
        while (!effects.isEmpty() && !casing.isEmpty()){
            int effect = effects.poll();
            int cas = casing.pop();
            int sum = effect + cas;
            while (!checkForBomb(sum)){
                sum -= 5;
            }
            switch (sum){
                case 40:
                    daturaBombs++;
                    break;
                case 60:
                    cherryBombs++;
                    break;
                case 120:
                    smokeDecoyBombs++;
                    break;
            }
            if(cherryBombs >= 3 && daturaBombs >= 3 && smokeDecoyBombs >= 3){
                break;
            }
        }
        if(daturaBombs >= 3 && cherryBombs >= 3 && smokeDecoyBombs >= 3){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }
        if(effects.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else {
            System.out.println("Bomb Effects: " + String.join(", ", String.valueOf(effects)).replaceAll("[\\[\\]]", ""));
        }
        if(casing.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }else {
            System.out.println("Bomb Casings: " + String.join(", ", String.valueOf(casing)).replaceAll("[\\[\\]]", ""));
        }
        System.out.println("Cherry Bombs: " + cherryBombs);
        System.out.println("Datura Bombs: " + daturaBombs);
        System.out.println("Smoke Decoy Bombs: " + smokeDecoyBombs);

    }

    private static boolean checkForBomb(int sum) {
        return sum == 40 || sum == 60 || sum == 120;
    }
}
