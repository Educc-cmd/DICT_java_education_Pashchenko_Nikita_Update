import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        System.out.println("HANGMAN");
        String[] words = {"python", "java", "javascript", "kotlin"};
        Random random = new Random();
        String secretWord = words[random.nextInt(words.length)];

        char[] guessedWord = new char[secretWord.length()];
        for (int i = 0; i < guessedWord.length; i++) {
            guessedWord[i] = '-';
        }

        HashSet<Character> usedLetters = new HashSet<>();
        int attemptsLeft = 8;

        Scanner scanner = new Scanner(System.in);

        while (attemptsLeft > 0) {
            System.out.println(guessedWord);
            System.out.print("Input a letter: > ");
            char guess = scanner.next().charAt(0);

            if (usedLetters.contains(guess)) {
                System.out.println("You already tried that letter.");
                continue;
            }

            usedLetters.add(guess);

            boolean found = false;
            for (int i = 0; i < secretWord.length(); i++) {
                if (secretWord.charAt(i) == guess) {
                    guessedWord[i] = guess;
                    found = true;
                }
            }

            if (found) {
                if (String.valueOf(guessedWord).equals(secretWord)) {
                    System.out.println(guessedWord);
                    System.out.println("You survived!");
                    break;
                }
            } else {
                System.out.println("That letter doesn't appear in the word.");
                attemptsLeft--;
            }
        }

        if (attemptsLeft == 0) {
            System.out.println("You lost!");
        }

        System.out.println("Thanks for playing!");
        System.out.println("We'll see how well you did in the next stage.");

        scanner.close();
    }
}
