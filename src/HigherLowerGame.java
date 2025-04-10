import java.util.Scanner;

public class HigherLowerGame {
    private Scanner input;
    private Deck cardsDeck;
    private boolean continueGame;

    public HigherLowerGame() {
        this.input = new Scanner(System.in);
        this.cardsDeck = new Deck();
        this.continueGame = true;
    }

    public void startGame() {
        clearScreen();
        int currentCardWeight = 0;
        int nextCardWeight = 0;
        Card card = cardsDeck.getCard();
        currentCardWeight = card.getWeight();
        for (int score = 0; continueGame; score++) {
            card.printCard();
            card = cardsDeck.getCard();
            nextCardWeight = card.getWeight();
            System.out.print("Is the next card higher (+) or lower (-)? ");
            String userInput = input.nextLine();
            if (userInput.equals("+") && nextCardWeight <= currentCardWeight) {
                continueGame = false;
            } else if (userInput.equals("-") && nextCardWeight >= currentCardWeight) {
                continueGame = false;
            }
            card.printCard();
            currentCardWeight = nextCardWeight;
            if (!continueGame) {
                System.out.println("You chose wrong!");
                System.out.println("Your final score is " + score);
            }
            System.out.println("Press enter to continue...");
            input.nextLine();
            clearScreen();
        }
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
