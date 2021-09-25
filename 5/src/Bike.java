import java.util.Scanner;

public class Bike implements Functionalities {
	int current_gear, current_speed;
	
	public Bike() {
		current_gear = 1;
		current_speed = 0;
	}

	public void gear_change(int g) {
		// TODO Auto-generated method stub
		// gear validations
			if(g > 5) // gear cannot be greater than 5
				System.out.println("\nCannot increase the gear above 5\n"); 
			else
				current_gear = g;
			if(current_gear < 1) // gear cannot be less than 1
				System.out.println("\nCannot decrease the gear any further than 1\n");
			else
				current_gear = g;
		}

	public void apply_brakes() {
		// TODO Auto-generated method stub
		if(current_speed == 0 && current_gear == 1)
			System.out.println("\nYou have come to a halt\n");
		
		// decrement speed by 5 every time and set gear accordingly
		
		else if((0 <= current_speed && current_speed <= 10)) {
			current_gear = 1;
			current_speed -= 5;
		}
		else if((10 < current_speed && current_speed <= 20)) {
			current_gear = 2;
			current_speed -= 5;
		}
		else if((20 < current_speed && current_speed <= 30)) {
			current_gear = 3;
			current_speed -= 5;
		}
		else if((30 < current_speed && current_speed <= 40)) {
			current_gear = 4;
			current_speed -= 5;
		} else
			current_speed -= 5;
	}

	public void speed_up(int s) {
		// TODO Auto-generated method stub
		
		// every gear has its speed range
		// gear needs to be incremented before going past the speed limit
		
		if(s > 10 && current_gear == 1)
			System.out.println("\nPlease change gears before speeding up\n");
		else if(s > 20 && current_gear == 2)
			System.out.println("\nPlease change gears before speeding up\n");
		else if(s > 30 && current_gear == 3)
			System.out.println("\nPlease change gears before speeding up\n");
		else if(s > 40 && current_gear == 4)
			System.out.println("\nPlease change gears before speeding up\n");
		else if(s > 50 && current_gear == 5)
			System.out.println("\nYou cannot speed up more\n"); // max speed is set to 50
		else
			current_speed = s;
	}
	
	public void display() {
		
		// displays current gear and speed
		
		System.out.println("\nGear: " + current_gear + " Speed: " + current_speed + "\n");
	}
}
