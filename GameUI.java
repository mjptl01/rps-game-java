import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class consist of game UI
 */
public class GameUI {
    private int choice = 0;
    private final Scanner scanner;
    private final GameLogic gameLogic;
    private final Pattern numPattern = Pattern.compile("[1-2]");

    public GameUI(Scanner scanner, GameLogic gameLogic) {
        this.scanner = scanner;
        this.gameLogic = gameLogic;
    }

    public void runGame() {
        String userMenuChoice = "";
        do {
            System.out.println("\n------ Welcome to Rock, Paper, Scissors Game ------");
            System.out.println("Main Menu:");
            System.out.println("1. Start Game");
            System.out.println("2. Exit Game");
            System.out.print("Enter a choice: ");
            userMenuChoice = scanner.nextLine();
            if (userMenuChoice.isBlank() || !numPattern.matcher(userMenuChoice.trim()).matches()) {
                System.out.println("\nInvalid Choice!");
                System.out.println("Enter a number 1 OR 2.");
            } else {
                choice = Integer.parseInt(userMenuChoice.trim());
            }
        } while (userMenuChoice.isBlank() || !numPattern.matcher(userMenuChoice.trim()).matches());
        do {
            if (choice == 1) {
                gameLogic.playGame();
            } else {
                scanner.close();
                System.out.println("\nExiting the game....");
                break;
            }
        } while (gameLogic.getFlag());
    }
}
