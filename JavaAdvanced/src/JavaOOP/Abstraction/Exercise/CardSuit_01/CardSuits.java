package JavaOOP.Abstraction.Exercise.CardSuit_01;

public enum CardSuits {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(23),
    SPADES(39);

    private int suitPower;

    CardSuits(int suitPower) {
        this.suitPower = suitPower;
    }
    public int getSuitPower(){
        return this.suitPower;
    }
}
