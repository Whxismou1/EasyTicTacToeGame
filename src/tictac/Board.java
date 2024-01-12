package tictac;

public class Board {
    private char[][] boardGame;

    Board() {
        boardGame = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < boardGame.length; i++) {
            for (int j = 0; j < boardGame[0].length; j++) {
                boardGame[i][j] = ' ';
            }
        }

    }

    public String printGameBoard() {
        StringBuilder outPut = new StringBuilder();
        System.out.println("-------------");
        outPut.append("-------------\n");
        for (int i = 0; i < boardGame.length; i++) {
            System.out.print("| ");
            outPut.append("| ");
            for (int j = 0; j < boardGame[0].length; j++) {
                System.out.print(boardGame[i][j] + " | ");
                outPut.append(boardGame[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
            outPut.append("\n-------------\n");
        }
        return outPut.toString();
    }

    protected void setPieceOnBoardGame(int selectedRow, int selectedCol, char playerSign) {

        boardGame[selectedRow][selectedCol] = playerSign;

    }

    protected boolean isValidRowAndCol(int selectedRow, int selectedCol) {
        if (selectedCol >= boardGame[0].length || selectedCol < 0 || selectedRow >= boardGame.length
                || selectedRow < 0) {
            System.out.println("Please enter a valid row and col");
            return false;
        }

        if (boardGame[selectedRow][selectedCol] != ' ') {
            System.out.println("This place is already taken");
            return false;
        }

        return true;
    }

    protected boolean isWinX() {
        return isWinXByRow() || isWinXByCol() || isWinXByDiagonal();
    }

    private boolean isWinXByDiagonal() {
        if (boardGame[0][0] == 'X' && boardGame[1][1] == 'X' && boardGame[2][2] == 'X') {
            return true;
        }

        if (boardGame[0][2] == 'X' && boardGame[1][1] == 'X' && boardGame[2][0] == 'X') {
            return true;
        }

        return false;
    }

    private boolean isWinXByCol() {
        for (int i = 0; i < boardGame[0].length; i++) {
            if (boardGame[0][i] == 'X' && boardGame[1][i] == 'X' && boardGame[2][i] == 'X') {
                return true;
            }
        }
        return false;

    }

    private boolean isWinXByRow() {
        for (int i = 0; i < boardGame.length; i++) {
            if (boardGame[i][0] == 'X' && boardGame[i][1] == 'X' && boardGame[i][2] == 'X') {
                return true;
            }
        }

        return false;
    }

    protected boolean isWinO() {
        return isWinOByRow() || isWinOByCol() || isWinOByDiagonal();
    }

    private boolean isWinOByDiagonal() {
        if (boardGame[0][0] == 'O' && boardGame[1][1] == 'O' && boardGame[2][2] == 'O') {
            return true;
        }

        if (boardGame[0][2] == 'O' && boardGame[1][1] == 'O' && boardGame[2][0] == 'O') {
            return true;
        }

        return false;
    }

    private boolean isWinOByCol() {
        for (int i = 0; i < boardGame[0].length; i++) {
            if (boardGame[0][i] == 'O' && boardGame[1][i] == 'O' && boardGame[2][i] == 'O') {
                return true;
            }
        }
        return false;
    }

    private boolean isWinOByRow() {
        for (int i = 0; i < boardGame.length; i++) {
            if (boardGame[i][0] == 'O' && boardGame[i][1] == 'O' && boardGame[i][2] == 'O') {
                return true;
            }
        }

        return false;
    }

    protected boolean isBoardFull() {
        for (int i = 0; i < boardGame.length; i++) {
            for (int j = 0; j < boardGame[0].length; j++) {
                if (boardGame[i][j] == ' ') {
                    return false;
                }
            }
        }

        return true;

    }

}
