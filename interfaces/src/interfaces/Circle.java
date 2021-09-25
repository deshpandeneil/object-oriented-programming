package interfaces;

public class Circle implements ReadData {
	double r, a, p;
	static double pi = 3.14;
	public Circle(double r) {
		this.r = r;
	}
	public void calculate_area() {
		a = (pi * r * r);
	}
	public void calculate_perimeter() {
		// TODO Auto-generated method stub
		System.out.println("Perimeter of circle is: " + (2 * pi * r));
	}
	public void read_data() {
		// TODO Auto-generated method stub
		
	}
	public void display_data() {
		System.out.println("Area is: " + a);
	}
	public double display_data() {
		return 2*pi*r;
	}
}
