import java.util.Random;
import java.util.Scanner;

/*
 * Travis Gayle
 * Integration Project
 */

public class IntegrationProject {

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    System.out.println("Hello from the integration project!");

    System.out.print("Loading");
    slowPrint("...........", 1600);

    System.out.println("Please enter your name for login: ");
    String inputName = "Five Star Notebooks";

    System.out.println("Please enter a number of no particular relevance: ");
    int inputNum = 5; // input.nextInt();
    // input.nextLine(); //Move to next line to take inputs normally in the future.

    System.out.println("System debugging necessary. Press enter to continue.");
    input.nextLine();

    { //Print the user's name as an array.
      String userMessage = "USER: [";
      String upperName = inputName.toUpperCase().trim();

      for (int x = 0; x < upperName.length(); x++) { //Loop over each character and print it.
        char currentLetter = upperName.charAt(x);

        if (x != upperName.length() - 1) {
          userMessage += (currentLetter + ", ");
        } else {
          userMessage += (currentLetter + "]");
        }

      }

      slowPrint(userMessage, 800L);
    }

    System.out.println("Beginning core JRE check:");
    waitTime(500);
    System.out.println("Primitive types check:");
    System.out.println();

    long primitiveDatatypeCheckWaitLength = 300L;

    System.out.print("byte: exists");
    slowPrint("..........", primitiveDatatypeCheckWaitLength);
    System.out.println("byte " + String.format("range was [%d, %d]", Byte.MIN_VALUE, Byte.MAX_VALUE));

    System.out.print("short: exists");
    slowPrint("..........", primitiveDatatypeCheckWaitLength);
    System.out.println("short " + String.format("range was [%d, %d]", Short.MIN_VALUE, Short.MAX_VALUE));

    System.out.print("int: exists");
    slowPrint("..........", primitiveDatatypeCheckWaitLength);
    System.out.println("int " + String.format("range was [%d, %d]", Integer.MIN_VALUE, Integer.MAX_VALUE));

    System.out.print("long: exists");
    slowPrint("..........", primitiveDatatypeCheckWaitLength);
    System.out.println("long " + String.format("range was [%d, %d]", Long.MIN_VALUE, Long.MAX_VALUE));

    System.out.print("float: exists");
    slowPrint("..........", primitiveDatatypeCheckWaitLength);
    System.out.println("float " + String.format("range was [%f, %f]", Float.MIN_VALUE, Float.MAX_VALUE));

    System.out.print("double: exists");
    slowPrint("..........", primitiveDatatypeCheckWaitLength);
    System.out.println("double " + String.format("range was [%f, %f]", Double.MIN_VALUE, Double.MAX_VALUE));

    System.out.print("boolean: exists");
    slowPrint("..........", primitiveDatatypeCheckWaitLength);
    System.out.println("boolean range was [false, true]");

    System.out.print("char: exists");
    slowPrint("..........", primitiveDatatypeCheckWaitLength);
    System.out.println("char " + String.format("range was [%s, %s]", Character.MIN_VALUE, Character.MAX_VALUE));



  }

  //Slowly prints the given message over the given time. Time is given in milliseconds so 1000ms
  //equals 1 second.
  static void slowPrint(String message, long time) {
    for (int i = 0; i < message.length(); i++) {

      System.out.print(message.charAt(i));

      waitTime(time / message.length());
    }
    System.out.println();
  }

  static void waitTime(long time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  static void checkPrimitives() {

  }

}
