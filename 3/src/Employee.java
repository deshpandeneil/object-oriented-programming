import java.util.Scanner;

public class Employee {
	// declare data members
	String name, address, email, number;
	int id;
	static int id_counter = 1; // static for auto-incrementation
	
	Employee(){
		id = id_counter++; // creating an instance post increments the ID
	}
	// function to input employee details
	public void read() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter employee name: ");
		name = sc.nextLine();
		System.out.print("Enter employee address: ");
		address = sc.nextLine();
		System.out.print("Enter employee email: ");
		email = sc.nextLine();
		System.out.print("Enter employee phone number: ");
		number = sc.nextLine();
	}
	// function to display employee details
	public void display() {
		System.out.println("\n\t\t\t\tDetails");
		System.out.println("\t=====================================================");
		System.out.println("\n\tEmployee ID: \t\t\t\t" + id);
		System.out.println("\tEmployee name: \t\t\t\t" + name);
	}
}
