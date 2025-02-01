package JAN_27;

import java.util.Random;
import java.util.Scanner;

public class JAN_30 {
    public static void main(String[] args) {
        int score = 0;
        int target = 10;
        int[][] board = new int[10][10];
        int posx = 5;
        int posy = 5;
        scatterFruits(board);
        while (true) {
            if (score == target) {
                System.out.println("You win!");
                break;
            }
            printBoard(board, posx, posy);
            displayControl(score);
            Scanner in = new Scanner(System.in);
            String input = in.next();
            if (input.contains("w")) {
                board[posx][posy]=4;
                posx -= 1;
                if (!checkValid(board, posx, posy)) {
                    System.out.println("You died! Game Over");
                    System.out.println("Your score is "+score);
                    break;
                }
                if (board[posx][posy] == 8) {
                    score += 1;
                    board[posx][posy] = 0;
                }
                if (board[posx][posy] == 4) {
                    System.out.println("You died! Game Over");
                    System.out.println("Your score is "+score);
                    break;
                }

            }
            if (input.contains("a")) {
                board[posx][posy]=4;
                posy -= 1;
                if (!checkValid(board, posx, posy)) {
                    System.out.println("You died! Game Over");
                    break;
                }
                if (board[posx][posy] == 8) {
                    score += 1;
                    board[posx][posy] = 0;
                }
                if (board[posx][posy] == 4) {
                    System.out.println("You died! Game Over");
                    System.out.println("Your score is "+score);
                    break;
                }

            }
            if (input.contains("s")) {
                board[posx][posy]=4;
                posx += 1;
                if (!checkValid(board, posx, posy)) {
                    System.out.println("You died! Game Over");
                    break;
                }
                if (board[posx][posy] == 8) {
                    score += 1;
                    board[posx][posy] = 0;
                }
                if (board[posx][posy] == 4) {
                    System.out.println("You died! Game Over");
                    System.out.println("Your score is "+score);
                    break;
                }

            }
            if (input.contains("d")) {
                board[posx][posy]=4;
                posy += 1;
                if (!checkValid(board, posx, posy)) {
                    System.out.println("You died! Game Over");
                    break;
                }
                if (board[posx][posy] == 8) {
                    score += 1;
                    board[posx][posy] = 0;
                }
                if (board[posx][posy] == 4) {
                    System.out.println("You died! Game Over");
                    System.out.println("Your score is "+score);
                    break;
                }

            }
        }
    }

    public static void scatterFruits(int[][] board) {
        int totalFruits = 25;
        for (int i = 0; i < totalFruits; i++) {
            Random rand = new Random();
            int x = rand.nextInt(board.length);
            int y = rand.nextInt(board[0].length);
            if (board[x][y] ==                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               0) {
                board[x][y] = 8;
            } else {
                i--;
            }
        }
    }

    public static boolean checkValid(int[][] board, int posx, int posy) {
        if (posx < 0 || posx > board.length - 1 || posy < 0 || posy > board[0].length - 1) {
            return false;
        }
        return true;
    }

    public static void printBoard(int[][] board, int posx, int posy) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == posx && j == posy) {
                    System.out.print(4 + " ");
                    continue;
                }
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void displayControl(int score) {
        System.out.println("Where do you want to move");
        System.out.println("w-> up");
        System.out.println("a-> left");
        System.out.println("s-> down");
        System.out.println("d-> right");
        System.out.println("Current Score is " + score);
    }
}
