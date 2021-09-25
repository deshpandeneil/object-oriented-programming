import java.util.Scanner;

public class Book extends Publication {
	
	// declare book class data members
	
	private String author;
	
	// declare book class member functions
	
	public void read() { // take user input for all data members
		System.out.println("\nEnter Book Details\n");
		
		super.read(); // call parent class read method
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the book's author: ");
		author = sc.nextLine();
	}
	
	public void display_book() { // display user entered values for all data members
		display(); // call parent class display method
		
		System.out.println("Author: " + author + "\n");
	}
	
	public void order_copies(int qty) { // order additional stock
		copiesAvailableSetter(qty); // update available copies
		
		// display confirmation and success message
		
		System.out.println("Copies ordered: " + qty);
		System.out.println("Copies available: " + copiesAvailableGetter());
	}
}
