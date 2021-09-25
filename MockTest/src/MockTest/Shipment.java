package MockTest;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Shipment extends BoxWeight {
	double cost;
	
	Shipment(){
		super(); // calls default constructor of BoxWeight class
		input_cost(); // calls input function of this class
		
	}
	
	public void input_cost() {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		do {
			try {
				System.out.print("\nEnter shipment cost: ");
				cost = sc.nextDouble();
				flag = false;
			}
			catch(InputMismatchException e) {
				System.out.println("\n" + e + "\nPlease enter correct cost.\n");
				flag = true;
				sc.nextLine();
			}
		} while(flag == true);
	}
	
	public void display() {
		System.out.println("\nDETAILS");
		super.display();
		System.out.print("\nCost of shipment: ₹ " + cost);
	}
}
