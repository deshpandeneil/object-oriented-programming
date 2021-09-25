
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import assignment_11.BitcoinStrategy;
import assignment_11.CreditCardStrategy;
import assignment_11.PaypalStrategy;
import assignment_11.ShoppingCart;

public class Product extends Category {
	String product_name, product_description;
	int stock, qtyInCart;
	double price;
	
	// file paths
	private String FILE_PATH = "/media/neil/New Volume/ubuntu/college/sem 3/oop/lab/assignments/9/src";
	private String FILE_NAME = "buying_records.txt";
	
	Product(LinkedList <Category> categoryList){ // initialize data members
		super(categoryList);
		product_name = "";
		product_description = "";
		stock = 0;
		qtyInCart = 0;
		price = 0.0;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	void registerProduct(LinkedList <Product> productList, Product product){
		Scanner sc = new Scanner(System.in);
		boolean product_exists = false;
		System.out.print("Enter product name: ");
		product.product_name = sc.nextLine();
		
		System.out.print("Enter product description: ");
		product.product_description = sc.nextLine();
		
		for(int j = 0; j < productList.size(); j++) { // loop through list and compare name strings
			if(productList.get(j).product_name.equals(product.product_name) && productList.get(j).product_description.equals(product.product_description)) {
				product_exists = true;
				break;
			} else {
				product_exists = false;
				continue;
			}
		}
		if(!product_exists) { // if product does not exist, ask for details
			System.out.print("Enter product price: ");
			product.price = sc.nextDouble();
			System.out.print("Enter initial product stock: ");
			product.stock = sc.nextInt();
			productList.add(product);
		} else
			System.out.println("\nThis product is already registered.");
	}
	
	void addStock(LinkedList <Product> productList) {
		
		// format of storage in file
		// product name->amount->bill->payment method->status of payment
		
		Scanner sc = new Scanner(System.in);
		int amtToBuy;
		System.out.print("Enter product name: ");
		String prodToBuy = sc.nextLine();
		
		for(int j = 0; j < productList.size(); j++) {
			if(productList.get(j).product_name.equals(prodToBuy)) {
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
					FileWriter fw = new FileWriter(f, true);
					
					System.out.print("Enter amount of stock you wish to buy: ");
					amtToBuy = sc.nextInt();
					
					productList.get(j).stock += amtToBuy;
					System.out.println("\nYour bill: ₹ " + (amtToBuy * productList.get(j).price));
					
					if(amtToBuy * productList.get(j).price > 0){
						// write to file only if total bill > 0
						fw.write(prodToBuy + "\t");
						fw.write(Integer.toString(amtToBuy) + "\t"); // use tab as space to differentiate between fields
						fw.write(Double.toString(amtToBuy * productList.get(j).price) + "\t");
						int paymentMethod;
						ShoppingCart cart = new ShoppingCart();
						boolean paymentFlag = false;
						do {
							
							// the following code is similar to that of assignment 11
							System.out.print("\n\nPlease choose a payment method\n\n1. Credit / Debit Card\n2. PayPal\n3. Bitcoin\n\nEnter your choice: ");
							paymentMethod = sc.nextInt();
							switch(paymentMethod) {
							case 1:
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
								System.out.println("\n₹ " + amtToBuy * productList.get(j).price +" paid with credit/debit card");
								paymentFlag = false;
								break;
							case 2:
								fw.write("PayPal\t"); // log payment method
								String emailId, password;
								System.out.print("\nEnter your email id: ");
								sc.nextLine();
								emailId = sc.nextLine();
								System.out.print("\nEnter your password: ");
								password = sc.nextLine();
								cart.pay(new PaypalStrategy(emailId, password));
								System.out.println("\n₹ " + amtToBuy * productList.get(j).price +" paid with PayPal");
								paymentFlag = false;
								break;
							case 3:
								fw.write("Bitcoin\t"); // log payment method
								String emailId2, password2, accNum;
								System.out.print("\nEnter your email id: ");
								sc.nextLine();
								emailId2 = sc.nextLine();
								System.out.print("\nEnter your password: ");
								password2 = sc.nextLine();
								System.out.print("\nEnter your bitcoin account number: ");
								accNum = sc.nextLine();
								cart.pay(new BitcoinStrategy(emailId2, password2, accNum));
								System.out.println("\n₹ " + amtToBuy * productList.get(j).price +" paid with Bitcoins");
								paymentFlag = false;
								break;
							default:
								System.out.println("\nInvalid payment method");
								paymentFlag = true;
								break;
							}
					}while(paymentFlag);
						fw.write("Payment Successful\n"); // log payment status
						fw.close();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // file writer opened in append mode
				
				return;
			} else
				continue;
		}
		
		System.out.println("\nThis product is not registered. Please register it first.");
	}
	
	void display() {
		if(this.stock != 0)
			System.out.println(this.product_name + "\t\t\t₹" + this.price + "\t\t\t" + this.stock);
	}
	
	public void displayBuyingHistory() {
		File f = new File(FILE_PATH, FILE_NAME);
		int i = 0;
		try {
			Scanner fr = new Scanner(f);
			System.out.print("\n\nBUYING HISTORY\n\n");
			// product name-amount-bill-payment method-status of payment
			System.out.print("\nSr.No.\t\tProduct\t\tAmount\t\tBill\t\tPay Method\t\tStatus of Payment\n\n");
			while(fr.hasNextLine()) {
				System.out.print((i + 1) + "\t");
				String [] details = fr.nextLine().split("\t"); // split into array
				for(int j = 0; j < details.length; j++) {
					System.out.print(details[j] + "\t\t"); // display contents in proper format
				}
				System.out.print("\n");
				i++;
			}
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
