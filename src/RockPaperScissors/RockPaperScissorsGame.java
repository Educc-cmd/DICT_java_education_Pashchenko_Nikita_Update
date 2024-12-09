import java.util.Scanner;
import java.util.Random;

interface Game {
    void play(String userChoice);
}

class RockPaperScissors implements Game {
    private Random random = new Random();

    @Override
    public void play(String userChoice) {
        String[] options = {"rock", "paper", "scissors"};
        String computerChoice = options[random.nextInt(options.length)];

        // Виведення результату гри
        if (userChoice.equals(computerChoice)) {
            System.out.println("Нічия. Обидва вибрали " + computerChoice);
        } else if (isUserWinner(userChoice, computerChoice)) {
            System.out.println("Молодець! Комп'ютер вибрав " + computerChoice + " і програв");
        } else {
            System.out.println("Вибачте, але комп'ютер вибрав " + computerChoice);
        }
    }

    private boolean isUserWinner(String userChoice, String computerChoice) {
        return (userChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (userChoice.equals("paper") && computerChoice.equals("rock")) ||
                (userChoice.equals("scissors") && computerChoice.equals("paper"));
    }
}

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new RockPaperScissors();

        while (true) {
            System.out.print("Введіть ваш вибір (rock, paper, або scissors) або !exit для виходу: ");
            String userChoice = scanner.nextLine().toLowerCase();

            if (userChoice.equals("!exit")) {
                System.out.println("Bye!");
                break;  // Завершення програми
            }

            // Перевірка на правильність введеного варіанту
            if (userChoice.equals("rock") || userChoice.equals("paper") || userChoice.equals("scissors")) {
                game.play(userChoice);  // Виконання гри
            } else {
                System.out.println("Invalid input");  // Неправильний ввід
            }
        }
    }
}
