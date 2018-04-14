package src.tictactoe;

/*
 * Travis Gayle
 * Integration Project
 * Model class for a player in a TicTacToeGame and their state.
 */

public class TicTacToePlayer {

  private String name;
  private int score;
  private char representation;
  private boolean isAi;

  public TicTacToePlayer(String name, char representingLetter) {
    this(name, representingLetter, false);
  }

  public TicTacToePlayer(String name, char representingLetter, boolean isAi) {
    this.name = name;
    this.representation = representingLetter;
    this.isAi = isAi;
  }

  public char getRepresentation() {
    return representation;
  }

  public void setRepresentation(char representation) {
    this.representation = representation;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int incrementScore() {
    return ++score;
  }

  public int decrementScore() {
    if (score > 0) {
      return --score;
    } else {
      return score;
    }
  }

  public boolean isAi() {
    return isAi;
  }


  @Override
  public boolean equals(Object obj) {
    if (obj instanceof TicTacToePlayer) {
      TicTacToePlayer otherPlayer = (TicTacToePlayer) obj;

      return this.name.equals(otherPlayer.name)
          && this.representation == otherPlayer.representation
          && this.isAi == otherPlayer.isAi;
    }

    return false;
  }
}
