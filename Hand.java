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

    public int strongerCards(int  checkHand [],  int totArray [])
    {
        int typeHandCardCheck = checkHand[0];
        int x = 0;
        for (int i  = 0; i < totArray.length; i++)
        {
            if (typeHandCardCheck < totArray[0])
            {
                checkHand [checkHand.length - 1] = (checkHand[checkHand.length - 1] + 1);
            }

        }
        return x;
    }
}
