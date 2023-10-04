import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an instance of the Game (Singleton)
        Game game = Game.getInstance();

        // Display instructions to the user
        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.println("Enter your choice (rock, paper, or scissors), or 'exit' to quit.");

        while (true) {
            // Get user input
            System.out.print("Your choice: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("exit")) {
                break; // Exit the game loop if the user wants to quit
            }

            // Set the computer's strategy based on user input
            game.setComputerStrategy();

            String computerChoice = game.getComputerStrategy().makeChoice();
            if (!computerChoice.equals(userInput)) {
                if ((computerChoice.equals("paper") && userInput.equals("rock")) ||
                        (computerChoice.equals("scissors") && userInput.equals("paper")) ||
                        (computerChoice.equals("rock") && userInput.equals("scissors"))) {
                    game.setComputerScore(1);
                } else {
                    game.setUserScore(1);
                }
            }

            // Play a round of the game
            game.playRound();

            // Display the results
            int userScore = game.getUserScore();
            int computerScore = game.getComputerScore();
            System.out.println("User: " + userScore + " | Computer: " + computerScore);
        }

        // Game over, display final scores
        System.out.println("Final Scores:");
        int userScore = game.getUserScore();
        int computerScore = game.getComputerScore();
        System.out.println("User: " + userScore + " | Computer: " + computerScore);

        // Close the scanner
        scanner.close();
    }
}
