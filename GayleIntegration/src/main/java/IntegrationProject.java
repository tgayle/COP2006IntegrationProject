package src.main.java;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import src.main.java.net.WebApiIntegration;
import src.main.java.number.ImaginaryNumber;
import src.main.java.number.Number;
import src.main.java.tictactoe.TicTacToeGame;

/*
 * Travis Gayle
 * Integration Project
 * Main entry file to Integration Project
 * Demonstration of concepts learned in COP2006
 */

public class IntegrationProject {

  private static Scanner input = new Scanner(System.in, "UTF-8");
  private static Random random = new Random();

  /**
   * Main entry to integration project and run's the entire project. <br> Includes demonstration of
   * skills and things learned in COP 2006
   *
   * @param args Arguments passed in at runtime. These are unused and ignored.
   */
  public static void main(String[] args) {
    random.setSeed(System.currentTimeMillis());

    System.out.println("Hello from the integration project!");

    System.out.print("Loading");
    //Make a call to the slowPrint method and to print the message bellow over 1600 milliseconds.
    slowPrint("...........", 1600);
    // Slowly print this given string over 1.6 seconds.

    System.out.println("Please enter your name for login: ");
    String inputName = null;
    {
      boolean givenProperName = false;
      while (!givenProperName) { //Repeat until the user enters a number.
        try {
          inputName = input.nextLine().trim();
          if (inputName.length() == 0) {
            throw new InputMismatchException();
          }
          givenProperName = true;
        } catch (InputMismatchException e) {
          System.out.println("Please enter your name: ");
        }
      }
    }

    System.out.println("Please enter a number of no particular relevance: ");
    int inputNum = 0;
    while (!input.hasNextInt()) { //Repeat until the user enters a number.
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
    printStringAsArray(inputName.toUpperCase(), 600L);

    String reversedName = new StringBuilder(inputName.toUpperCase()).reverse().toString();
    printStringAsArray(reversedName, 600L);

    LocalDateTime currentTime = LocalDateTime.now(ZoneId.systemDefault());
    String currentTimeAsString = currentTime
        .format(DateTimeFormatter.ofPattern("MMMM dd yyyy hh:mm:ssa").withZone(
            ZoneId.systemDefault()));
    System.out.println("Current Time: " + currentTimeAsString);
    waitTime(1500);

    System.out.println("Magic Random Number Generator: " + generateRandomNumber(6)
        + " out of 6.");
    System.out.println("Number of no particular relevance over 2.24 equals "
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

    System.out.print("Normal Number class: ");
    printNumber(normalNumber);

    ImaginaryNumber imagNumber = new ImaginaryNumber(normalNumber, 5489);
    System.out.print("Imaginary Number class: ");
    printNumber(imagNumber);

    waitTime(1200L);
    System.out.println("Would you like to play a game?");
    System.out.println("Yes or No?: ");

    String playGameDecision = waitForCertainInput(Constants.CONFIRM_DECLINE_OPTIONS_LIST,
        "Please enter the proper input: ");

    int finishedGameState;
    if (Constants.YES_DECISIONS_LIST.contains(playGameDecision)) {
      System.out.println("Continuing to game...");
      waitTime(800);
      finishedGameState = TicTacToeGame.startGame(input, inputName);
    } else {
      finishedGameState = -999;
    }

    if (finishedGameState == -999) {
      System.out.println("User skipped Tic-Tac-Toe...");
    } else {
      System.out.printf("Finished game with result %d.%n", finishedGameState);
    }
    int randomArrayTestNumber = generateRandomNumber(100);
    int[] minimumNumberArray = {inputNum, finishedGameState, randomArrayTestNumber};

    System.out.print("Processing array " + Arrays.toString(minimumNumberArray) + " ");
    slowPrint("........", 400);
    System.out.println("Out of array with values " + Arrays.toString(minimumNumberArray));
    System.out.println("The minimum was " + findMinimumInArray(minimumNumberArray));
    System.out.println("The maximum was " + findMaximumInArray(minimumNumberArray));
    System.out.println("The sum of the array was " + sumArray(minimumNumberArray));
    System.out.println("Index of the largest number is " + getIndexOf(minimumNumberArray,
        findMaximumInArray(minimumNumberArray)));

    System.out.println();
    waitTime(300);

    System.out.println("Comparing primitive types and max values.");
    List<PrimitiveTypeModel> typesThatHandleGivenNum = PrimitiveTypeModel.getPrimitiveTypes()
        .stream()
        .filter(PrimitiveTypeModel.canHandleNumber(500))
        .collect(Collectors.toList());

    typesThatHandleGivenNum.forEach(type -> {
      System.out.printf("Type %s could fit %d%n", type.getType(), 500);
      waitTime(500);
    });

    System.out.println();
    System.out.println("Proceeding to get Nintendo Amiibo Information Online");
    System.out.println("Press enter to continue");
    input.nextLine();

    WebApiIntegration
        .runAmiiboApi(
            (result, errMsg) -> {
              System.out.println("Amiibo API Request ended with result " + result);
              if (errMsg != null) {
                System.out.println(errMsg);
              }
            });

    input.close();
    waitTime(1000);
    System.out.println("\n");
    System.out.println("This marks the end of the Integration Project");
    System.out.println("Thanks for checking this out!");
    System.exit(0);
  }

  /**
   * Slowly prints a string over a period of time.
   *
   * @param message The string to print over the given period of time.
   * @param time A period of time in milliseconds to spend printing the entire string.
   */
  private static void slowPrint(String message, long time) {
    for (int i = 0; i < message.length(); i++) {
      System.out.print(message.charAt(i));
      waitTime(time / message.length());
    }
    System.out.println();
  }

  /**
   * Uses Thread.sleep to wait a period of time before continuing running.
   *
   * @param time a period of time in milliseconds to wait. Waits a given period of time in
   *     milliseconds. Checked exception
   */
  public static void waitTime(long time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      //Don't do anything with error and don't print out the error to the user.
    }
  }

  /**
   * Creates a array representation of a string, each character going to this 'array'
   * consecutively.
   *
   * @param str String to convert to an array format. Example: "Hello" would result in "[H, e,
   *     l, l,
   *     o]"
   * @return The string in an array form.
   */
  private static String convertStringToArray(String str) {
    StringBuilder userMessage = new StringBuilder("[");

    for (int x = 0; x < str.length(); x++) { // Loop over each character and print it.
      char currentLetter = str.charAt(x);

      if (x != str.length() - 1) {
        userMessage.append(currentLetter).append(", ");
      } else {
        userMessage.append(currentLetter).append("]");
      }
    }

    return userMessage.toString();
  }

  /**
   * Prints a string as an array over a given period of time.
   *
   * @param str The string to print over a period of time.
   * @param time The amount of time, in milliseconds to take printing the string.
   */
  private static void printStringAsArray(String str, long time) {
    slowPrint(convertStringToArray(str), time);
  }

  /**
   * Asks the user to enter something and repeatedly asks again if the response is not in the list
   * of acceptable sentinel phrases.
   *
   * @param possibleExits a List of strings objects to check for against the scanner input.
   * @param responseOnIncorrectInput What to print if the input is not correct.
   * @return The string that was input and also in the checkFor array.
   */
  public static String waitForCertainInput(List<String> possibleExits,
      String responseOnIncorrectInput) {
    String scanInput = input.nextLine().toLowerCase().trim();

    while (!possibleExits.contains(scanInput)) {

      if (responseOnIncorrectInput.length() != 0) {
        System.out.println(responseOnIncorrectInput);
      }

      scanInput = input.nextLine().toLowerCase().trim();
    }
    return scanInput;
  }

  /**
   * Generates a random number from a range of 0 to a given maximum number.
   *
   * @param numberOfSides The max number to randomly generate.
   * @return A random number from the range of 0 to numberOfSides
   */
  public static int generateRandomNumber(int numberOfSides) {
    return random.nextInt(numberOfSides) + 1;
  }

  /**
   * Example to show casting objects between instances of Number and ImaginaryNumber. Prints out the
   * number itself regardless of if it's a normal Number or ImaginaryNumber in the proper format.
   *
   * @param num : An instance of the Number class to print.
   * @return The toString() representation of a Number object.
   */
  public static String printNumber(Number num) {
    // Cast number back to Imaginary to print it
    // properly?

    if (num instanceof ImaginaryNumber) {
      System.out.println(num.add(num, new Number(123)));
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

  /*
  All these classes are static since they are methods of the class, not of the object.
  You also can't call a non-static method from a method that's static.
   */

  /**
   * Find the minimum value in an array.
   *
   * @param array An array of integers.
   * @return The minimum value in the array.
   */
  public static int findMinimumInArray(int[] array) {
    int min = array[0];

    for (int i = 0; i < array.length; i++) {
      if (min > array[i]) {
        min = array[i];
      }
    }
    return min;
  }

  /**
   * Find the maximum value in an array.
   *
   * @param array An array of integers to find the maximum value of.
   * @return The maximum value in the array.
   */
  public static int findMaximumInArray(int[] array) {
    int max = array[0];

    for (int i = 0; i < array.length; i++) {
      if (max < array[i]) {
        max = array[i];
      }
    }
    return max;
  }

  /**
   * Calculates the sum of all the values in the array.
   *
   * @param arr An array of integers
   * @return The sum of all the integers in the array. Returns 0 if empty.
   */
  public static int sumArray(int[] arr) {
    int sum = 0;
    for (int i : arr) {
      sum += i;
    }
    return sum;
  }

  /**
   * Finds the index of a given value within an array of integers.
   *
   * @param arr The given array to search.
   * @param num The number to find in the array.
   * @return The index of the value given in the array, or -1 if it was not found.
   */
  public static int getIndexOf(int[] arr, int num) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == num) {
        return i;
      }
    }
    return -1;
  }

}
