package src.main.java.tictactoe;

/*
 * Travis Gayle
 * Integration Project
 * AI class for TicTacToe game when a player does not have another player to play against.
 *
 *This class is a subclass of TicTacToePlayer, ensuring that it can be used anywhere a normal
 * player can be used, while also allowing us to add special functionality as an AI player.
 */

import java.util.List;
import src.main.java.IntegrationProject;

public class TicTacToeAi extends TicTacToePlayer {

  public TicTacToeAi(String name, char representingLetter) {
    super(name, representingLetter, true);

  }

  TicTacToeAi() {
    super("AI", 'O', true);
  }

  @Override
  public boolean isAi() {
    return true;
  }

  /**
   * Randomly chooses a spot on the board to make a move from the available free areas.
   *
   * @param board The board to make a move on.
   * @return a TicTacToeCoordinates that specifies where a move should be made.
   */
  public TicTacToeCoordinates makeMove(TicTacToeBoard board) {
    List<TicTacToeCoordinates> freeAreas = board.getAvailableSpots();
    int selectedIndex = IntegrationProject.getRandom().nextInt(freeAreas.size());
    return freeAreas.get(selectedIndex);

  }

}
