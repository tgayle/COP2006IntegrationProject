package src.main.java.tictactoe;

/*
 * Travis Gayle
 * Integration Project
 * Wrapper for int[][] to represent coordinates on TicTacToeBoard
 */
public class TicTacToeCoordinates {

  private int boardXCoordinate;
  private int boardYCoordinate;

  TicTacToeCoordinates(int x, int y) {
    this.boardXCoordinate = x;
    this.boardYCoordinate = y;
  }

  public int getX() {
    return boardXCoordinate;
  }

  public int getY() {
    return boardYCoordinate;
  }

}
