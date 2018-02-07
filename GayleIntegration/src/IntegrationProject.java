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

        // Print the user in an array format.
        printStringAsArray(inputName.toUpperCase().trim(), 600L);

        System.out.println("Beginning core JRE check:");
        waitTime(500L);
        System.out.println("Primitive types check:");
        System.out.println();

        long primitiveDatatypeCheckWaitLength = 300L;
        //Print out primitive data types and their ranges.
        for (PrimitiveTypeModel type: PrimitiveTypeModel.types) {
            System.out.print(type.getType() + ": exists");
            slowPrint("..........", primitiveDatatypeCheckWaitLength);
            System.out.println(
                    type.getType() + String.format(" range was [%s, %s]%n", type.getMinValue(), type.getMaxValue()));
        }

        System.out.println("Primitive check complete.");
        // End primitive datatype check.

        waitTime(500L);
        System.out.println("Would you like to play a game?");
        System.out.println("Yes or No?: ");
        
        String doesUserWantToPlayAGame = input.nextLine().trim();
        System.out.println(doesUserWantToPlayAGame + " was in.");
        System.out.println("doesUserWantToPlayAGame.equalsIgnoreCase(\"y\") was " +doesUserWantToPlayAGame.equalsIgnoreCase("y") );
        
        
        while (!doesUserWantToPlayAGame.equalsIgnoreCase("y")
                || !doesUserWantToPlayAGame.equalsIgnoreCase("n")) {
            System.out.println("Please enter a valid input. Yes or No?: ");
            System.out.println(doesUserWantToPlayAGame + " was in.");
            System.out.println("doesUserWantToPlayAGame.equalsIgnoreCase(\"y\") was " +doesUserWantToPlayAGame.equalsIgnoreCase("y") );
            doesUserWantToPlayAGame = input.nextLine().trim();
        }

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

    public static void waitTime(long time) {
        try {
            Thread.sleep(0); //temporarily set to 0 instead of time
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
            char currentLetter = str.charAt(x);

            if (x != str.length() - 1) {
                userMessage += (currentLetter + ", ");
            } else {
                userMessage += (currentLetter + "]");
            }

        }

        slowPrint(userMessage, time);
    }

}
