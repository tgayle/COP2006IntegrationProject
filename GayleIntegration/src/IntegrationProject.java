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
		
		System.out.println((char)(20));
	}
	
	void randomPrint(String message, long time) {
		
	}
}
