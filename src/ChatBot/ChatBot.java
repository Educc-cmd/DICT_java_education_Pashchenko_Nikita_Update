import java.util.Scanner;

public class ChatBot {
    public static void main(String[] args) {
        String botName = "Chappa";
        int birthYear = 2024;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello! My name is " + botName + ".");
        System.out.println("I was created in " + birthYear + ".");
        System.out.println("Please, remind me your name.");

        String userName = scanner.nextLine();

        System.out.println("What a great name you have, " + userName + "!");
    }
}
