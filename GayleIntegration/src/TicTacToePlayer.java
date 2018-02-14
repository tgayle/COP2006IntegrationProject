
public class TicTacToePlayer {

  private String name;
  private int score = 0;
  private char representation; //

  public TicTacToePlayer(String name, char representingLetter) {
    this.name = name;
    this.representation = representingLetter;
  }

  public char getRepresentation() {
    return representation;
  }

  public String getName() {
    return name;
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

}
