import java.util.Scanner;

interface Game {
    void play(String userChoice);
}

class RockPaperScissors implements Game {
    @Override
    public void play(String userChoice) {
        String computerChoice = getComputerChoice(userChoice);
        System.out.println("Вибачте, але комп'ютер вибрав " + computerChoice);
    }

    private String getComputerChoice(String userChoice) {
        switch (userChoice) {
            case "rock":
                return "paper";
            case "paper":
                return "scissors";
            case "scissors":
                return "rock";
            default:
                return "невірний вибір";
        }
    }
}

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введіть ваш вибір (rock, paper, або scissors): ");
        String userChoice = scanner.nextLine().toLowerCase();

        Game game = new RockPaperScissors();
        game.play(userChoice);
    }
}
