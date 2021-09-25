package StudentDatabase;
import java.util.Scanner;

public class AuditCourse extends Marks {
	String audit_course_name;
	double audit_course_mrks;
	
	AuditCourse(){
		input_audit_course_details();
	}
	
	public void input_audit_course_details() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter audit course name: ");
		audit_course_name = sc.nextLine();
		System.out.print("Enter audit course marks: ");
		audit_course_mrks = sc.nextDouble();
	}
}
