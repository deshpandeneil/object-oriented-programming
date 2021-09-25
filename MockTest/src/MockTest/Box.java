package MockTest;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Box {
	double width, height, depth, volume;
	
	Box(){
		input(); // calls input function of this class
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		do {
			try {
				System.out.print("\nEnter width (in meters): ");
				width = sc.nextDouble();
				System.out.print("\nEnter height (in meters): ");
				height = sc.nextDouble();
				System.out.print("\nEnter depth (in meters): ");
				depth = sc.nextDouble();
				flag = false;
			}
			catch(InputMismatchException e) {
				System.out.println("\n" + e + "\nPlease enter correct input for dimensions from start.\n");
				flag = true;
				sc.nextLine();
			}
		} while(flag == true);
	}
	
	// this function takes an object of BoxWeight and sets its parameters
	public void calculate_volume(BoxWeight boxWeight) {
		volume = boxWeight.width * boxWeight.height * boxWeight.depth;
	}
}
