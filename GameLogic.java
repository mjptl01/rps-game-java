import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class consist of game logic.
 */
public class GameLogic {

    private enum HandShape {ROCK, PAPER, SCISSORS}
    private boolean flag = true;
    private static int scoreUser = 0;
    private static int scoreComputer = 0;
    private final Scanner scanner;

    public GameLogic(Scanner scanner) {
        this.scanner = scanner;
    }
    public boolean getFlag() {
        return flag;
    }
    public void playGame() {

        System.out.println("\n1. Rock   2. Paper  3. Scissors OR 4. Exit");
        System.out.print("Enter from following Choices: ");
        Pattern numPattern = Pattern.compile("[1-4]");
        String userInputString = scanner.nextLine();
        if (userInputString.isBlank() || !numPattern.matcher(userInputString.trim()).matches()) {
            System.out.println("Invalid Choice!");
            System.out.println("Please enter a number from 1 to 4.");
        } else {
            int userInput = Integer.parseInt(userInputString);
            int computerInput = getRandomHandShape();

            switch (userInput) {
                case 1:
                    if (computerInput == 3) { // rock vs scissor
                        scoreUser++;
                        System.out.println("YOU WIN!    Your Score: " + scoreUser + "  Computer Score: " + scoreComputer);
                    } else if (computerInput == 2) { // rock vs paper
                        scoreComputer++;
                        System.out.println("YOU LOST!    Your Score: " + scoreUser + "  Computer Score: " + scoreComputer);
                    } else {
                        System.out.println("DRAW!    Your Score: " + scoreUser + "  Computer Score: " + scoreComputer);
                    }
                    break;
                case 2:
                    if (computerInput == 3) { // paper vs scissor
                        scoreComputer++;
                        System.out.println("YOU LOST!    Your Score: " + scoreUser + "  Computer Score: " + scoreComputer);
                    } else if (computerInput == 1) { // paper vs rock
                        scoreUser++;
                        System.out.println("YOU WIN!    Your Score: " + scoreUser + "  Computer Score: " + scoreComputer);
                    } else {
                        System.out.println("DRAW!    Your Score: " + scoreUser + "  Computer Score: " + scoreComputer);
                    }
                    break;
                case 3:
                    if (computerInput == 1) { // scissor vs rock
                        scoreComputer++;
                        System.out.println("YOU LOST!    Your Score: " + scoreUser + "  Computer Score: " + scoreComputer);
                    } else if (computerInput == 2) { // scissor vs paper
                        scoreUser++;
                        System.out.println("YOU WIN!    Your Score: " + scoreUser + "  Computer Score: " + scoreComputer);
                    } else {
                        System.out.println("DRAW!    Your Score: " + scoreUser + "  Computer Score: " + scoreComputer);
                    }
                    break;
                case 4:
                    scanner.close();
                    System.out.println("\nExiting the game....");
                    flag = false;
                    break;
            }
        }
    }

    private static int getRandomHandShape() {
        Random random = new Random();
        GameLogic.HandShape[] handShapes = GameLogic.HandShape.values();
        return handShapes[random.nextInt(handShapes.length)].ordinal() + 1;
    }
}
