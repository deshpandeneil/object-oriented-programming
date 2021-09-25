package MockTest;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Shipment []s = new Shipment[10]; // array of objects
		int option = 0, counter = 0;
		System.out.print("\nMENU\n\n1. Add shipment\n2. Display shipment details\n3. Exit\n\nEnter your choice: ");
		option = sc.nextInt();
		do {
			switch(option) {
			case 1:
				s[++counter] = new Shipment(); // create new object - calls default constructor
				break;
			case 2:
				int index;
				System.out.print("Enter the index number of the shipment you want  to view: ");
				index = sc.nextInt();
				try {
					s[index].display();
				} catch(NullPointerException e) {
					System.out.println("\n" + e + "\nPlease enter a correct index.\n");
				}
				break;
			case 3:
				System.out.println("\nThank you for viewing this demo.\n");
				break;
			default:
				System.out.println("\nPlease enter correct input.\n");
			}
			
			System.out.print("\n\nMENU\n\n1. Add shipment\n2. Display shipment details\n3. Exit\n\nEnter your choice: ");
			option = sc.nextInt();
		} while(option != 3);
		
//		Shipment s = new Shipment();
//		s.input_cost();
//		s.display();
	}

}
