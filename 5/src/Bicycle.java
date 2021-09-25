import java.util.Scanner;

public class Bicycle implements Functionalities {
	int current_gear, current_speed;
	
	public Bicycle() {
		current_gear = 1;
		current_speed = 0;
	}

	public void gear_change(int g) {
		// TODO Auto-generated method stub
		// gear validations
			if(g > 18) // gear cannot be greater than 18
				System.out.println("\nCannot increase the gear above 18\n");
			else if(g < 1) // gear cannot be less than 1
				System.out.println("\nCannot decrease the gear any further than 1\n");
			else
				current_gear = g;
		}

	public void apply_brakes() {
		// TODO Auto-generated method stub
		if(current_speed == 0 && current_gear == 1)
			System.out.println("\nYou have come to a halt\n");
		
		// decrement speed by 5 every time and set gear accordingly
		
		else if((0 <= current_speed && current_speed <= 5)) {
			current_gear = 1;
			current_speed -= 3;
		}
		else if((5 < current_speed && current_speed <= 10)) {
			current_gear = 2;
			current_speed -= 3;
		}
		else if((10 < current_speed && current_speed <= 15)) {
			current_gear = 3;
			current_speed -= 3;
		}
		else if((15 < current_speed && current_speed <= 20)) {
			current_gear = 4;
			current_speed -= 3;
		} else
			current_speed -= 3;
	}

	public void speed_up(int s) {
		// TODO Auto-generated method stub
		
		// max speed set to 20
		
		if(s > 20)
			System.out.println("\nYou cannot speed up more\n");
		else
			current_speed = s;
	}
	
	public void display() {
		
		// displays current gear and speed
		
		System.out.println("\nGear: " + current_gear + " Speed: " + current_speed + "\n");
	}
}
