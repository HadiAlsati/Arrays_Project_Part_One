import java.util.Arrays;
public class Hand {
    String[] cards;
    int type;
    int value;
    int rank;




    public Hand(int handType, int bidValue, String[] listCards, int rankValue)
    {
        type = handType;
        value = bidValue;
        cards = listCards;
        rank = rankValue;
    }


    public int getBidValue()
    {
        return value;
    }


    public String toString()
    {
        return type + "." + value + "." +Arrays.toString(cards) + "." + rank;
    }


   public int compareHands(Hand other) {

    if (this.type != other.type) {
        return other.type - this.type;
    }

    for (int i = 0; i < this.cards.length; i++) {

        int thisStrength = getCardValue(this.cards[i]);
        int otherStrength = getCardValue(other.cards[i]);

        if (thisStrength != otherStrength) {
            return thisStrength - otherStrength;
        }
    }

    return 0;
}

private int getCardValue(String card) {
    if (card.equals("Ace")) return 13;
    if (card.equals("King")) return 12;
    if (card.equals("Queen")) return 11;
    if (card.equals("Jack")) return 10;
    if (card.equals("10")) return 9;
    if (card.equals("9")) return 8;
    if (card.equals("8")) return 7;
    if (card.equals("7")) return 6;
    if (card.equals("6")) return 5;
    if (card.equals("5")) return 4;
    if (card.equals("4")) return 3;
    if (card.equals("3")) return 2;
    if (card.equals("2")) return 1;

    return 0;

 }

}
