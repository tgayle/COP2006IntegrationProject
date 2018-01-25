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
		
		System.out.println("What is your name?");
		String inputName = input.nextLine();
		
		System.out.println("What is your favorite number?");
		int inputNum = input.nextInt();
		input.nextLine();
		
		System.out.print("USER: [");
		
		for (int i = 0; i < inputName.length(); i++)
		{
			System.out.print(inputName.toCharArray()[i]);
		}
		//System.out.println(inputName.toCharArray());
		
		System.out.println("]");
		
	}

}
