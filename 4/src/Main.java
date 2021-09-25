import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		Shape s; // instance of parent class

		int option; // variable for storing users choice
		do{
			System.out.print("\nMENU\n\n1. Make Rectangle (parameterized)\n2. Make Triangle (parameterized)\n3. Make Rectangle (default)\n4. Make Triangle (default)\n5. Exit\n\nEnter serial number of the operation you want to perform: ");
			option = sc.nextInt();
			switch(option) {
			case 1:
				double l, w;
				// take inputs for l and w and call parameterized constructor of respective class
				System.out.print("Enter lenght: ");
				l = sc.nextDouble();
				System.out.print("Enter width: ");
				w = sc.nextDouble();
				Rectangle r1 = new Rectangle(l, w); // create instance using parameterized constructor
				s = r1; // change reference of shape instance to point to instance of rectangle class
				s.calculate_area(); // call method to calculate area
				break;
			case 2:
				double b, h;
				// take inputs for b and h and call parameterized constructor of respective class
				System.out.print("Enter base: ");
				b = sc.nextDouble();
				System.out.print("Enter height: ");
				h = sc.nextDouble();
				Triangle t1 = new Triangle(b, h); // create instance using parameterized constructor
				s = t1; // change reference of shape instance to point to instance of rectangle class
				s.calculate_area(); // call method to calculate area
				break;
			case 3:
				Rectangle r2 = new Rectangle(); // create instance using default constructor
				r2.input(); // call method to take inputs of data members
				s = r2; // change reference of shape instance to point to instance of rectangle class
				s.calculate_area(); // call method to calculate area
				break;
			case 4:
				Triangle t2 = new Triangle(); // create instance using default constructor
				t2.input(); // call method to take inputs of data members
				s = t2; // change reference of shape instance to point to instance of rectangle class
				s.calculate_area(); // call method to calculate area
				break;
			case 5:
				break;
			}
		}while(option != 5); // loop the menu driven code until user exits
		System.out.println("\nThank you for using our system.");
	}

}
