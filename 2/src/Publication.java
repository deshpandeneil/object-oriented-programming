import java.util.Scanner;

public class Publication {
	
	// declare data members
	
	private String title;
	private int copiesAvailable;
	private static int totalSale;
	private float price;
	
	// declare member functions
	
	public void copiesAvailableSetter(int n) {
		copiesAvailable += n;
	}
	
	public int copiesAvailableGetter() {
		return copiesAvailable;
	}
	
	public void read() { // take user input for above data members
		Scanner sc = new Scanner(System.in);
		
		System.out.print("\nEnter title: ");
		title = sc.nextLine();
		
		System.out.print("Enter price: ");
		price = sc.nextFloat();
		
		System.out.print("Enter the available number of copies: ");
		copiesAvailable = sc.nextInt();
	}
	
	public void display() { // display user entered values of above data members
		System.out.println("\nTitle: " + title);
		System.out.println("Price: ₹ " + price);
		System.out.println("Number of available copies available: " + copiesAvailable);
	}
	
	public void sell_copy(int qty) { // sell book or magazine from available copies
		if(qty <= (copiesAvailable - 5)) { // allow selling until 5 copies remain
			copiesAvailable -= qty; // update available copies
			System.out.println("Customer bill: ₹ " + (qty * price)); // display bill
			System.out.println(qty + " copies have been sold."); // display success message
			totalSale += qty;
		} else { // prompt user to re-enter quantity if stock gets below 5 after selling
			System.out.print("Maximum copies you can sell is " + (copiesAvailable - 5) + ", please re-enter the number of copies you want to sell: ");
			Scanner sc = new Scanner(System.in);
			int x = sc.nextInt();
			sell_copy(x); // call same function again with new quantity
		}
	}
	
	public void total_sale() {
		System.out.println("\nTotal sale made by publication (books + magazine): " + totalSale);
	}
}
