import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> playerHand;

    public Player(String name) {
        this.name = name;
        this.playerHand = new ArrayList<Card>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        int score = 0;
        int acesCount = 0;
        for (Card card : this.playerHand) {
            score += card.getValue();
            if (card.getValue() == 11) acesCount++;
        }
        while (score > 21 && acesCount > 0) {
            score -= 10;
            acesCount--;
        }
        return score;
    }

    public void addCard(Card card) {
        this.playerHand.add(card);
    }

    public ArrayList<Card> getPlayerHand() {
        return this.playerHand;
    }

    public boolean isBusted() {
        if (getScore() > 21) return true;
        else return false;
    }

}
