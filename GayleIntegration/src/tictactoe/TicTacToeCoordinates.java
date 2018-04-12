package tictactoe;

/*
 * Travis Gayle
 * Integration Project
 * Wrapper for int[][] to represent coordinates on TicTacToeBoard
 */
public class TicTacToeCoordinates {

  private int x;
  private int y;

  TicTacToeCoordinates(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

}
