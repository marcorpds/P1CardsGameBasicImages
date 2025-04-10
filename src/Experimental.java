import java.util.ArrayList;

public class Experimental {
    Deck cardsDeck;

    public Experimental() {
        cardsDeck = new Deck();
    }

    public void start() {
        ArrayList<Card> newDeck = new ArrayList<Card>();
        Card card;
        System.out.print("\033[H\033[2J");
        System.out.flush();
        for(int i = 0; i < 52; i++) {
            card = cardsDeck.getCard();
            newDeck.add(card);
            System.out.println(card.getSymbol() + " " + card.getSuit());
        }
        for(int i = 0; i < 52; i++) {
            System.out.println(newDeck.get(i).getSymbol() + " " + newDeck.get(i).getSuit());
        }
    }
    
}
