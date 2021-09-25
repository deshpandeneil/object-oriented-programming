/**
 * 
 */
// import scanner class to take user inputs
import java.util.Scanner;
/**
 * @author neil
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// declare a menu variable to drive menu
		int option;
		
		// create scanner object to take user inputs
		Scanner sc = new Scanner(System.in);
		
		// display menu and prompt user to select an option
		System.out.println("\nMENU\n\n1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Exit");
		System.out.println("\n\nEnter the serial number of the operation you want to perform: ");
		
		// take user input into menu variable
		option = sc.nextInt();
		
		// make a do-while loop to carry out operations continuously
		do {
			// if exit menu option is selected then exit do-while loop
			// else proceed
			if(option == 5) {
				break;
			}
			
			// take user input for real and imaginary part of complex number 1
			System.out.println("\nEnter real part of number 1: ");
			float x = sc.nextFloat();
			System.out.println("Enter imaginary part of number 1: ");
			float y = sc.nextFloat();
			
			// create object of class complex
			// object is created using default constructor
			Complex c1 = new Complex();
			// set above entered values to the object's data members using setter function
			c1.assign(x, y);
			
			// take user input for real and imaginary part of complex number 2
			System.out.println("Enter real part of number 2: ");
			float a = sc.nextFloat();
			System.out.println("Enter imaginary part of number 2: ");
			float b = sc.nextFloat();
			
			// create another object of class complex
			// pass above entered values as parameters to its constructor
			Complex c2 = new Complex(a, b);
			
			// create third object to store results of operation
			Complex c = new Complex();
			
			// switch the menu variable and call respective operation function
			switch(option) {
			case 1:
				
				c.Add(c1, c2);
				System.out.print("\nSum of entered complex numbers is: ");
				c.display();
				break;
				
			case 2:
				
				c.Sub(c1, c2);
				System.out.print("\nSubtraction of entered complex numbers is: ");
				c.display();
				break;
				
			case 3:
				
				c.Mul(c1, c2);
				System.out.print("\nMultiplication of entered complex numbers is: ");
				c.display();
				break;
				
			case 4:
				
				c.Div(c1, c2);
				System.out.print("\nDivision of entered complex numbers is: ");
				c.display();
				break;
				
				// enter the default message for validation
			default:
				
				System.out.println("Please enter a valid option number.");
			}
			
			// display menu again and prompt user to select an option
			System.out.println("\nMENU\n\n1. Add\n2. Subtract\n3. Multiply\n4. Divide\n5. Exit");
			System.out.println("\n\nEnter the serial number of the operation you want to perform: ");
			
			// take user input into menu variable
			option = sc.nextInt();
			
		} while(option != 5); // exit do-while loop if exit menu option is selected otherwise re-iterate
	
		System.out.println("\nThank you for viewing this demo.");
	}

}
