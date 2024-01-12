package tictac;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class BoardTest {
    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void boardNotNUll() {
        assertNotNull(board);
    }

    @Test
    public void firstOutput() {
        String expected = "-------------\n" + "|   |   |   | \n" + "-------------\n" + "|   |   |   | \n"
                + "-------------\n" + "|   |   |   | \n" + "-------------\n";
        assertEquals(expected, board.printGameBoard());
    }

    @Test
    public void setPieceOnBoardGame() {
        board.setPieceOnBoardGame(0, 0, 'X');
        String expected = "-------------\n" + "| X |   |   | \n" + "-------------\n" + "|   |   |   | \n"
                + "-------------\n" + "|   |   |   | \n" + "-------------\n";
        assertEquals(expected, board.printGameBoard());
    }

    @Test
    public void isWin() {
        board.setPieceOnBoardGame(0, 0, 'X');
        board.setPieceOnBoardGame(0, 1, 'X');
        board.setPieceOnBoardGame(0, 2, 'X');
        assertTrue(board.isWinX());
        assertFalse(board.isWinO());
    }

    @Test
    public void rowsIncorrect() {
        assertFalse(board.isValidRowAndCol(3, 0));
        assertFalse(board.isValidRowAndCol(-1, 0));
    }

    @Test
    public void isATie() {
        board.setPieceOnBoardGame(0, 0, 'X');
        board.setPieceOnBoardGame(0, 1, 'O');
        board.setPieceOnBoardGame(0, 2, 'X');
        board.setPieceOnBoardGame(1, 0, 'X');
        board.setPieceOnBoardGame(1, 1, 'O');
        board.setPieceOnBoardGame(1, 2, 'O');
        board.setPieceOnBoardGame(2, 0, 'O');
        board.setPieceOnBoardGame(2, 1, 'X');
        board.setPieceOnBoardGame(2, 2, 'X');
        assertTrue(board.isBoardFull());
        assertFalse(board.isWinX());
        assertFalse(board.isWinO());
    }

}
