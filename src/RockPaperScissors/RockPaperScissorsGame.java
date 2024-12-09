import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

interface Game {
    void play(String userChoice);
}

class RockPaperScissors implements Game {
    private Random random = new Random();
    private int score = 0;

    private static final Map<String, String> WINNING_COMBINATIONS = new HashMap<>() {{
        put("rock", "scissors");
        put("paper", "rock");
        put("scissors", "paper");
    }};

    @Override
    public void play(String userChoice) {
        String[] options = {"rock", "paper", "scissors"};
        String computerChoice = options[random.nextInt(options.length)];

        if (userChoice.equals(computerChoice)) {
            System.out.println("Нічия. Обидва вибрали " + computerChoice);
            score += 50;
        } else if (WINNING_COMBINATIONS.get(userChoice).equals(computerChoice)) {
            System.out.println("Молодець! Комп'ютер вибрав " + computerChoice + " і програв");
            score += 100;
        } else {
            System.out.println("Вибачте, але комп'ютер вибрав " + computerChoice);
        }
    }

    public int getScore() {
        return score;
    }
}

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> ratings = readRatings();

        // Введення імені користувача
        System.out.print("Введіть своє ім'я: ");
        String name = scanner.nextLine();
        System.out.println("Привіт, " + name);

        // Ініціалізація рахунку користувача
        int userScore = ratings.getOrDefault(name, 0);

        // Початок гри
        RockPaperScissors game = new RockPaperScissors();
        while (true) {
            System.out.print("Введіть ваш вибір (rock, paper, scissors), !rating або !exit: ");
            String userInput = scanner.nextLine();

            if (userInput.equals("!exit")) {
                System.out.println("Bye!");
                break;
            } else if (userInput.equals("!rating")) {
                System.out.println("Ваш рахунок: " + (userScore + game.getScore()));
            } else if (userInput.equals("rock") || userInput.equals("paper") || userInput.equals("scissors")) {
                game.play(userInput);
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    private static Map<String, Integer> readRatings() {
        Map<String, Integer> ratings = new HashMap<>();
        try (Scanner fileScanner = new Scanner(new File("rating.txt"))) {
            while (fileScanner.hasNext()) {
                String name = fileScanner.next();
                int score = fileScanner.nextInt();
                ratings.put(name, score);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл rating.txt не знайдено, створюємо новий рахунок.");
        }
        return ratings;
    }
}
