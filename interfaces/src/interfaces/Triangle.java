package interfaces;
import java.util.Scanner;

public class Triangle implements ReadData {
	double a, b, c, h;
	
	public void calculate_area() {
		// TODO Auto-generated method stub
		System.out.println("Area of triangle is: " + (0.5 * b * h));
	}
	
	public void calculate_perimeter() {
		// TODO Auto-generated method stub
		System.out.println("Perimeter of triangle is: " + (a + b + c));
	}
	public void read_data() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double a ,b, c, h;
		// take inputs for b and h and call parameterized constructor of respective class
		System.out.print("Enter side 1: ");
		a = sc.nextDouble();
		System.out.print("Enter side 2: ");
		c = sc.nextDouble();
		System.out.print("Enter base: ");
		b = sc.nextDouble();
		System.out.print("Enter height: ");
		h = sc.nextDouble();
	}
	
}
