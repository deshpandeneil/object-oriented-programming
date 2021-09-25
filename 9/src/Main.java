import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	
	public int menu() {
		int option = 0;
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		do { // keep looping till correct data type is not entered
			System.out.print("\nMENU\n\n1. Register new product\n2. Buy stock\n3. Add to cart\n4. Remove from cart\n5. Display Inventory\n6. Check Out\n7. Show Stock Purchase History\n8. Exit\n\nEnter the serial number of the operation you want to perform: ");
			try {
				option = sc.nextInt();
				flag = false;
			}
			catch(InputMismatchException e) { // see if data type is not correct
				flag = true; // set flag for looping
				System.out.println("\nPlease enter the correct serial number\n");
			}
		} while(flag == true);
		return option; // return correct option
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		// create necessary variables / objects
		Scanner sc = new Scanner(System.in);
		LinkedList <Product> productList = new LinkedList <Product>();
		LinkedList <Category> categoryList = new LinkedList <Category>();
		Main ims = new Main();
		Cart cart = new Cart();
		Product p = null;
		int option = ims.menu(); // display menu
		do {
			switch(option) { // switch user input and call appropriate function
			case 1:
				p = new Product(categoryList);
				p.registerProduct(productList, p);
				break;
			case 2:
				p.addStock(productList);
				break;
			case 3:
				String productToAdd;
				System.out.print("\nEnter the name of the product which your wish to add: ");
				productToAdd = sc.nextLine();
				cart.add(productList, productToAdd);
				break;
			case 4:
				String productToRemove;
				System.out.print("\nEnter the name of the product which your wish to add: ");
				productToRemove = sc.nextLine();
				cart.remove(productList, productToRemove);
				break;
			case 5:
				System.out.println("\n\nDATABASE\n\n");
				System.out.println("Name\t\t\tPrice\t\t\tStock\n");
				for(int i = 0; i < productList.size(); i++) {
					productList.get(i).display();
				}
				break;
			case 6:
				cart.checkout(productList);
				break;
			case 7:
				p.displayBuyingHistory();
				break;
			case 8:
				System.out.println("\nThank you for using our system\n");
				return;
			}
			option = ims.menu(); // ask for user input for menu again
		} while(option != 8);
		System.out.println("\nThank you for using our system\n");
	}

}
