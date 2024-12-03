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
        int mistakesLeft = 8;
        boolean won = false;

        Scanner scanner = new Scanner(System.in);

        while (mistakesLeft > 0) {
            System.out.println(guessedWord);
            System.out.print("Input a letter: > ");
            char guess = scanner.next().charAt(0);

            if (usedLetters.contains(guess)) {
                System.out.println("No improvements");
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

            if (!found) {
                System.out.println("That letter doesn't appear in the word");
                mistakesLeft--;
            }

            if (String.valueOf(guessedWord).equals(secretWord)) {
                won = true;
                break;
            }
        }

        if (won) {
            System.out.println(secretWord);
            System.out.println("You guessed the word!");
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}
