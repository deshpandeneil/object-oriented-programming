abstract public class Shape {
	private double a, b; // data members
	
	Shape(){ // default constructor initializes data members to 0
		a = 0;
		b = 0;
	}
	
	Shape(double x, double y){ // parameterized constructor sets value of data members according to parameters
		a = x;
		b = y;
	}
	
	public void setter(double x, double y) { // function to set value of data members form derived classes
		a = x;
		b = y;
	}
	
	public double get_a() { // getter method used to get data member for calculation of area
		return a;
	}
	
	public double get_b() { // getter method used to get data member for calculation of area
		return b;
	}
	
	abstract public void calculate_area(); // abstract method which is overridden in derived classes
}
