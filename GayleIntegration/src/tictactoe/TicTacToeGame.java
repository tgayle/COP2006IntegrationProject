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

  private static Scanner input;
  static String[] yesDecisions = new String[] {"yes", "y"};
  static List<String> yesDecisionArray = Arrays.asList(yesDecisions);

  public static TicTacToePlayer getInfoForPlayer() {
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
    System.out.println("Choose a single character to use for your marker? Leave black for 'X'");

    char playerRepresentation = input.next().charAt(0);

    boolean confirmRepresentation = false;

    while (!confirmRepresentation) {
      input.nextLine();
      System.out.println(String.format("Do you want to use '%s' for your player?", playerRepresentation));
      System.out.println("Yes or No?");
      String confirmed = IntegrationProject
          .waitForCertainInput(new String[] { "yes", "no", "y", "n" }, "Yes or No? ");

      if (Arrays.asList(yesDecisions).contains(confirmed)) {
        confirmRepresentation = true;

      } else {
        System.out.println("What would you like to use to represent your player?");
        playerRepresentation = input.next().charAt(0);
      }
    }

    return new TicTacToePlayer(playerName, playerRepresentation);
  }

  public static void printBoard(char[][] board, TicTacToePlayer player1, TicTacToePlayer player2) {
    System.out.println("---+---+---");
    for (int x = 0; x < 3; x++) {

      for (int y = 0; y < 3; y++) {
        board[x][y] = player1.getRepresentation();
        System.out.print(String.format(" %s ", board[x][y]));

        if (y != 2) {
          System.out.print("|");
        }
      }
      System.out.println();
      System.out.println("---+---+---");
    }
  }

  public static int startGame(Scanner input) {

    TicTacToePlayer player1 = getInfoForPlayer();
    TicTacToePlayer player2;

    System.out.println("Will this be a two player game or would you like to play against an AI?");
    if (yesDecisionArray.contains(input.nextLine())) {
      System.out.println("Enter the information below for player 2: ");
      player2 = getInfoForPlayer();
    } else {
      player2 = new TicTacToeAi();
    }

    /**
     * Game board is modeled as a 3x3 array:
     * [][][]
     * [][][]
     * [][][]
     */
    char[][] gameBoard = new char[3][3];
    printBoard(gameBoard, player1, player2);

    return 0;

  }
}
