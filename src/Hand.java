public class Hand {
    String[] cards;
    String type;
    int value;


    public Hand(String handType, int bidValue, String listCards)
    {
        type = handType;
        value = bidValue;
    }
}
