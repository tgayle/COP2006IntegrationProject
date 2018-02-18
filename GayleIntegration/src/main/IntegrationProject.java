package main;

import java.util.*;
import tictactoe.TicTacToeGame;

/*
 * Travis Gayle
 * Integration Project
 * Main file to run.
 * Demonstration of concepts learned in COP2006
 */

public class IntegrationProject {
  private static Scanner input = new Scanner(System.in);
  private static Random random = new Random();

  public static void main(String[] args) {
    random.setSeed(System.currentTimeMillis());

    System.out.println("Hello from the integration project!");

    System.out.print("Loading");
    //Make a call to the slowPrint method and to print the message bellow over 1600 milliseconds.
    slowPrint("...........", 1600);
    // Slowly print this given string over 1.6 seconds.

    System.out.println("Please enter your name for login: ");
    String inputName = input.nextLine();

    System.out.println("Please enter a number of no particular relevance: ");
    int inputNum = 0;

    while (!input.hasNextInt()) {
      try {
        inputNum = input.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Please enter a number: ");
        input.next();
      }
    }

    input.nextLine(); // Move to next line to take inputs normally in the future.

    System.out.println("System debugging necessary. Press enter to continue.");
    input.nextLine();

    // Print the user in an array format.
    System.out.print("USER: ");
    //Call the printStringAsArray method with the name the user gave in all uppercase over 600ms
    printStringAsArray(inputName.toUpperCase().trim(), 600L);

    System.out.println("Magic Random main.Number Generator: " + generateRandomNumber(6)
        + " out of 6.");
    System.out.println("main.Number of no particular relevance over 2.24 equals "
        + inputNum / 2.24d);

    System.out.println("Beginning core JRE check:");
    waitTime(500L);
    System.out.println("Primitive types check:");
    System.out.println();

    /* Print out primitive data types and their ranges.
     * byte has range from -128 to 127
     * short has range from -32768 to 32767
     * int has range from -2147483648 to 2147483647
     * long has range from -9223372036854775808 to 9223372036854775807
     * float has range from 1.4e-45 to 3.4028235e+38
     * double has range from 4.94065645841e-324 to 1.79769313486e+308
     * boolean has range from False to True
     * char has range from \u0000 to \uffff
     */
    for (PrimitiveTypeModel type : PrimitiveTypeModel.getPrimitiveTypes()) {
      System.out.print(type.getType() + ": exists");
      slowPrint("..........", 300);
      System.out.println(type.getType()
          + String.format(" range was [%s, %s]%n", type.getMinValue(), type.getMaxValue()));
    }

    System.out.println("Primitive check complete.");
    // End primitive datatype check.

    System.out.println();
    System.out.println("Casting objects exercise: ");

    Number normalNumber = new Number(54949489498L);
    ImaginaryNumber imagNumber = new ImaginaryNumber(normalNumber, 5489);

    System.out.print("Normal main.Number class: ");
    printNumber(normalNumber);

    System.out.print("Imaginary main.Number class: ");
    printNumber(imagNumber);


    waitTime(1200L);
    System.out.println("Would you like to play a game?");
    System.out.println("Yes or No?: ");

    String playGameDecision = waitForCertainInput(new String[] { "y", "n", "yes", "no" },
        "Please enter the proper input: ");
    String[] yesDecisions = new String[] { "y", "yes" };

    if (Arrays.asList(yesDecisions).contains(playGameDecision)) {
      System.out.println("Continuing to game...");
    } else {
      System.out.println("Continuing to game anyways...");
    }

    TicTacToeGame.startGame(input);
    input.close();

  }

  /**
   *
   * @param message The string to print over the given period of time.
   * @param time A period of time in milliseconds to spend printing the entire string.
   */
  public static void slowPrint(String message, long time) {
    for (int i = 0; i < message.length(); i++) {
      System.out.print(message.charAt(i));
      waitTime(time / message.length());
    }
    System.out.println();

  }

  /**
   * @param time a period of time in milliseconds to wait.
   * Waits a given period of time in milliseconds.
   */
  public static void waitTime(long time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   *
   * @param str String to convert to an array format. Example: "Hello" -> "[H, e, l, l, o]"
   * @return The string in an array form.
   */
  public static String convertStringToArray(String str) {
    StringBuilder userMessage = new StringBuilder("[");

    for (int x = 0; x < str.length(); x++) { // Loop over each character and print it.
      char currentLetter = str.charAt(x);

      if (x != str.length() - 1) {
        userMessage.append(currentLetter + ", ");
      } else {
        userMessage.append(currentLetter + "]");
      }
    }

    return userMessage.toString();
  }

  /**
   *
   * @param str The string to print over a period of time.
   * @param time The amount of time, in milliseconds to take printing the string.
   * @return void
   */
  public static void printStringAsArray(String str, long time) {
    slowPrint(convertStringToArray(str), time);
  }

  /**
   *
   * @param checkFor
   *          an array of strings objects to check for against the scanner input.
   * @param responseOnIncorrectInput
   *          What to print if the input is not correct.
   * @return The string that was input and also in the checkFor array.
   */
  public static String waitForCertainInput(String[] checkFor, String responseOnIncorrectInput) {
    String scanInput = input.nextLine().toLowerCase().trim();
    List<String> possibleExits = Arrays.asList(checkFor);

    while (!possibleExits.contains(scanInput)) {

      if (responseOnIncorrectInput.length() != 0) {
        System.out.println(responseOnIncorrectInput);
      }

      scanInput = input.nextLine().toLowerCase().trim();
    }
    return scanInput;
  }

  /**
   *
   * @param numberOfSides The max number to randomly generate.
   * @return A random number from the range of 0 to numberOfSides
   */
  public static int generateRandomNumber(int numberOfSides) {
    return random.nextInt(numberOfSides) + 1;
  }

  /**
   *
   * @param num : An instance of the main.Number class to print.
   * @return The toString() representation of a main.Number object.
   */
  public static String printNumber(Number num) { // Cast number back to Imaginary to print it
    // properly?

    if (num instanceof ImaginaryNumber) {
      System.out.println(((ImaginaryNumber) num).toString());
      return ((ImaginaryNumber) num).toString();

    } else {
      System.out.println(num.toString());
      return num.toString();
    }
  }

  public static Scanner getScanner() {
    return input;
  }

  public static Random getRandom() {
    return random;
  }

}
