public class TicTacToe {
    private char[][] board;

    public TicTacToe() {
        board = new char[][]{
                {'X', 'O', 'X'},
                {'O', 'X', 'O'},
                {'X', 'X', 'O'}
        };
    }

    public void printBoard() {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        TicTacToe gameBoard = new TicTacToe();
        gameBoard.printBoard();
    }
}
