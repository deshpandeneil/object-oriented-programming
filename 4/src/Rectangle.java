import java.util.Scanner;

public class Rectangle extends Shape { // child class of Shape
	
	Rectangle(){ // default constructor calls default constructor of super class
		super();
	}
	
	Rectangle(double x, double y){ // parameterized constructor calls parameterized constructor of super class
		super(x, y);
	}
	
	public void input() { // input method to set values of data members of parent class
		Scanner sc = new Scanner(System.in);
		double l, w;
		System.out.print("Enter lenght: ");
		l = sc.nextDouble();
		System.out.print("Enter width: ");
		w = sc.nextDouble();
		setter(l, w); // call setter function to set values
	}
	
	public void calculate_area(){ // parent class method overridden to calculate area
		System.out.println("\nArea of rectangle is: " + (get_a() * get_b()) + " unit sq.");
	}
}
