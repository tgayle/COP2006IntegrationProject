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
        
        System.out.println("byte: exists");
        slowPrint("..........", 600L);
        System.out.println("byte range was [-128, 127]");
        
        
        

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
