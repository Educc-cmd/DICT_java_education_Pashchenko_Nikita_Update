import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть комірки: "); // Запит на введення
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

        String gameState = analyzeBoard(board);
        System.out.println(gameState);
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

    private static String analyzeBoard(char[][] board) {
        int xCount = 0, oCount = 0;
        boolean xWins = false, oWins = false;

        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == 'X') xWins = true;
                if (board[i][0] == 'O') oWins = true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == 'X') xWins = true;
                if (board[0][i] == 'O') oWins = true;
            }

            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 'X') xCount++;
                if (board[i][j] == 'O') oCount++;
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == 'X') xWins = true;
            if (board[0][0] == 'O') oWins = true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] == 'X') xWins = true;
            if (board[0][2] == 'O') oWins = true;
        }

        if (Math.abs(xCount - oCount) > 1 || (xWins && oWins)) {
            return "Неможливо";
        } else if (xWins) {
            return "X виграв";
        } else if (oWins) {
            return "O виграв";
        } else if (xCount + oCount < 9) {
            return "Гра не завершена";
        } else {
            return "Нічия";
        }
    }
}
