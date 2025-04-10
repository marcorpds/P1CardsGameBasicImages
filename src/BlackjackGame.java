import java.util.Scanner;

public class BlackjackGame {
    private Scanner input;
    private Deck cardsDeck;
    private Player player1;
    private Player player2;

    public BlackjackGame() {
        input = new Scanner(System.in);
        cardsDeck = new Deck();
        player1 = new Player("Paul");
        player2 = new Player("Marco");
    }

    public void gameStart() {
        clearScreen();
        boolean player1Sticks = false;
        boolean player2Sticks = false;
        player1.addCard(cardsDeck.getCard());
        player2.addCard(cardsDeck.getCard());
        do {
            if (!player1Sticks) {
                clearScreen();
                for (int count = 0; count < player1.getPlayerHand().size(); count++) {	  	    	   	  		    	     	
                    player1.getPlayerHand().get(count).printCard();	  	    	   	  		    	     	
                }
                System.out.println("Current points: " + player1.getScore());
                System.out.print(player1.getName() + ", do you want to draw (d) or stick (s)? ");
                String choice = input.nextLine();
                if (choice.equals("d")) {
                    Card newCard = cardsDeck.getCard();
                    player1.addCard(newCard);
                    newCard.printCard();
                    System.out.println("New points: " + player1.getScore());
                    if (player1.isBusted()) {
                        System.out.println(player1.getName() + ", you went over 21 points!! " + player2.getName() + " wins!!");
                        return;
                    }
                    System.out.println("Press enter to continue...");
                    input.nextLine();
                } 
                else player1Sticks = true;
            }

            if (!player2Sticks) {
                clearScreen();
                for (Card card : player2.getPlayerHand()) {
                    card.printCard();
                }
                System.out.println("Current points: " + player2.getScore());
                System.out.print(player2.getName() + ", do you want to draw (d) or stick (s)? ");
                String choice = input.nextLine();
                if (choice.equals("d")) {
                    Card newCard = cardsDeck.getCard();
                    player2.addCard(newCard);
                    newCard.printCard();
                    System.out.println("New points: " + player2.getScore());
                    if (player2.isBusted()) {
                        System.out.println(player2.getName() + ", you went over 21 points!! " + player1.getName() + " wins!!");
                        return;
                    }
                    System.out.println("Press enter to continue...");
                    input.nextLine();
                } 
                else player2Sticks = true;
            }
        } while (!player1Sticks || !player2Sticks);

        if (player1.getScore() > player2.getScore()) System.out.println(player1.getName() + " wins!!");
        else if (player1.getScore() < player2.getScore()) System.out.println(player2.getName() + " wins!!");
        else System.out.println("It's a draw!");
        System.out.println("Press enter to continue...");
        input.nextLine();
    }

    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
