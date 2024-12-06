import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть комірки: ");
        String input = scanner.nextLine();

        if (input.length() != 9 || !input.matches("[XO_]+")) {
            System.out.println("Некоректний ввід. Використовуйте лише символи 'X', 'O' та '_'.");
            return;
        }

        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(input.charAt(i * 3 + j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
