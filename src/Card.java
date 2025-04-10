public class Card {
    private String suit;
    private String symbol;
    private int value;
    private int weight;
    private String[][] image;

    public Card(String suit, String symbol, int value, int weight, String[][] image) {
        this.suit = suit;
        this.symbol = symbol;
        this.value = value;
        this.weight = weight;
        this.image = image;
    }

    public String getSuit() {
        return this.suit;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public int getValue() {
        return this.value;
    }

    public int getWeight() {
        return this.weight;
    }

    public void printCard() {
        for (int i = 0; i < 7; i++) {  
            for (int j = 0; j < 9; j++) {
                System.out.print(this.image[i][j]);
            }
            System.out.println();
        }
        System.out.println(this.symbol + " " + this.suit);
    }
}
