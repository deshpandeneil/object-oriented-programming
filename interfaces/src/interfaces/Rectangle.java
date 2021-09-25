package interfaces;

import java.util.Scanner;

public class Rectangle implements ReadData {
	double l, w, a, p;
	
	public void calculate_area() {
		System.out.println("Area of rectangle is: " + (l * w));
	}
	public void calculate_perimeter() {
		// TODO Auto-generated method stub
		System.out.println("Perimeter of rectangle is: " + (2 * (l + w)));
	}
	public void read_data() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double l, w;
		// take inputs for l and w and call parameterized constructor of respective class
		System.out.print("Enter lenght: ");
		l = sc.nextDouble();
		System.out.print("Enter width: ");
		w = sc.nextDouble();
	}
	public void display_data() {
		// TODO Auto-generated method stub
		
	}
}
