package tictactoe;

/*
 * Travis Gayle
 * Integration Project
 * AI class for TicTacToe game when a player does not have another player to play against.
 */

public class TicTacToeAi extends TicTacToePlayer {

  public TicTacToeAi(String name, char representingLetter) {
    super(name, representingLetter);
  }

  public TicTacToeAi() {
    super("AI", 'O');
  }

  public String makeMove(char[][] gameBoard) {
    //TODO:
    return "";
  }
}
