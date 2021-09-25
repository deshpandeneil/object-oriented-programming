package MockTest;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BoxWeight extends Box {
	double weight;
	
	BoxWeight(){
		super(); // calls default constructor of Box class
		super.calculate_volume(this); // call function of parent class and passes object as parameter
		input_weight(); // calls input function of this class
	}
	
	// methods
	
	public void input_weight() {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		do {
			try {
				System.out.print("\nEnter box weight (in kgs): ");
				weight = sc.nextDouble();
				flag = false;
			}
			catch(InputMismatchException e) {
				System.out.println("\n" + e + "\nPlease enter correct weight.\n");
				flag = true;
				sc.nextLine();
			}
		} while(flag == true);
	}
	
	public void display() {
		System.out.println("\nVolume of box is: " + super.volume + " cubic meters" + "\nWeight of box is: " + weight + " kgs");
	}
}
