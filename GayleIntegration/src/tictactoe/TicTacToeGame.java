package tictactoe;

/*
 * Travis Gayle
 * Integration Project
 * Main class for a TicTacToe game and starting and managing a game.
 */

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import main.IntegrationProject;


public class TicTacToeGame {

  static String[] yesDecisions = new String[] {"yes", "y"};
  static List<String> yesDecisionArray = Arrays.asList(yesDecisions);

  public static TicTacToePlayer getInfoForPlayer(Scanner input, String name) {
//    System.out.println("Choose a single character to use for your marker? Leave black for 'X'");
    System.out.printf("%s, choose a single character to use for your marker. Leave blank for 'X'%n",
        name);

    String playerStringInput = input.nextLine().trim();
    char playerRepresentation;
    boolean confirmRepresentation = false;

    if (playerStringInput.length() == 0) {
      playerRepresentation = 'X';
    } else {
      playerRepresentation = playerStringInput.charAt(0);
    }

    while (!confirmRepresentation) {
      System.out.println(String.format("Do you want to use '%s' for your player?", playerRepresentation));
      System.out.println("Yes or No?");
      String confirmed = IntegrationProject
          .waitForCertainInput(new String[] { "yes", "no", "y", "n" }, "Yes or No? ");

      if (Arrays.asList(yesDecisions).contains(confirmed)) {
        confirmRepresentation = true;

      } else {
        System.out.println("What would you like to use to represent your player?");
        playerRepresentation = input.next().trim().charAt(0);
      }
    }

    return new TicTacToePlayer(name, playerRepresentation);
  }

  private static TicTacToeCoordinates askForCoordinatesFromText(Scanner input) {
    String userInput = input.nextLine().trim();

    //TODO: Print coords when user types 'coords'

    while (!userInput.matches("\\(?\\d, ?\\d\\)?")) {
      System.out.println("Incorrect format, please enter coordinates in an acceptable format.");
      System.out.println("Example: '(1, 2)', '1, 2', or '1,2'");
      userInput = input.nextLine().trim();
    }

    userInput = userInput.replaceAll("\\(|\\)|\\ ", "");
    String[] stringSplit = userInput.split(",");
    int x = Integer.parseInt(stringSplit[0]);
    int y = Integer.parseInt(stringSplit[1]);
    return new TicTacToeCoordinates(x, y);
  }

  private static TicTacToeCoordinates pollForSelectedCoordinates(Scanner input) {
    TicTacToeCoordinates coords = askForCoordinatesFromText(input);

    while (coords.getX() > 2 || coords.getX() < 0 || coords.getY() > 2 || coords.getY() < 0) {
      System.out.println("Invalid range. Pick a number between 0 and 2 for coordinates.");
      TicTacToeBoard.printBoardCoords();
      coords = askForCoordinatesFromText(input);
    }

    return coords;
  }

  public static TicTacToePlayer getInfoForPlayer(Scanner input) {
    System.out.println("What is your name?");
    String playerName = input.nextLine();

    boolean confirmedName = false;

    while (!confirmedName) {
      System.out.println("Are you sure this is your name?: " + playerName);
      System.out.println("Yes or No?");
      String confirmed = IntegrationProject
          .waitForCertainInput(new String[] { "yes", "no", "y", "n" },
              "Yes or No? ");

      if (Arrays.asList(yesDecisions).contains(confirmed)) {
        confirmedName = true;
      } else {
        System.out.println("What is your name?");
        playerName = input.nextLine();
      }
    }
    return getInfoForPlayer(input, playerName);
  }

  public static int startGame(Scanner input, String player1Name) {

    TicTacToePlayer player1 = getInfoForPlayer(input, player1Name);
    TicTacToePlayer player2;

    boolean gameFinished = false;
    boolean aiGame = false;
    System.out.println("Will this be a two player game or would you like to play against an AI?");
    if (yesDecisionArray.contains(input.nextLine())) {
      System.out.println("Enter the information below for player 2: ");
      player2 = getInfoForPlayer(input);
    } else {
      player2 = new TicTacToeAi();
      aiGame = true;
    }

    /**
     * Game board is modeled as a 3x3 array:
     * [][][]
     * [][][]
     * [][][]
     */
    TicTacToeBoard gameBoard = new TicTacToeBoard(3, 3);
    gameBoard.printBoard();
    System.out.println("Remember, if you ever want to see the coordinates for each point, just type 'coords'");
    TicTacToePlayer currentPlayer = player1;

    while (!gameFinished) {
      if (!(currentPlayer instanceof TicTacToeAi)) {
        System.out.printf("%s, enter the coordinates for your move. Or enter coords to see coordinates", currentPlayer.getName());
        TicTacToeCoordinates playerCoords = pollForSelectedCoordinates(input);
        boolean successfulMove = gameBoard.updatePosition(playerCoords, currentPlayer.getRepresentation());

        while (!successfulMove) {
          System.out.println("A player has already made a move there. Pick somewhere else.");
          gameBoard.printBoard();
          successfulMove = gameBoard.updatePosition(pollForSelectedCoordinates(input), currentPlayer.getRepresentation());
        }
        //player completed his move.
      } else {
        TicTacToeCoordinates aiMove = ((TicTacToeAi) player2).makeMove(gameBoard);
        gameBoard.updatePosition(aiMove, player2.getRepresentation());
      }
      gameBoard.printBoard();
      gameFinished = gameBoard.isGameFinished();
      currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    StringBuilder winText = new StringBuilder();
    winText.append("#############");

    for (int i = 0; i < 4; i++) {
      if (i % 2 == 0) {
        System.out.println(winText.toString());
        winText.delete(0 ,3);
      } else {
        System.out.println(winText.toString());
        winText.insert(0, "####", 0 ,3);
      }
    }

    TicTacToePlayer winningPlayer = (currentPlayer == player1) ? player2 : player1;
    System.out.printf("Congrats %s! You won!%n", winningPlayer.getName());

    return 0;

  }
}
