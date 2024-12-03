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
            String input = scanner.next();

            if (input.length() != 1) {
                System.out.println("You should input a single letter");
                continue;
            }

            char guess = input.charAt(0);

            // Перевірка на малу англійську літеру
            if (!Character.isLowerCase(guess) || !Character.isAlphabetic(guess)) {
                System.out.println("Please enter a lowercase English letter");
                continue;
            }

            if (usedLetters.contains(guess)) {
                System.out.println("You've already guessed this letter");
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
            System.out.println("You guessed the word " + secretWord + "!");
            System.out.println("You survived!");
        } else {
            System.out.println("You lost!");
        }

        scanner.close();
    }
}
