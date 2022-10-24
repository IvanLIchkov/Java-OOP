package CardSuit;

public class Card {
    private Suits cardSuits;
    private Ranks cardRank;

    public Card(Suits cardSuits, Ranks cardRank) {
        this.cardSuits = cardSuits;
        this.cardRank = cardRank;
    }

    public Suits getCardSuits() {
        return cardSuits;
    }

    public Ranks getCardRank() {
        return cardRank;
    }

    public int getPower() {
        return cardRank.getPower() + cardSuits.getSuitPower();
    }
}
