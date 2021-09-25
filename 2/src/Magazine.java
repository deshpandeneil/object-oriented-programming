import java.util.Scanner;

public class Magazine extends Publication { // inherit data members and functions from publication class
	
	// declare magazine class data members
	
	private int orderQty;
	private String currentIssue;
	
	// declare magazine class member functions
	
	public void read() { // take user input for all data members
		System.out.println("\nEnter Magazine Details\n");
		
		super.read(); // call parent class read method
		
		System.out.print("Enter magazine issue (dd/mm/yyyy): ");
		Scanner sc = new Scanner(System.in);
		currentIssue = sc.nextLine();
	}
	
	public void display() { // display user entered values for all data members
		super.display(); // call parent class display method
		
		System.out.println("Current Issue: " + currentIssue);
	}
	
	public void receive_new_issue(String newIssueDate, int qty) { // order stock for new issue
		
		// update data members according to new issue
		
		orderQty = qty;
		copiesAvailableSetter(qty);
		currentIssue = newIssueDate;
		
		// display confirmation and success message
		
		System.out.println("\nYour order for " + orderQty + " copies of latest issue has been placed.\n");
	}
}
