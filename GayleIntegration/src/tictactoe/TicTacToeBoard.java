package src.tictactoe;

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
          + "---+---+---\n"
          + " {1,0}  | {1,1}  | {1,2} \n"
          + "---+---+---\n"
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

  public TicTacToeBoard(int boardLength, int boardWidth) {
    this.boardLength = boardLength;
    this.boardWidth = boardWidth;
    board = new char[boardLength][boardWidth];
  }

  public static void printBoardCoords() {
    System.out.println(boardCoordPreview);
  }

  public char[][] getBoard() {
    return board;
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
    char rowChar = row[0];
    if (rowChar == 0) {
      return 0;
    }
    for (char aRow : row) {
      if (rowChar != aRow) {
        return 0;
      }
    }
    return rowChar;
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

    return topRowStatus || midRowStatus || vertMidStatus || lowRowStatus;
  }

  public boolean isGameFinished() {
    return checkDiagonalVictory() != 0 || checkBoardVictory() || isBoardFilled();
  }

  public char findWinner() {
    char[] winners = {
        checkRowVictory(getTopRow()),
        checkRowVictory(getMidRow()),
        checkRowVictory(getLowRow()),
        checkRowVictory(getVerticalMidRow()),
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
