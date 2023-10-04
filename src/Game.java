import java.util.Random;
public class Game {
    private static Game instance;
    private int userScore;
    private int computerScore;
    private ChoiceStrategy computerStrategy;
    private Random random;
    private ChoiceStrategy strategies[] = new ChoiceStrategy[3];

    private Game() {
        userScore = 0;
        computerScore = 0;
        strategies[0] = new PaperStrategy();
        strategies[1] = new RockStrategy();
        strategies[2] = new ScissorsStrategy();
    }

    public static Game getInstance() {
        if (instance == null) {
            instance = new Game();
        }
        return instance;
    }

    public void setUserScore(int score) {
        userScore += score;
    }

    public void setComputerScore(int score) {
        computerScore += score;
    }

    public int getUserScore() {
        return userScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void setComputerStrategy() {
        random = new Random();
        computerStrategy = strategies[random.nextInt(0, 3)];
    }
    public ChoiceStrategy getComputerStrategy() {
        return computerStrategy;
    }

    public void playRound() {
        String userChoice = getUserChoice();
        System.out.println(computerStrategy.makeChoice());
        String computerChoice = computerStrategy.makeChoice();

        // Implement game logic to determine the winner
        // Update userScore and computerScore accordingly
    }

    private String getUserChoice() {
        // Implement user input logic (e.g., using Scanner)
        // Return the user's choice (rock, paper, or scissors)
        return "rock"; // Replace with actual user choice
    }
}
