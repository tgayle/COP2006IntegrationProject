package src.main.java.tictactoe;

/**
 * Player Interface for representing a player in a game. At the very least, a player object will
 * have a way to get current score and name <p> This interface acts as a contact, ensuring that any
 * class implementing it will have these methods. </p>
 */
public interface PlayerInterface {
  
  int incrementScore();
  
  int decrementScore();
  
  int getScore();
  
  String getName();
  
  void setName(String newName);
  
}
