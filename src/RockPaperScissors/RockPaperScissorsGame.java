import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

class RockPaperScissorsGame {
    private static Map<String, Integer> ratings = new HashMap<>();
    private static int userScore = 0;
    private static List<String> options = Arrays.asList("rock", "paper", "scissors");
    private static final Random random = new Random();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть своє ім'я: ");
        String userName = scanner.nextLine();
        System.out.println("Привіт, " + userName);

        loadRatings();
        userScore = ratings.getOrDefault(userName, 0);

        System.out.print("Введіть опції гри (розділені комами) або залиште порожнім для стандартних: ");
        String inputOptions = scanner.nextLine();
        if (!inputOptions.isEmpty()) {
            options = Arrays.asList(inputOptions.split(","));
        }
        System.out.println("Добре, розпочнемо!");

        while (true) {
            System.out.print("Введіть ваш вибір або !exit чи !rating: ");
            String userInput = scanner.nextLine();

            if (userInput.equals("!exit")) {
                System.out.println("До побачення!");
                break;
            } else if (userInput.equals("!rating")) {
                System.out.println("Ваш рахунок: " + userScore);
            } else if (options.contains(userInput)) {
                playGame(userInput);
            } else {
                System.out.println("Невірне введення");
            }
        }
    }

    private static void loadRatings() {
        try (Scanner fileScanner = new Scanner(new File("rating.txt"))) {
            while (fileScanner.hasNext()) {
                String name = fileScanner.next();
                int score = fileScanner.nextInt();
                ratings.put(name, score);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл рейтингів не знайдено. Починаємо з нуля.");
        }
    }

    private static void playGame(String userChoice) {
        String computerChoice = options.get(random.nextInt(options.size()));

        if (userChoice.equals(computerChoice)) {
            System.out.println("Нічия (" + computerChoice + ")");
            userScore += 50;
        } else if (isUserWin(userChoice, computerChoice)) {
            System.out.println("Молодець! Комп'ютер вибрав " + computerChoice + " і програв");
            userScore += 100;
        } else {
            System.out.println("Вибачте, але комп'ютер вибрав " + computerChoice);
        }
    }

    private static boolean isUserWin(String userChoice, String computerChoice) {
        int userIndex = options.indexOf(userChoice);
        int computerIndex = options.indexOf(computerChoice);
        int halfSize = options.size() / 2;

        return (userIndex - computerIndex + options.size()) % options.size() <= halfSize;
    }
}
