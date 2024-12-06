import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = {
                {'_', '_', '_'},
                {'_', '_', '_'},
                {'_', '_', '_'}
        };

        printBoard(board);

        char currentPlayer = 'X';

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

            board[row - 1][col - 1] = currentPlayer;
            printBoard(board);

            String result = checkGameState(board);
            if (!result.equals("Гра триває")) {
                System.out.println(result);
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
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

    private static String checkGameState(char[][] board) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] != '_' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0] + " виграє";
            }
            if (board[0][i] != '_' && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                return board[0][i] + " виграє";
            }
        }
        if (board[0][0] != '_' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0] + " виграє";
        }
        if (board[0][2] != '_' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2] + " виграє";
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '_') {
                    return "Гра триває";
                }
            }
        }

        return "Нічия";
    }
}
