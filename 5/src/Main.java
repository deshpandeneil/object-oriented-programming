import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int vehicle_option;
		int option;
		Functionalities f; // reference variable of interface
		System.out.print("\nVEHICLES\n\n1. Car\n2. Bike\n3. Bicycle\n4. Exit\n\nSelect your vehicle: ");
		vehicle_option = sc.nextInt(); // variable for vahicle choice
		do {
			switch(vehicle_option) {
			case 1:
				f = new Car(); // reference variable points to car object
				
				System.out.print("\nCAR\n\n1. Change Gears\n2. Speed Up\n3. Slow Down\n4. Exit\n\nEnter your choice: ");
				option = sc.nextInt(); // variable for menu option
				do {
					switch(option) {
					case 1:
						int g; // user choice for gear
						System.out.print("\nEnter the gear you want to change to: ");
						g = sc.nextInt();
						f.gear_change(g); // call the method
						f.display();
						break;
					case 2:
						int s; // use choice for speed
						System.out.print("\nEnter the speed you want to change to: ");
						s = sc.nextInt();
						f.speed_up(s); // call method
						f.display();
						break;
					case 3:
						f.apply_brakes(); // call method to apply brakes
						f.display();
						break;
					case 4: // do nothing
						break;
					}
					System.out.print("1. Change Gears\n2. Speed Up\n3. Slow Down\n4. Exit\n\nEnter your choice: ");
					option = sc.nextInt();
				} while(option != 4); // keep looping till user does not select exit
				break;
				
			case 2:
				f = new Bike(); // reference variable points to bike object
				System.out.print("\nCAR\n\n1. Change Gears\n2. Speed Up\n3. Slow Down\n4. Exit\n\nEnter your choice: ");
				option = sc.nextInt();
				do {
					switch(option) {
					case 1:
						int g;
						System.out.print("\nEnter the gear you want to change to: ");
						g = sc.nextInt();
						f.gear_change(g);
						f.display();
						break;
					case 2:
						int s;
						System.out.print("\nEnter the speed you want to change to: ");
						s = sc.nextInt();
						f.speed_up(s);
						f.display();
						break;
					case 3:
						f.apply_brakes();
						f.display();
						break;
					case 4:
						// do nothing
						break;
					}
					System.out.print("1. Change Gears\n2. Speed Up\n3. Slow Down\n4. Exit\n\nEnter your choice: ");
					option = sc.nextInt();
				} while(option != 4); // keep looping till user does not select exit
				break;
				
			case 3: 
				f = new Bicycle(); // reference variable points to bicycle object
				System.out.print("\nCAR\n\n1. Change Gears\n2. Speed Up\n3. Slow Down\n4. Exit\n\nEnter your choice: ");
				option = sc.nextInt();
				do {
					switch(option) {
					case 1:
						int g;
						System.out.print("\nEnter the gear you want to change to: ");
						g = sc.nextInt();
						f.gear_change(g);
						f.display();
						break;
					case 2:
						int s;
						System.out.print("\nEnter the speed you want to change to: ");
						s = sc.nextInt();
						f.speed_up(s);
						f.display();
						break;
					case 3:
						f.apply_brakes();
						f.display();
						break;
					case 4:
						// do nothing
						break;
					}
					System.out.print("1. Change Gears\n2. Speed Up\n3. Slow Down\n4. Exit\n\nEnter your choice: ");
					option = sc.nextInt();
				} while(option != 4); // keep looping till user does not select exit
				break;
			}
			System.out.print("\nVEHICLES\n\n1. Car\n2. Bike\n3. Bicycle\n\nSelect your vehicle: ");
			vehicle_option = sc.nextInt(); // variable for vahicle choice
		} while(vehicle_option != 4); // keep looping till user does not select exit
	}

}
