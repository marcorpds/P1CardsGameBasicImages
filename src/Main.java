import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int game;

        System.out.println("Programming 1 Project");
        System.out.println();
        System.out.println("(1) Five Cards       (1 Player Game)");
        System.out.println("(2) Higher or Lower  (1 Player Game)");
        System.out.println("(3) Blackjack        (1 Player Game)");
        System.out.println();
        System.out.print("Choose a game to play: ");
        game = input.nextInt();
        gameHandler(game);

        /*
        Experimental experiment = new Experimental();
        experiment.start();
        */
    }

    public static void gameHandler(int game) {
        if (game == 1) {
            FiveCardsGame newGame = new FiveCardsGame();
            newGame.gameStart();
        }
        else if (game == 2) {
            HigherLowerGame newGame = new HigherLowerGame();
            newGame.startGame();
        }
        else {
            BlackjackGame newGame = new BlackjackGame();
            newGame.gameStart();
        }
    }
}
