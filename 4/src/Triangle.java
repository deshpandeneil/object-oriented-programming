import java.util.Scanner;

public class Triangle extends Shape { // child class of Shape
	
	Triangle(){ // default constructor calls default constructor of super class
		super();
	}
	
	public void input() { // input method to set values of data members of parent class
		Scanner sc = new Scanner(System.in);
		double b, h;
		System.out.print("Enter base: ");
		b = sc.nextDouble();
		System.out.print("Enter height: ");
		h = sc.nextDouble();
		setter(b, h); // call setter function to set values
	}
	
	Triangle(double x, double y){ // parameterized constructor calls parameterized constructor of super class
		super(x, y);
	}
	
	public void calculate_area(){ // parent class method overridden to calculate area
		System.out.println("\nArea of triangle is: " + (0.5 * get_a() * get_b()) + " unit sq.");
	}
}
