package src.main.java.tictactoe;

import java.util.ArrayList;
import java.util.List;

/*
 * Travis Gayle
 * Integration Project
 * Wrapper for a char[][] to represent a game board.
 */
public class TicTacToeBoard {

  private static final String boardCoordPreview =
      "\n"
          + " {0,0}  | {0,1}  | {0,2} \n"
          + "--------+--------+-------\n"
          + " {1,0}  | {1,1}  | {1,2} \n"
          + "--------+--------+-------\n"
          + " {2,0}  | {2,1}  | {2,2} \n";
  private static final TicTacToeCoordinates[] leftToBottomDiagonals =
      {new TicTacToeCoordinates(0, 0), new TicTacToeCoordinates(1, 1),
          new TicTacToeCoordinates(2, 2)};

  private static final TicTacToeCoordinates[] leftToTopRightDiagonals =
      {new TicTacToeCoordinates(0, 2), new TicTacToeCoordinates(1, 1),
          new TicTacToeCoordinates(2, 0)};
  private int boardLength;
  private int boardWidth;
  private char[][] board;

  TicTacToeBoard(int boardLength, int boardWidth) {
    this.boardLength = boardLength;
    this.boardWidth = boardWidth;
    board = new char[boardLength][boardWidth];
  }

  public static void printBoardCoords() {
    System.out.println(boardCoordPreview);
  }

  public char[][] getBoard() {
    return board.clone();
  }

  private char[] getTopRow() {
    char[] row = new char[boardLength];
    System.arraycopy(board[0], 0, row, 0, boardLength);
    return row;
  }

  private char[] getMidRow() {
    char[] row = new char[boardLength];
    System.arraycopy(board[1], 0, row, 0, boardLength);
    return row;
  }

  private char[] getVerticalLeftRow() {
    char[] row = new char[boardWidth];
    for (int i = 0; i < row.length; i++) {
      row[i] = board[i][0];
    }
    return row;
  }

  private char[] getVerticalRightRow() {
    char[] row = new char[boardWidth];
    for (int i = 0; i < row.length; i++) {
      row[i] = board[i][boardLength - 1];
    }
    return row;
  }

  private char[] getVerticalMidRow() {
    return new char[]{board[0][1], board[1][1], board[2][1]};
  }

  private char[] getLowRow() {
    char[] row = new char[boardLength];
    System.arraycopy(board[2], 0, row, 0, boardLength);
    return row;
  }

  private char getFromCoordinates(int x, int y) {
    return board[x][y];
  }

  private char getFromCoordinates(TicTacToeCoordinates coord) {
    return board[coord.getX()][coord.getY()];
  }

  public boolean updatePosition(TicTacToeCoordinates coords, char playerRepresentation) {
    return updatePosition(coords.getX(), coords.getY(), playerRepresentation);
  }

  private boolean updatePosition(int x, int y, char playerRepresentation) {
    if (getFromCoordinates(x, y) != '\u0000') {
      return false;
    }
    board[x][y] = playerRepresentation;
    return true;
  }

  /**
   * Gets a list of available spots in the board where a player has not made a move yet.
   *
   * @return Returns a list of TicTacToeCoordinates where a move has not been yet.
   */
  public List<TicTacToeCoordinates> getAvailableSpots() {
    List<TicTacToeCoordinates> openSpots = new ArrayList<>();
    for (int x = 0; x < boardLength; x++) {
      for (int y = 0; y < boardWidth; y++) {
        if (board[x][y] == '\u0000') {
          openSpots.add(new TicTacToeCoordinates(x, y));
        }
      }
    }
    return openSpots;
  }

  /**
   * Prints out the current state of the board with the places where players have made moves.
   */
  public void printBoard() {
    System.out.println("---+---+---");
    for (int x = 0; x < boardLength; x++) {
      for (int y = 0; y < boardWidth; y++) {
        char currentPlace = getFromCoordinates(x, y);

        if (currentPlace == 0) {
          System.out.print(String.format(" %s  ", currentPlace));
        } else {
          System.out.print(String.format(" %s ", currentPlace));
        }

        if (y != 2) {
          System.out.print("|");
        }
      }
      System.out.println();
      System.out.println("---+---+---");
    }
  }

  private char checkRowVictory(char[] row) {
    char winningChar = row[0];
    if (winningChar == 0) {
      return 0;
    }
    for (char coordinate : row) {
      if (winningChar != coordinate) {
        return 0;
      }
    }
    return winningChar;
  }

  private char isRowEmpty(char[] row) {
    for (char c : row) {
      if (c == 0) {
        return 0;
      }
    }
    return row[0];
  }

  private boolean isBoardFilled() { //Return true if there are no open spots on the board.
    for (char[] y : board) {
      for (char xy : y) {
        if (xy == 0) {
          return false;
        }
      }
    }
    return true;
  }

  private char checkDiagonalVictory() {
    char leftToBottomChar = getFromCoordinates(leftToBottomDiagonals[0]);
    char leftToTopChar = getFromCoordinates(leftToTopRightDiagonals[0]);

    boolean failedLeftToBottomDiag = false;
    boolean failedLeftToTopDiag = false;

    for (TicTacToeCoordinates coord : leftToBottomDiagonals) {
      if (leftToBottomChar != getFromCoordinates(coord)) {
        failedLeftToBottomDiag = true;
        break;
      }
    }

    for (TicTacToeCoordinates coord : leftToTopRightDiagonals) {
      if (leftToTopChar != getFromCoordinates(coord)) {
        failedLeftToTopDiag = true;
        break;
      }
    }

    if (!failedLeftToBottomDiag) {
      return leftToBottomChar;
    }
    if (!failedLeftToTopDiag) {
      return leftToTopChar;
    }

    return 0;
  }

  private boolean checkBoardVictory() { //Check if any of the rows are winners.
    boolean topRowStatus = checkRowVictory(getTopRow()) != 0;
    boolean midRowStatus = checkRowVictory(getMidRow()) != 0;
    boolean vertMidStatus = checkRowVictory(getVerticalMidRow()) != 0;
    boolean lowRowStatus = checkRowVictory(getLowRow()) != 0;
    boolean leftMidStatus = checkRowVictory(getVerticalLeftRow()) != 0;
    boolean rightMidStatus = checkRowVictory(getVerticalRightRow()) != 0;

    return topRowStatus || midRowStatus || vertMidStatus || lowRowStatus || leftMidStatus
        || rightMidStatus;
  }

  public boolean isGameFinished() {
    return checkDiagonalVictory() != 0 || checkBoardVictory() || isBoardFilled();
  }

  /**
   * Searches the board for a winner in any place.
   *
   * @return A char that is the representation of the player who won. <p>Returns u\0000 if there is
   * no winner.</p>
   */
  public char findWinner() {
    char[] winners = {
        checkRowVictory(getTopRow()),
        checkRowVictory(getMidRow()),
        checkRowVictory(getLowRow()),
        checkRowVictory(getVerticalMidRow()),
        checkRowVictory(getVerticalLeftRow()),
        checkRowVictory(getVerticalRightRow()),
        checkDiagonalVictory()
    };

    for (char winner : winners) {
      if (winner != 0) {
        return winner;
      }
    }

    return 0;
  }
}
