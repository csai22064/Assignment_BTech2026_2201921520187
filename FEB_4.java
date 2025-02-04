package JAN_27;

import java.util.Scanner;

class TicTacToe {
    private final char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';  // Human starts first
        initializeBoard();
    }

    // Initialize board with empty spaces
    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Print board
    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    // Player move (Human)
    public boolean makeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            return true;
        }
        return false;
    }

    // AI Move using Minimax
    public void makeAIMove() {
        int bestScore = Integer.MIN_VALUE;
        int bestRow = -1, bestCol = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    board[i][j] = 'O';  // AI tries a move
                    int moveScore = minimax(false);
                    board[i][j] = ' ';  // Undo move

                    if (moveScore > bestScore) {
                        bestScore = moveScore;
                        bestRow = i;
                        bestCol = j;
                    }
                }
            }
        }

        board[bestRow][bestCol] = 'O'; // AI makes the best move
        System.out.println("AI (O) played at: " + bestRow + ", " + bestCol);
    }

    // Minimax algorithm
    private int minimax(boolean isMaximizing) {
        int score = evaluateBoard();
        if (score != 0 || isBoardFull()) return score;

        if (isMaximizing) { // AI's turn (Maximize score)
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'O';
                        bestScore = Math.max(bestScore, minimax(false));
                        board[i][j] = ' '; // Undo move
                    }
                }
            }
            return bestScore;
        } else { // Human's turn (Minimize AI's score)
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == ' ') {
                        board[i][j] = 'X';
                        bestScore = Math.min(bestScore, minimax(true));
                        board[i][j] = ' '; // Undo move
                    }
                }
            }
            return bestScore;
        }
    }

    // Evaluate board (returns +10, -10, or 0)
    private int evaluateBoard() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                if (board[i][0] == 'O') return +10;
                if (board[i][0] == 'X') return -10;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
                if (board[0][i] == 'O') return +10;
                if (board[0][i] == 'X') return -10;
            }
        }

        if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            if (board[0][0] == 'O') return +10;
            if (board[0][0] == 'X') return -10;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            if (board[0][2] == 'O') return +10;
            if (board[0][2] == 'X') return -10;
        }

        return 0;
    }

    // Check if board is full (Draw condition)
    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') return false;
            }
        }
        return true;
    }

    // Check if there's a winner
    public boolean checkWinner() {
        return evaluateBoard() == 10 || evaluateBoard() == -10;
    }

    // Switch player (Only for human moves, AI moves automatically)
    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public char getCurrentPlayer() {
        return currentPlayer;
    }
}

// Main class
public class FEB_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe game = new TicTacToe();

        System.out.println("Welcome to Tic-Tac-Toe (You: X, AI: O)");
        game.printBoard();

        while (!game.checkWinner() && !game.isBoardFull()) {
            if (game.getCurrentPlayer() == 'X') { // Human Move
                System.out.println("Your turn! Enter row (0-2) and column (0-2): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (game.makeMove(row, col)) {
                    game.printBoard();
                    if (game.checkWinner()) {
                        System.out.println("You win! 🎉");
                        break;
                    }
                    game.switchPlayer();
                } else {
                    System.out.println("Invalid move! Try again.");
                }
            } else { // AI Move
                game.makeAIMove();
                game.printBoard();
                if (game.checkWinner()) {
                    System.out.println("AI wins! 🤖");
                    break;
                }
                game.switchPlayer();
            }
        }

        if (!game.checkWinner()) {
            System.out.println("It's a draw!");
        }

        scanner.close();
    }
}
