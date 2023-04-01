import java.util.Scanner;

/**
 * The driver class with main method.
 */
public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameLogic gameLogic = new GameLogic(scanner);
        GameUI gameUI = new GameUI(scanner, gameLogic);

        gameUI.runGame();
    }
}
