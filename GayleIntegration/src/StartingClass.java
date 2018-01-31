import java.util.Scanner;

/*
 * Travis Gayle
 * Integration project for skills learned in COP 2006.
 */

public class StartingClass {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Hello from the integration project!\n\n\n");
		
		
		System.out.println("What's your favorite number?");
//		int num1 = input.nextInt();
//		
//		System.out.println("Enter a rate:");
//		double rate = input.nextDouble();
//		input.nextLine();
//		
//		System.out.println("What's your name?");
//		String name = input.nextLine();
//		
//		System.out.println(String.format("Hi there, %s! My favorite number is %d too!", name, num1));
		
		Dog spot = new Dog();
		spot.size = 30;
		spot.breed = "German Shepherd";
		Dog spuds = new Dog();
		spuds.size = 40;
		
	}

	
}

class Dog {
	double size;
	int activityLevel;
	String breed;
	
}

class Dog2 {
	//gotta know how to make a class on the next quiz 
}