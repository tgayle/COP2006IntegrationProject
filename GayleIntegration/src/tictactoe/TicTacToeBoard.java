package tictactoe;

import java.util.ArrayList;
import java.util.List;

/*
 * Travis Gayle
 * Integration Project
 * Wrapper for char[][] to represent a game board.
 */
public class TicTacToeBoard {

  private int boardLength;
  private int boardWidth;
  private char[][] board;

  public static final String boardCoordPreview =
      "---+---+---\n"
          + " {0,0}  | {0,1}  | {0,2} \n"
          + "---+---+---\n"
          + " {1,0}  | {1,1}  | {1,2} \n"
          + "---+---+---\n"
          + " {2,0}  | {2,1}  | {2,2} \n"
          + "---+---+---";

  private static final TicTacToeCoordinates[] leftToBottomDiagonals =
      {new TicTacToeCoordinates(0, 0), new TicTacToeCoordinates(1, 1), new TicTacToeCoordinates(2, 2)};

  private static final TicTacToeCoordinates[] leftToTopRightDiagonals =
      {new TicTacToeCoordinates(0, 2), new TicTacToeCoordinates(1, 1), new TicTacToeCoordinates(2, 0)};

  public TicTacToeBoard(int boardLength, int boardWidth) {
    this.boardLength = boardLength;
    this.boardWidth = boardWidth;
    board = new char[boardLength][boardWidth];
  }

  public char[][] getBoard() {
    return board;
  }

  public char[] getTopRow() {
    char[] row = new char[boardLength];
    System.arraycopy(board[0], 0, row, 0, boardLength);
    return row;
  }

  public char[] getMidRow() {
    char[] row = new char[boardLength];
    System.arraycopy(board[1], 0, row, 0, boardLength);
    return row;
  }

  public char[] getVerticalMidRow() {
    return new char[] {board[0][1], board[1][1], board[2][1]};
  }

  public char[] getLowRow(){
    char[] row = new char[boardLength];
    System.arraycopy(board[2], 0, row, 0, boardLength);
    return row;
  }

  public char getFromCoordinates(int x, int y) {
    return board[x][y];
  }

  public char getFromCoordinates(TicTacToeCoordinates coord) {
    return board[coord.getX()][coord.getY()];
  }

  public boolean updatePosition(TicTacToeCoordinates coords, char playerRepresentation) {
    return updatePosition(coords.getX(), coords.getY(), playerRepresentation);
  }

  public boolean updatePosition(int x, int y, char playerRepresentation) {
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

  private boolean checkRowVictory(char[] row) {
    char rowChar = row[0];
    if (rowChar == 0) return false;
    for (char aRow : row) {
      if (rowChar != aRow) {
        return false;
      }
    }
    return true;
  }

  private char checkDiagonalVictory() {
    char leftToBottomChar = getFromCoordinates(leftToBottomDiagonals[0]);
    char leftToTopChar = getFromCoordinates(leftToTopRightDiagonals[0]);

    boolean failedLeftToBottomDiag = false;
    boolean failedLeftToTopDiag = false;

    for (TicTacToeCoordinates coord: leftToBottomDiagonals) {
      if (leftToBottomChar != getFromCoordinates(coord)) {
        failedLeftToBottomDiag = true;
        break;
      }
    }

    for (TicTacToeCoordinates coord: leftToTopRightDiagonals) {
      if (leftToTopChar != getFromCoordinates(coord)) {
        failedLeftToTopDiag = true;
        break;
      }
    }

    if (!failedLeftToBottomDiag) return leftToBottomChar;
    if (!failedLeftToTopDiag) return leftToTopChar;

    return 0;
  }

  public boolean isGameFinished() {
    if (checkDiagonalVictory() != 0) return true;

    boolean topRowStatus = checkRowVictory(getTopRow());
    boolean midRowStatus = checkRowVictory(getMidRow());
    boolean vertMidStatus = checkRowVictory(getVerticalMidRow());
    boolean lowRowStatus = checkRowVictory(getLowRow());
//    System.out.printf("%s %s %s", topRowStatus, midRowStatus, lowRowStatus);
    return topRowStatus || midRowStatus || vertMidStatus || lowRowStatus;
  }

  public static void printBoardCoords() {
    System.out.print(boardCoordPreview);
  }
}
