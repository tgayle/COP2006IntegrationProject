import java.util.Scanner;

public class TicTacToeGame {

  private static Scanner input;

  public static void main(String[] args) {
    input = IntegrationProject.getScanner();

    System.out.println("What is your name?");
    String playerName = input.nextLine();

    boolean confirmedName = false;

    while (!confirmedName) {
      System.out.println("Are you sure this is your name?: " + playerName);
      System.out.println("Yes or No?");
      String confirmed = IntegrationProject
          .waitForCertainInput(new String[] { "yes", "no", "y", "n" }, "Yes or No? ");
      
      //TODO: Finish adding TicTacToeGame

    }

  }

}
