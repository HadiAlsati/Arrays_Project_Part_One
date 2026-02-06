import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String fileData = "";
        try {
            File f = new File("src/data");
            Scanner s = new Scanner(f);

            while (s.hasNextLine()) {
                String line = s.nextLine();
                fileData += line + "\n";
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        String[] lines = fileData.split("\n");
//        System.out.println(Arrays.toString(lines));
        //Hand [] listHands = new int[lines];
        int numFiveKind = 0;
        int numFourKind = 0;
        int numFullHouses = 0;
        int numThreeKind = 0;
        int numTwoPair = 0;
        int numOnePair = 0;
        int numHighCard = 0;
        int indexAce = 0;
        int indexKing = 1;
        int indexQueen = 2;
        int indexJack = 3;
        int indexTen = 4;
        int indexNine = 5;
        int indexEight = 6;
        int indexSeven = 7;
        int indexSix = 8;
        int indexFive = 9;
        int indexFour = 10;
        int indexThree = 11;
        int indexTwo = 12;
        int counterLines = 0;
        for (String line : lines)
        {
            counterLines++;
        }
        Hand [] storeHands = new Hand[counterLines];
        for (String line : lines)
        {
            int numPairs = 0;
            int numTriples = 0;
            int [] numCards = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            String[] hands = line.split("[,|]");
            int[] values = new int[hands.length];
            for (int i = 0; i < hands.length; i++)
            {
                if ((hands[i]).equals("Ace"))
                {
                    numCards[indexAce]++;
                }
                if ((hands[i]).equals("King"))
                {
                    numCards[indexKing]++;
                }
                if ((hands[i]).equals("Queen"))
                {
                    numCards[indexQueen]++;
                }
                if ((hands[i]).equals("Jack"))
                {
                    numCards[indexJack]++;
                }
                if ((hands[i]).equals("10"))
                {
                    numCards[indexTen]++;
                }
                if ((hands[i]).equals("9"))
                {
                    numCards[indexNine]++;
                }
                if ((hands[i]).equals("8"))
                {
                    numCards[indexEight]++;
                }
                if ((hands[i]).equals("7"))
                {
                    numCards[indexSeven]++;
                }
                if ((hands[i]).equals("6"))
                {
                    numCards[indexSix]++;
                }
                if ((hands[i]).equals("5"))
                {
                    numCards[indexFive]++;
                }
                if ((hands[i]).equals("4"))
                {
                    numCards[indexFour]++;
                }
                if ((hands[i]).equals("3"))
                {
                    numCards[indexThree]++;
                }
                if ((hands[i]).equals("2"))
                {
                    numCards[indexTwo]++;
                }
            }
            for (int  i = 0; i < numCards.length; i++)
            {
                if ((numCards[i]) == 5)
                {
                    numFiveKind++;
//                    storeHands [i] = new Hand("Five of a kind", (10));
                }
                if ((numCards[i]) == 4)
                {
                    numFourKind++;
                }
                if ((numCards[i]) == 3)
                {
                    numTriples++;
                }
                if ((numCards[i]) == 2)
                {
                    numPairs++;
                }
            }
            if (numTriples == 1 && numPairs == 1)
            {
                numFullHouses++;
            }
            else if (numTriples == 1 && numPairs == 0)
            {
                numThreeKind++;
            }
            else if (numTriples == 0 && numPairs == 2)
            {
                numTwoPair++;
            }
            else if (numTriples == 0 && numPairs == 1)
            {
                numOnePair++;
            }
            else
            {
                numHighCard++;
            }

        }

        System.out.println("Number of five of a kind hands: " + numFiveKind);
        System.out.println("Number of full house hands: " + numFullHouses);
        System.out.println("Number of four of a kind hands: " + numFourKind);
        System.out.println("Number of three of a kind hands: " + numThreeKind);
        System.out.println("Number of two pair hands: " + numTwoPair);
        System.out.println("Number of one pair hands: " + numOnePair);
        System.out.println("Number of high card hands: " + (numHighCard -(numFiveKind + numFourKind)));
        System.out.println(Arrays.toString(storeHands));
    }

}