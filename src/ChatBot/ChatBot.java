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


        System.out.println("Let me guess your age.");
        System.out.println("Enter remainders of dividing your age by 3, 5 and 7.");

        int remainder3 = scanner.nextInt();
        int remainder5 = scanner.nextInt();
        int remainder7 = scanner.nextInt();

        int age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105;

        System.out.println("Your age is " + age + "; that's a good time to start programming!");


        System.out.println("Now I will prove to you that I can count to any number you want!");

        int userInp = scanner.nextInt();

        for (int i = 0; i <= userInp; i++) {
            System.out.println(i + "!");
        }


        System.out.println("Now, let's test your knowledge of programming!");

        boolean correctAnswer = false;

        while (!correctAnswer) {
            System.out.println("What is the main purpose of the 'main' method in Java?");
            System.out.println("1. To define the starting point of the program.");
            System.out.println("2. To create a new class.");
            System.out.println("3. To execute mathematical calculations.");
            System.out.println("4. To store data in a variable.");

            int answer = scanner.nextInt();

            if (answer == 1) {
                correctAnswer = true;
                System.out.println("Congratulations, you have completed the test!");
            } else {
                System.out.println("Please, try again.");
            }
        }

        System.out.println("Goodbye, have a nice day!");
    }
}
