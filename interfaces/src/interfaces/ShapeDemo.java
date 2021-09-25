package interfaces;
import java.util.Scanner;

public class ShapeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
//		Shape s = new Shape(); // instance of parent class

		int option; // variable for storing users choice
		do{
			System.out.print("\nMENU\n\n1. Make Rectangle (parameterized)\n2. Make Triangle (parameterized)\n3. Make Circle\n4. Exit\n\nEnter serial number of the operation you want to perform: ");
			option = sc.nextInt();
			switch(option) {
			case 1:
//				double l, w;
//				// take inputs for l and w and call parameterized constructor of respective class
//				System.out.print("Enter lenght: ");
//				l = sc.nextDouble();
//				System.out.print("Enter width: ");
//				w = sc.nextDouble();
				Rectangle r1 = new Rectangle(); // create instance using parameterized constructor
//				s = r1; // change reference of shape instance to point to instance of rectangle class
				r1.calculate_area(); // call method to calculate area
				r1.calculate_perimeter();
				break;
			case 2:
//				double a ,b, c, h;
//				// take inputs for b and h and call parameterized constructor of respective class
//				System.out.print("Enter side 1: ");
//				a = sc.nextDouble();
//				System.out.print("Enter side 2: ");
//				c = sc.nextDouble();
//				System.out.print("Enter base: ");
//				b = sc.nextDouble();
//				System.out.print("Enter height: ");
//				h = sc.nextDouble();
				Triangle t1 = new Triangle(); // create instance using parameterized constructor
//				s = t1; // change reference of shape instance to point to instance of rectangle class
				t1.calculate_area(); // call method to calculate area
				t1.calculate_perimeter();
				break;
			case 3:
				double r;
				System.out.println("Enter radius: ");
				r = sc.nextDouble();
				Circle c1 = new Circle(r);
				c1.calculate_area();
				c1.calculate_perimeter();
				break;
//			case 3:
//				Rectangle r2 = new Rectangle(); // create instance using default constructor
//				r2.input(); // call method to take inputs of data members
//				s = r2; // change reference of shape instance to point to instance of rectangle class
//				s.calculate_area(); // call method to calculate area
//				break;
//			case 4:
//				Triangle t2 = new Triangle(); // create instance using default constructor
//				t2.input(); // call method to take inputs of data members
//				s = t2; // change reference of shape instance to point to instance of rectangle class
//				s.calculate_area(); // call method to calculate area
//				break;
			case 4:
				break;
			}
		}while(option != 4); // loop the menu driven code until user exits
		System.out.println("\nThank you for using our system.");
	}

}
