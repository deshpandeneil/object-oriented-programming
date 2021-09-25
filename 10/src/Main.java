import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	int option;
    	Scanner sc = new Scanner(System.in);
    	do {
    		System.out.print("\n\nMENU\n\n1. Build Small Car\n2. Build Sedan Car\n3. Build Luxury Car\n4. Exit\n\nEnter your choice: ");
    		option = sc.nextInt();
    		switch(option) {
    		case 1:
    			System.out.println(CarFactory.buildCar(CarType.SMALL));
    			break;
    		case 2:
    			System.out.println(CarFactory.buildCar(CarType.SEDAN));
    			break;
    		case 3:
    			System.out.println(CarFactory.buildCar(CarType.LUXURY));
    			break;
    		case 4:
    			return;
			default:
				break;
    		}
    	} while(true);
	}

}
