
public class Complex {
	// declare data members
	
		float real, img;
		
		// declare member functions
		
		// default constructor
		public Complex() {
			real = 0;
			img = 0;
		}
		
		// parameterized constructor
		public Complex(float x, float y) {
			real = x;
			img = y;
		}
		
		// setter function to set values of data members
		public void assign(float x, float y) {
			real = x;
			img = y;
		}
		
		// add function to add two complex numbers
		// it takes two objects of class complex as parameters
		// result is stored in calling object
		public void Add(Complex o1, Complex o2) {
			real = o1.real + o2.real;
			img = o1.img + o2.img;
		}

		// add function to subtract two complex numbers
		// it takes two objects of class complex as parameters
		// result is stored in calling object
		public void Sub(Complex o1, Complex o2) { 
			real = o1.real - o2.real;
			img = o1.img - o2.img;
		}
		
		// add function to multiply two complex numbers
		// it takes two objects of class complex as parameters
		// result is stored in calling object
		public void Mul(Complex o1, Complex o2) {
			real = (o1.real * o2.real) + ((o1.img * o2.img) * (-1));
			img = (o1.real * o2.img) + (o1.img * o2.real);
		}
		
		// add function to divide two complex numbers
		// it takes two objects of class complex as parameters
		// result is stored in calling object
		public void Div(Complex o1, Complex o2) {
			float denominator = ((o2.real * o2.real) + (o2.img * o2.img));
			real = ((o1.real * o2.real) + (o1.img * o2.img)) / denominator; 
			img = ((o2.real * o1.img) - (o1.real * o2.img)) / denominator;	
		}
		
		// display function to display the complex number in rectangular form
		public void display() {
			
			// check if img part is +ve or -ve and display with proper signs
			if(this.img > 0) {
				System.out.println(this.real + " + " + Math.abs(this.img) + "i");
			} else {
				System.out.println(this.real + " - " + Math.abs(this.img) + "i");
			}
		}
}
