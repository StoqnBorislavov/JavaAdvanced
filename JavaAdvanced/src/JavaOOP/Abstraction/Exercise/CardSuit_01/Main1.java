package JavaOOP.Abstraction.Exercise.CardSuit_01;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Card Suits:");

        for (CardSuits suit : CardSuits.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", suit.getSuitPower(), suit.toString());
        }
    }
}
