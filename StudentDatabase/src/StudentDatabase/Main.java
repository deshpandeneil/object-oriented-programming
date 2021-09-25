package StudentDatabase;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int n;
		int student_count = 0;
		System.out.print("Enter the number of students in your class: ");
		n = sc.nextInt();
		Result[] r = new Result[n];
		
		int option = 0;
		System.out.print("\nMENU\n\n1. Insert data\n2. Display result\n\nEnter the operation you want to do: ");
		option = sc.nextInt();
		
		do {
			switch(option) {
			case 1:
				r[student_count] = new Result();
				student_count++;
				break;
			case 2:
				int roll_no;
				System.out.print("Enter the student's roll number: ");
				roll_no = sc.nextInt();
				r[roll_no - 1].display_details();
				break;
			case 3:
				break;
			default:
				System.out.println("\nPlease choose a correct option.\n");	
			}
			System.out.print("\nMENU\n\n1. Insert data\n2. Display result\n\nEnter the operation you want to do: ");
			option = sc.nextInt();
		} while(option != 3);
	}

}
