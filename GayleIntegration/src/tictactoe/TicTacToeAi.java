package src.tictactoe;

/*
 * Travis Gayle
 * Integration Project
 * AI class for TicTacToe game when a player does not have another player to play against.
 */

import java.util.List;
import src.IntegrationProject;

public class TicTacToeAi extends TicTacToePlayer {

  public TicTacToeAi(String name, char representingLetter) {
    super(name, representingLetter, true);

  }

  TicTacToeAi() {
    super("AI", 'O', true);
  }

  public TicTacToeCoordinates makeMove(TicTacToeBoard board) {
    List<TicTacToeCoordinates> freeAreas = board.getAvailableSpots();
    int selectedIndex = IntegrationProject.getRandom().nextInt(freeAreas.size());
    return freeAreas.get(selectedIndex);

  }

}
