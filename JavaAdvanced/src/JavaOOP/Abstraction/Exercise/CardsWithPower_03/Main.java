package JavaOOP.Abstraction.Exercise.CardsWithPower_03;

import JavaOOP.Abstraction.Exercise.CardRanks_02.CardRanks;
import JavaOOP.Abstraction.Exercise.CardSuit_01.CardSuits;
import JavaOOP.input.Reader;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rank = Reader.readStringArray("\\s+")[0];
        String suit = Reader.readStringArray("\\s+")[0];

        Card card = new Card(CardSuits.valueOf(suit), CardRanks.valueOf(rank));

        System.out.printf("Card name: %s of %s; Card power: %d", rank, suit, card.getPower());
    }
}
