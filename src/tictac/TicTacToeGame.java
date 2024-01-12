package tictac;

import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
    private Board board;
    private Random random;
    private Scanner sc;
    private boolean isPlayer1Turn;
    private char actualPlayer;

    TicTacToeGame() {
        board = new Board();
        random = new Random();
        sc = new Scanner(System.in);
    }

    protected void play() {
        turn();

        do {
            if (isPlayer1Turn) {
                System.out.println("Player 1 turn: X");
                actualPlayer = 'X';
            } else {
                System.out.println("Player 2 turn: O");
                actualPlayer = 'O';
            }
            board.printGameBoard();
            System.out.println("Please enter row");
            int selectedRow = getSelectedRow();
            System.out.println("Please enter col");
            int selectedCol = getSelectedCol();

            if (board.isValidRowAndCol(selectedRow, selectedCol)) {
                if (isPlayer1Turn) {
                    board.setPieceOnBoardGame(selectedRow, selectedCol, actualPlayer);
                    isPlayer1Turn = false;
                } else {
                    board.setPieceOnBoardGame(selectedRow, selectedCol, actualPlayer);
                    isPlayer1Turn = true;
                }
            }

        } while (!board.isWinX() && !board.isWinO() && !board.isBoardFull());

        checkWhoWins();

    }

    private int getSelectedCol() {
        while (!sc.hasNextInt()) {
            sc.next(); // Limpiar el búfer de entrada
            System.out.println("ERROR: The option must be a number.");
        }
        return sc.nextInt();
    }

    private int getSelectedRow() {
        while (!sc.hasNextInt()) {
            sc.next(); // Limpiar el búfer de entrada
            System.out.println("ERROR: The option must be a number.");
        }
        return sc.nextInt();
    }

    private void checkWhoWins() {
        board.printGameBoard();
        if (board.isWinX()) {
            System.out.println("---------------");
            System.out.println("Player 1 wins");
        } else if (board.isWinO()) {
            System.out.println("---------------");
            System.out.println("Player 2 wins");
        } else {
            System.out.println("---------------");
            System.out.println("It's a tie");
        }
    }

    private void turn() {
        if (random.nextInt(2) == 0) {
            isPlayer1Turn = true;
        } else {
            isPlayer1Turn = false;
        }
    }

}
