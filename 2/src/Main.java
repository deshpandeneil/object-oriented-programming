import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); // create scanner object
		int choice; // variable for user choice of book and magazine
		Book b = new Book(); // create book obj
		Magazine m = new Magazine(); // create magazine obj
		Publication p1 = null;
//		Publication p2 = new Magazine();
			
		do {
			
			// display publication menu
		
			System.out.println("\nPublication\n\n1. Book\n2. Magazine\n3. Display total sale\n4. Exit");
			System.out.print("\nEnter serial number of the product you want to work with: "); // take user input for choice
			choice = sc.nextInt(); // take user input for choice
			
			switch(choice) { // switch choice and call appropriate set of functions
			
				case 1:
					
					int bookOption; // create book obj
					p1 = new Book();
					
					// display menu for book class
					
					System.out.println("\nMENU\n\n1. Add new book's data\n2. Display Stock\n3. Order Book\n4. Sell Book\n5. Exit");
					System.out.print("\nEnter the serial number of the operation you want to perform: ");
					bookOption = sc.nextInt(); // take user input for option
					
					switch(bookOption) { // switch option and call appropriate function
					
						case 1:
							
							p1.read(); // call read method from book class
							break;
							
						case 2:
							
							p1.display(); // call display method from book class
							break;
						
						case 3:
						
							int order_qty; // variable to store user input for quantity
							System.out.print("Enter the quantity of books you want to order: ");
							order_qty = sc.nextInt(); // take user input
//							p1.order_copies(order_qty); // call appropriate book class method
							break;
						
						case 4:
						
							int sell_qty; // variable to store user input for sell quantity
							System.out.print("Enter the quantity of books you want to sell: ");
							sell_qty = sc.nextInt(); // take user input
							p1.sell_copy(sell_qty); // call appropriate book class method
							break;
						
						case 5:
						
							System.exit(0); // terminate program
							break;
						
						default:
						
							System.out.println("Please select valid option.");
					}
					
					break;
					
				case 2:
					
					int magazineOption; // create magazine class obj
					p1 = new Magazine();
					
					// display menu for magazine class
					
					System.out.println("\nMENU\n\n1. Add new magazine's data\n2. Display Stock\n3. Receive New Issue\n4. Sell Issues\n5. Exit");
					System.out.print("\nEnter the serial number of the operation you want to perform: ");
					magazineOption = sc.nextInt(); // take user input for option
					
					switch(magazineOption) {
					
						case 1:
							
							p1.read(); // call read method from magazine class
							break;
							
						case 2:
							
							p1.display(); // call display method from book class
							break;
						
						case 3:
						
							int order_qty; // variable to store user input for quantity
							String newIssueDate; // variable for date of new issue
							
							// take user input for above variables
							
							System.out.print("Enter the date of the issue you want to buy: ");
							sc.nextLine();
							newIssueDate = sc.nextLine();
							System.out.print("Enter the quantity of the issue you want to buy: ");
							order_qty = sc.nextInt();
//							p2.receive_new_issue(newIssueDate, order_qty);;
							break;
						
						case 4:
						
							int sell_qty; // variable to store user input for sell quantity
							System.out.print("Enter the quantity of issues you want to sell: ");
							sell_qty = sc.nextInt(); // take user input
							p1.sell_copy(sell_qty); // call appropriate magazine class method
							break;
						
						case 5:
						
							System.exit(0); // terminate program
							break;
						
						default:
						
							System.out.println("Please select valid option.");
					}
					
					break;
					
				case 3:
					p1.total_sale();
					break;
					
				case 4:
					
					// do nothing
					
					break;
					
				default:
					
					System.out.println("\nPlease enter valid serial number."); // error message
			}
			
		} while(choice != 4); // loop till user does not want to exit
		
		System.out.println("\nThank you for using our services.");
	}

}
