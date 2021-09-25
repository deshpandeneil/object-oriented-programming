
import assignment_11.BitcoinStrategy;
import assignment_11.CreditCardStrategy;
import assignment_11.PaypalStrategy;
import assignment_11.ShoppingCart;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Cart {
	
	// file path variables
	private String FILE_PATH = "/media/neil/New Volume/ubuntu/college/sem 3/oop/lab/assignments/9/src";
	private String FILE_NAME = "selling_records.txt";
	
	void add(LinkedList <Product> productList, String product_name) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < productList.size(); i++) { // traverse LL
			if(productList.get(i).product_name.equals(product_name)){ // if product found add to cart
				int qty;
				System.out.print("\nEnter the quantity do you wish to buy: "); // ask user for quantity
				qty = sc.nextInt();
				if(qty < productList.get(i).stock - 5 && qty >= 1) { // minimum / maximum limit set
					productList.get(i).qtyInCart += qty; // update variables
					productList.get(i).stock -= qty;
				}
				else
					System.out.println("\nPlease add below the stock level (min 1).");
				break;
			}
		}
		display(productList); // display cart items
	}
	
	
	void writeToFile(LinkedList <Product> productList, FileWriter fw) { // log customers purchase
		for(int i = 0; i < productList.size(); i++) {
			if(productList.get(i).qtyInCart > 0) {
				try {
					fw.write(productList.get(i).product_name + "-->" + Integer.toString(productList.get(i).qtyInCart) + "\t"); // write all prods --> quantity
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	void display(LinkedList <Product> productList) { // display cart function
		System.out.println("\nSr. No.\t\tName\t\tQuantity");
		for(int i = 0; i < productList.size(); i++) {
			if(productList.get(i).qtyInCart > 0) { // display only if a unit is present in cart
				System.out.print("\n" + (i + 1) + "\t\t" + productList.get(i).product_name + "\t\t" + productList.get(i).qtyInCart);
			}
		}
	}
	
	void remove(LinkedList <Product> productList, String product_name) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i < productList.size(); i++) {
			if(productList.get(i).product_name.equals(product_name)){ // compare names
				if(productList.get(i).qtyInCart > 0) {
					productList.get(i).stock += productList.get(i).qtyInCart; // add qty in cart back to stock again
					productList.get(i).qtyInCart = 0; // update qty in cart
				}
				break;
			}
		}
		display(productList); // display cart
	}
	
	void checkout(LinkedList <Product> productList) {
		boolean paymentFlag = false;
		double totalCost = 0;
		for(int i = 0; i < productList.size(); i++) {
			if(productList.get(i).qtyInCart > 0) // check if product is in cart
				totalCost += productList.get(i).price * productList.get(i).qtyInCart; // calculate cost and add to total cose
		}
		File f = new File(FILE_PATH, FILE_NAME); // file object of specified file path
		if(!f.exists()) { // create file if it does not exist
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try {
			FileWriter fw = new FileWriter(f, true); // append mode
			int paymentMethod;
			ShoppingCart cart = new ShoppingCart();
			Scanner sc = new Scanner(System.in);
			System.out.println("\nITEMS BOUGHT");
			writeToFile(productList, fw); // log customer purchase
			do { // ask for customers choice of payment method
				System.out.print("\nYour total bill is: ₹ " + totalCost + "\n\nPlease choose a payment method\n\n1. Credit / Debit Card\n2. PayPal\n3. Bitcoin\n\nEnter your choice: ");
				paymentMethod = sc.nextInt();
				fw.write(Double.toString(totalCost) + "\t"); // log total cost
				
				// following switch case is similar to the code of assignment 11
				
				switch(paymentMethod) {
				case 1: // get deatils for credit card
					fw.write("Credit Card\t"); // log payment method
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
					System.out.println("\n₹ " + totalCost +" paid with credit/debit card");
					paymentFlag = false;
					break;
				case 2: // get details for paypal
					fw.write("PayPal\t");
					String emailId, password;
					System.out.print("\nEnter your email id: ");
					sc.nextLine();
					emailId = sc.nextLine();
					System.out.print("\nEnter your password: ");
					password = sc.nextLine();
					cart.pay(new PaypalStrategy(emailId, password));
					System.out.println("\n₹ " + totalCost +" paid with PayPal");
					paymentFlag = false;
					break;
				case 3: // get details for bitcoin
					fw.write("Bitcoin\t");
					String emailId2, password2, accNum;
					System.out.print("\nEnter your email id: ");
					sc.nextLine();
					emailId2 = sc.nextLine();
					System.out.print("\nEnter your password: ");
					password2 = sc.nextLine();
					System.out.print("\nEnter your bitcoin account number: ");
					accNum = sc.nextLine();
					cart.pay(new BitcoinStrategy(emailId2, password2, accNum));
					System.out.println("\n₹ " + totalCost +" paid with Bitcoins");
					paymentFlag = false;
					break;
				default:
					System.out.println("\nInvalid payment method");
					paymentFlag = true;
					break;
				}
			} while(paymentFlag);
			fw.write("Payment Successful\n"); // log status of payment
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i < productList.size(); i++) { // reset qty in cart after checkout
			if(productList.get(i).qtyInCart > 0) {
				productList.get(i).qtyInCart = 0;
			}
		}
	}
}
