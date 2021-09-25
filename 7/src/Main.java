import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Collection c = new Collection();
		int option; // variable to store user choice
		System.out.print("\nMENU\n\n1. Collection of strings\n2. Collection of integers\n3. Exit\n\nEnter your choice: "); // display menu
		option = sc.nextInt();
		if(option == 3) { // check if user entered 3 in first go
			System.out.println("\nThank you for viewing this demo\n"); // if yes display exit message
			return;
		}
		do {
			switch(option) {
			// call appropriate function according to users choice
			case 1:
				c.string_operation();
				break;
			case 2:
				c.integer_operation();
				break;
			case 3: // do nothing
				break;
			default:
				System.out.println("\nPlease enter a correct option.\n");
			}
			System.out.print("\nMENU\n\n1. Collection of strings\n2. Collection of integers\n3. Exit\n\nEnter your choice: ");
			option = sc.nextInt();
		} while(option != 3); // iterate the above code block till user does not exit
		System.out.println("\nThank you for viewing this demo.\n"); // display exit message
	}

}
