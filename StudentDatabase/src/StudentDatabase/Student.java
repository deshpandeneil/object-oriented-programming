package StudentDatabase;
import java.util.Scanner;

public class Student {
	String student_name;
	int student_roll_no;
	
	Student(){
		input_student_details();
	}
	
	public void input_student_details() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter student's name: ");
		student_name = sc.nextLine();
		System.out.print("Enter student's roll number: ");
		student_roll_no = sc.nextInt();
	}
}
