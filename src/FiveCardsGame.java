public class FiveCardsGame {
    Deck cardsDeck = new Deck();

    public void gameStart() {
        for (int count = 1; count <= 5; count++) {
            Card card = this.cardsDeck.getCard();

            card.printCard();
        }
    }
}
