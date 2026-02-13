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
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        String[] lines = fileData.split("\n");
        int totBidValue = 0;
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
        for (String line : lines) {


            counterLines++;
        }
        int constantCounterLines = counterLines;
        Hand[] storeHands = new Hand[counterLines];
        for (String line : lines) {
            String[] allCards = new String[5];
            int numPairs = 0;
            int numTriples = 0;
            int[] numCards = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            String[] hands = line.split("[,|]");
            int bidValue = Integer.parseInt(hands[hands.length - 1]);
            for (int i = 0; i < hands.length; i++)
            {
                if ((hands[i]).equals("Ace")) {
                    numCards[indexAce]++;
                    allCards[i] = "Ace";
                }
                if ((hands[i]).equals("King")) {
                    numCards[indexKing]++;
                    allCards[i] = "King";
                }
                if ((hands[i]).equals("Queen")) {
                    numCards[indexQueen]++;
                    allCards[i] = "Queen";
                }
                if ((hands[i]).equals("Jack")) {
                    numCards[indexJack]++;
                    allCards[i] = "Jack";
                }
                if ((hands[i]).equals("10")) {
                    numCards[indexTen]++;
                    allCards[i] = "10";
                }
                if ((hands[i]).equals("9")) {
                    numCards[indexNine]++;
                    allCards[i] = "9";
                }
                if ((hands[i]).equals("8")) {
                    numCards[indexEight]++;
                    allCards[i] = "8";
                }
                if ((hands[i]).equals("7")) {
                    numCards[indexSeven]++;
                    allCards[i] = "7";
                }
                if ((hands[i]).equals("6")) {
                    numCards[indexSix]++;
                    allCards[i] = "6";
                }
                if ((hands[i]).equals("5")) {
                    numCards[indexFive]++;
                    allCards[i] = "5";
                }
                if ((hands[i]).equals("4")) {
                    numCards[indexFour]++;
                    allCards[i] = "4";
                }
                if ((hands[i]).equals("3")) {
                    numCards[indexThree]++;
                    allCards[i] = "3";
                }
                if ((hands[i]).equals("2")) {
                    numCards[indexTwo]++;
                    allCards[i] = "2";
                }
            }
            boolean classified = false;
            for (int i = 0; i < numCards.length; i++)
            {
                if ((numCards[i]) == 5) {
                    numFiveKind++;
                    storeHands[counterLines - (constantCounterLines)] = new Hand(1, (bidValue), allCards, 1);
                    counterLines++;
                    classified = true;
                }
                if ((numCards[i]) == 4) {
                    numFourKind++;
                    storeHands[counterLines - (constantCounterLines)] = new Hand(2, (bidValue), allCards, 1);
                    counterLines++;
                    classified = true;
                }
                if ((numCards[i]) == 3) {
                    numTriples++;
                }
                if ((numCards[i]) == 2) {
                    numPairs++;
                }
            }
            if (!classified) {
                if (numTriples == 1 && numPairs == 1) {
                    numFullHouses++;
                    storeHands[counterLines - (constantCounterLines)] = new Hand(3, (bidValue), allCards, 1);
                    counterLines++;


                } else if (numTriples == 1 && numPairs == 0) {
                    numThreeKind++;
                    storeHands[counterLines - (constantCounterLines)] = new Hand(4, (bidValue), allCards, 1);
                    counterLines++;
                } else if (numTriples == 0 && numPairs == 2) {
                    numTwoPair++;
                    storeHands[counterLines - (constantCounterLines)] = new Hand(5, (bidValue), allCards, 1);
                    counterLines++;
                } else if (numTriples == 0 && numPairs == 1) {
                    numOnePair++;
                    storeHands[counterLines - (constantCounterLines)] = new Hand(6, (bidValue), allCards, 1);
                    counterLines++;
                } else {
                    numHighCard++;
                    storeHands[counterLines - (constantCounterLines)] = new Hand(7, (bidValue), allCards, 1);
                    counterLines++;
                }
            }
        }
        int totalWinnings = 0;

        for (int i = 0; i < storeHands.length; i++) {

            int rank = 1;

            for (int j = 0; j < storeHands.length; j++) {

                if (i != j) {

                    if (storeHands[i].compareHands(storeHands[j]) > 0) {
                        rank++;
                    }
                }
            }

            storeHands[i].rank = rank;
            totalWinnings += rank * storeHands[i].getBidValue();
        }


        System.out.println("Number of five of a kind hands: " + numFiveKind);
        System.out.println("Number of full house hands: " + numFullHouses);
        System.out.println("Number of four of a kind hands: " + numFourKind);
        System.out.println("Number of three of a kind hands: " + numThreeKind);
        System.out.println("Number of two pair hands: " + numTwoPair);
        System.out.println("Number of one pair hands: " + numOnePair);
        System.out.println("Number of high card hands: " + (numHighCard));
        System.out.println("Total Bid Value: " + totalWinnings);


    }
}



