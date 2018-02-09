import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * Travis Gayle
 * Integration Project
 */

public class IntegrationProject {
    static Scanner input;
    static Random random = new Random();


    public static void main(String[] args) {
        input = new Scanner(System.in);
        random.setSeed(System.currentTimeMillis());

        System.out.println("Hello from the integration project!");

        System.out.print("Loading");
        slowPrint("...........", 1600); //Slowly print this given string over approx 1.6 seconds.

        System.out.println("Please enter your name for login: ");
        String inputName = input.nextLine();

        System.out.println("Please enter a number of no particular relevance: ");
        int inputNum = input.nextInt();
       input.nextLine(); //Move to next line to take inputs normally in the future.

        System.out.println("System debugging necessary. Press enter to continue.");
        input.nextLine();

        // Print the user in an array format.
        printStringAsArray(inputName.toUpperCase().trim(), 600L);
        
        System.out.println("Magic Random Number Generator: " + generateRandomNumber(6) + " out of 6.");
        System.out.println("Number of no particular relevance over 2.24 equals " + inputNum / 2.24d);

        System.out.println("Beginning core JRE check:");
        waitTime(500L);
        System.out.println("Primitive types check:");
        System.out.println();

        // Print out primitive data types and their ranges.
        for (PrimitiveTypeModel type : PrimitiveTypeModel.types) {
            System.out.print(type.getType() + ": exists");
            slowPrint("..........", 300);
            System.out.println(type.getType() + String.format(" range was [%s, %s]%n",
                    type.getMinValue(), type.getMaxValue()));
        }

        System.out.println("Primitive check complete.");
        // End primitive datatype check.

        waitTime(500L);
        System.out.println("Would you like to play a game?");
        System.out.println("Yes or No?: ");

       String playGameDecision = waitForCertainInput(new String[] {"y", "n", "yes", "no"}, "Please enter the proper input: ");
       String[] yesDecisions = new String[] {"y", "yes"};
       
       if (Arrays.asList(yesDecisions).contains(playGameDecision)) {
           System.out.println("Continuing to game...");
       } else {
           System.out.println("Continuing to game anyways...");
       }
       
       input.close();
       

    }

    // Slowly appends the message to the current line over the given time.
    // Time is given in milliseconds so 1000ms equals 1 second.
    public static void slowPrint(String message, long time) {
        for (int i = 0; i < message.length(); i++) {

            System.out.print(message.charAt(i));

            waitTime(time / message.length());
        }
        System.out.println();
    }

    /*
     * Waits a given period of time in milliseconds.
     */
    public static void waitTime(long time) {
        try {
            Thread.sleep(0); // temporarily set to 0 instead of time
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /*
     * Takes a String and prints it over a given time in milliseconds.
     */
    public static void printStringAsArray(String str, long time) {
        String userMessage = "USER: [";
       
        for (int x = 0; x < str.length(); x++) { // Loop over each character and print it.
            char currentLetter = str.charAt(x); //char casted and appended to userMessage string.

            if (x != str.length() - 1) {
                userMessage += (currentLetter + ", ");
            } else {
                userMessage += (currentLetter + "]");
            }

        }

        slowPrint(userMessage, time);
    }
    
    /**
     * 
     * @param checkFor an array of strings objects to check for against the scanner input.
     * @param responseOnIncorrectInput What to print if the input is not correct.
     * @return The string that was input to finish waiting. 
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
    
    public static int generateRandomNumber(int numberOfSides) {
        return random.nextInt(numberOfSides) + 1;
    }

}
