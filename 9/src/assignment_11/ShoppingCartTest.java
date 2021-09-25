package assignment_11;

import java.util.Random;
import java.util.Scanner;

public class ShoppingCartTest {

	static void register() {
		
	}
	
	public static void main(String[] args) {
		ShoppingCart cart = new ShoppingCart();
		Scanner sc = new Scanner(System.in);
		int option;
		
		do {
			System.out.print("\n\nMENU\n\n1. Add Items to Cart\n2. Remove Item from Cart\n3. Display Cart\n4. Checkout\n5. Exit\n\nSelect an option from 1 to 5: ");
			option = sc.nextInt();
			switch(option) {
			case 1:
				String name;
				int price;
				Random random = new Random();
				System.out.print("\nEnter the name of the item: ");
				sc.nextLine();
				name = sc.nextLine();
				System.out.print("\nEnter the price of the item: ");
				price = sc.nextInt();
				Item item = new Item(Integer.toString(random.nextInt(2000)), name, price);
				cart.addItem(item);
				break;
			case 2:
				String itemToRemove;
				System.out.print("\nEnter the name of the item: ");
				sc.nextLine();
				itemToRemove = sc.nextLine();
				cart.removeItem(itemToRemove);
				break;
			case 3:
				cart.display();
				break;
			case 4:
				int total, paymentMethod;
				total = cart.calculateTotal();
				System.out.print("\nYour total bill is: ₹ " + total + "\n\nPlease choose a payment method\n\n1. Credit / Debit Card\n2. PayPal\n3. Bitcoin\n\nEnter your choice: ");
				paymentMethod = sc.nextInt();
				switch(paymentMethod) {
				case 1:
					String customerName, cardNum, cvv, DateOfExp;
					System.out.print("\nEnter your name: ");
					sc.nextLine();
					customerName = sc.nextLine();
					System.out.print("\nEnter your card number: ");
					cardNum = sc.nextLine();
					System.out.print("\nEnter your card cvv: ");
					cvv = sc.nextLine();
					System.out.print("\nEnter your cards date of expiry: ");
					DateOfExp = sc.nextLine();
					cart.pay(new CreditCardStrategy(customerName,  cardNum, cvv, DateOfExp));
					break;
				case 2:
					String emailId, password;
					System.out.print("\nEnter your email id: ");
					sc.nextLine();
					emailId = sc.nextLine();
					System.out.print("\nEnter your password: ");
					password = sc.nextLine();
					cart.pay(new PaypalStrategy(emailId, password));
					break;
				case 3:
					String emailId2, password2, accNum;
					System.out.print("\nEnter your email id: ");
					sc.nextLine();
					emailId2 = sc.nextLine();
					System.out.print("\nEnter your password: ");
					password2 = sc.nextLine();
					System.out.print("\nEnter your bitcoin account number: ");
					accNum = sc.nextLine();
					cart.pay(new BitcoinStrategy(emailId2, password2, accNum));
					break;
				default:
					System.out.println("\nInvalid payment method");
					break;
				}
				break;
			case 5:
				return;
			default:
				System.out.println("\nInvalid option.");
				break;
			}
		} while(true);
	}
}

