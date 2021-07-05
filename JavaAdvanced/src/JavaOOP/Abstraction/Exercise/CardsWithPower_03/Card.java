package JavaOOP.Abstraction.Exercise.CardsWithPower_03;

import JavaOOP.Abstraction.Exercise.CardRanks_02.CardRanks;
import JavaOOP.Abstraction.Exercise.CardSuit_01.CardSuits;

public class Card {
    private CardSuits cardSuit;
    private CardRanks cardRank;
    private int power;

    public Card(CardSuits cardSuit, CardRanks cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    public int getPower() {
        return this.cardSuit.getSuitPower() + this.cardRank.getPowerRank();
    }

    public CardSuits getCardSuit() {
        return cardSuit;
    }

    public CardRanks getCardRank() {
        return cardRank;
    }
}
