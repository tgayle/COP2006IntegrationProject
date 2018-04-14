package src.tictactoe;

/*
 * Travis Gayle
 * Integration Project
 * Model class for a player in a TicTacToeGame and their state.
 *
 * This class implements PlayerInterface, ensuring that it has a way to get the score and get the
 * player name.
 */

public class TicTacToePlayer implements PlayerInterface {

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

  @Override
  public String getName() {
    return name;
  }

  @Override
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int incrementScore() {
    return ++score;
  }

  @Override
  public int decrementScore() {
    if (score > 0) {
      return --score;
    } else {
      return score;
    }
  }

  @Override
  public int getScore() {
    return 0;
  }

  public boolean isAi() {
    return isAi;
  }

  /*
  The equals() method is overridden here, allowing us to add custom functionality to a preexisting
  method. Here we add checks to make sure that another player is equal to the current player.
   */
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
