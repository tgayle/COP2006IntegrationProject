import java.util.Random;
import java.util.Scanner;

/*
 * Travis Gayle
 * Integration Project
 */


public class IntegrationProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.println("Hello from the integration project!");
		
		//Module 2
		System.out.println("What is your name?");
		String inputName = "Five Star Notebooks";//input.nextLine();
		
		System.out.println("What is your favorite number?");
		int inputNum = 5; //input.nextInt();
		//input.nextLine();
		
		{
			System.out.print("USER: [");
			
			String upperName = inputName.toUpperCase().trim();
			for (int x = 0; x < upperName.length(); x++) {
				char currentLetter = upperName.charAt(x);
				
				if (x != upperName.length()-1) {
					System.out.print(currentLetter + ", ");
				} else {
					System.out.print(currentLetter);
				}
			}
			System.out.print("]");
		}
		
		for (int x = 32; x < 123; x++) {
			//System.out.println((char)(x));
		}
		
		randomPrint(inputName, 4000);
		
		
	}
	
	/*
	 * int / int is always an int
	 */
	
	static void randomPrint(String message, long time) {
		int len = message.length();
		long waiting = (time / len)/2;
		int count = 0;
		String progress = "";
		System.out.println();
		Random rand = new Random();
		for (int i = 0; i < len; i++) {
			int num = rand.nextInt(156) + 32;
			progress += (char)(num);
			
			System.out.print((char)(num));
			
			try {
				Thread.sleep(waiting);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.print("\r\r");
		for (int i = 0; i < len; i++) { //replace with real string

			
			System.out.print(message.charAt(i));
			
			try {
				Thread.sleep(waiting);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		//System.out.println(progress);
	}
}
