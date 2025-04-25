import java.util.*;

public class TicTacToe {

    static char[][] board = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean gameEnded = false;

        while (!gameEnded) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter your move (row and column: 1 2): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (row < 0 || col < 0 || row > 2 || col > 2 || board[row][col] != ' ') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            board[row][col] = currentPlayer;

            if (checkWinner()) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameEnded = true;
            } else if (isDraw()) {
                printBoard();
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                // Switch player
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }

        scanner.close();
    }

    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    static boolean checkWinner() {
        // Check rows, columns, and diagonals
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board[i][0] == currentPlayer &&
                    board[i][1] == currentPlayer &&
                    board[i][2] == currentPlayer)
                return true;

            // Check columns
            if (board[0][i] == currentPlayer &&
                    board[1][i] == currentPlayer &&
                    board[2][i] == currentPlayer)
                return true;
        }

        // Check diagonals
        if (board[0][0] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][2] == currentPlayer)
            return true;

        if (board[0][2] == currentPlayer &&
                board[1][1] == currentPlayer &&
                board[2][0] == currentPlayer)
            return true;

        return false;
    }

    static boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ')
                    return false;
            }
        }
        return true;
    }
}
