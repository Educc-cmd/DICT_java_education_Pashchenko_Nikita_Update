import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class hangman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("HANGMAN");

        while (true) {
            System.out.print("Type \"play\" to play the game, \"exit\" to quit: > ");
            String command = scanner.next();

            if (command.equals("play")) {
                playGame(scanner);
            } else if (command.equals("exit")) {
                break;
            }
        }
        scanner.close();
    }

    private static void playGame(Scanner scanner) {
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

        while (mistakesLeft > 0) {
            System.out.println(guessedWord);
            System.out.print("Input a letter: > ");
            String input = scanner.next();

            if (input.length() != 1) {
                System.out.println("You should input a single letter");
                continue;
            }

            char guess = input.charAt(0);

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
    }
}
