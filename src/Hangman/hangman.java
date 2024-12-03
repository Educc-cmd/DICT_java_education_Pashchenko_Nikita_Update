import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];
        System.out.print("Guess the word: > ");
        Scanner scanner = new Scanner(System.in);
        String guessedWord = scanner.nextLine();

        if (guessedWord.equalsIgnoreCase(secretWord)) {
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}
