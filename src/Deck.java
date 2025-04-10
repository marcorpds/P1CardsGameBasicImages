import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cardsDeck;

    public Deck() {
        this.cardsDeck = new ArrayList<Card>();
        String[] suits = { "Diamonds", "Hearts", "Clubs", "Spades" };
        String[] symbols = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };
        int[] values = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11 };
        int[] weights = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
        for (String suit : suits) {
            for (int count = 0; count < symbols.length; count++) {
                Card card = new Card(suit, symbols[count], values[count], weights[count], getImage(suit, symbols[count]));
                cardsDeck.add(card);
            }
        }
        Collections.shuffle(cardsDeck);
    }

    public void addCard(Card card) {
        this.cardsDeck.add(card);
    }

    public Card getCard() {
        Card giveCard = cardsDeck.get(0);
        cardsDeck.remove(0);
        return giveCard;
    }

    public int getSize() {
        return this.cardsDeck.size();
    }

    public String[][] getImage(String suit, String symbol) {
        ArrayList<String> setPositions = new ArrayList<String>();
        String[][] modifiedCardImage = {{" ","_","_","_","_","_","_","_"," "},
                                        {"|"," "," "," "," "," "," "," ","|"},
                                        {"|"," "," "," "," "," "," "," ","|"},
                                        {"|"," "," "," "," "," "," "," ","|"},
                                        {"|"," "," "," "," "," "," "," ","|"},
                                        {"|"," "," "," "," "," "," "," ","|"},
                                        {" ","-","-","-","-","-","-","-"," "}};
        if (!symbol.equals("10")) {
            modifiedCardImage[1][1] = symbol;
            modifiedCardImage[5][7] = symbol;
        }
        else {
            modifiedCardImage[1][1] = symbol;
            modifiedCardImage[1][5] = "";
            modifiedCardImage[5][7] = symbol;
            modifiedCardImage[5][5] = "";
        }
        
        if (suit.equals("Diamonds")) {
            Collections.addAll(setPositions, "/", "\\", "{", "}", "\\", "/");
            modifiedCardImage[2][3] = setPositions.get(0);
            modifiedCardImage[2][5] = setPositions.get(1);
            modifiedCardImage[3][2] = setPositions.get(2);
            modifiedCardImage[3][6] = setPositions.get(3);
            modifiedCardImage[4][3] = setPositions.get(4);
            modifiedCardImage[4][5] = setPositions.get(5);
        }
        else if (suit.equals("Hearts")) {
            Collections.addAll(setPositions, "(", "V", ")", "\\", "/", "V");
            modifiedCardImage[2][2] = setPositions.get(0);
            modifiedCardImage[2][4] = setPositions.get(1);
            modifiedCardImage[2][6] = setPositions.get(2);
            modifiedCardImage[3][3] = setPositions.get(3);
            modifiedCardImage[3][5] = setPositions.get(4);
            modifiedCardImage[4][4] = setPositions.get(5);
        }
        else if (suit.equals("Clubs")) {
            Collections.addAll(setPositions, "O", "O", "^", "O", "|");
            modifiedCardImage[2][4] = setPositions.get(0);
            modifiedCardImage[3][3] = setPositions.get(1);
            modifiedCardImage[3][4] = setPositions.get(2);
            modifiedCardImage[3][5] = setPositions.get(3);
            modifiedCardImage[4][4] = setPositions.get(4);
        }
        else {
            Collections.addAll(setPositions, "/", "\\", "(", "_", "^", "_", ")", "|");
            modifiedCardImage[2][3] = setPositions.get(0);
            modifiedCardImage[2][5] = setPositions.get(1);
            modifiedCardImage[3][2] = setPositions.get(2);
            modifiedCardImage[3][3] = setPositions.get(3);
            modifiedCardImage[3][4] = setPositions.get(4);
            modifiedCardImage[3][5] = setPositions.get(5);
            modifiedCardImage[3][6] = setPositions.get(6);
            modifiedCardImage[4][4] = setPositions.get(7);
        }
        return modifiedCardImage;
    }
}
