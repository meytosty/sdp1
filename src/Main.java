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
            switch (userInput) {
                case "rock":
                    if (!game.getComputerStrategy().makeChoice().equals("rock")) {
                        if (game.getComputerStrategy().makeChoice().equals("paper")) {
                            game.setComputerScore(1);
                        } else if (game.getComputerStrategy().makeChoice().equals("scissors")) {
                            game.setUserScore(1);
                        }
                    }
                    break;
                case "paper":
                    if (!game.getComputerStrategy().makeChoice().equals("paper")) {
                        if (game.getComputerStrategy().makeChoice().equals("scissors")) {
                            game.setComputerScore(1);
                        } else if (game.getComputerStrategy().makeChoice().equals("rock")) {
                            game.setUserScore(1);
                        }
                    }
                    break;
                case "scissors":
                    if (!game.getComputerStrategy().makeChoice().equals("scissors")) {
                        if (game.getComputerStrategy().makeChoice().equals("rock")) {
                            game.setComputerScore(1);
                        } else if (game.getComputerStrategy().makeChoice().equals("paper")) {
                            game.setUserScore(1);
                        }
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 'rock', 'paper', or 'scissors'.");
                    continue; // Skip this iteration and prompt the user for input again
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
