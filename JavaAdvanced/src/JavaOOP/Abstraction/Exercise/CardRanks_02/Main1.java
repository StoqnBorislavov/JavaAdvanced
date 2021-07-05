package JavaOOP.Abstraction.Exercise.CardRanks_02;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Card Ranks:");

        for (CardRanks card : CardRanks.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", card.ordinal(), card.toString());
        }
    }
}
