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

        char[][] board = new char[3][3];
        for (int i = 0; i < 9; i++) {
            board[i / 3][i % 3] = input.charAt(i);
        }

        printBoard(board);

        while (true) {
            System.out.print("Введіть координати: ");

            String coordinates = scanner.nextLine();
            String[] parts = coordinates.split(" ");

            if (parts.length != 2 || !parts[0].matches("\\d") || !parts[1].matches("\\d")) {
                System.out.println("Ви повинні вводити числа!");
                continue;
            }

            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);

            if (row < 1 || row > 3 || col < 1 || col > 3) {
                System.out.println("Координати повинні бути від 1 до 3!");
                continue;
            }

            if (board[row - 1][col - 1] != '_') {
                System.out.println("Ця клітинка зайнята! Оберіть іншу!");
                continue;
            }

            board[row - 1][col - 1] = 'X';

            printBoard(board);
            break;
        }
    }

    private static void printBoard(char[][] board) {
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }
}
