package StudentDatabase;

public class Result extends AuditCourse {
	double percent;
	
	Result(){
		calculate_result();
	}
	
	public void calculate_result() {
		percent = (sub_1_mrks + sub_2_mrks + sub_3_mrks + sub_4_mrks + sub_5_mrks) * 100 / 500;
	}
	
	public void display_details() {
		System.out.println("\n\n\n\t\t=================================================================\n");
		System.out.println("\n\t\tName: " + student_name + "\t\t\t\tRoll No: " + student_roll_no);
		System.out.println("\n\t\t=================================================================\n");
		System.out.println("\n\t\tAudit course marks: " + audit_course_mrks + "\t\t\tPercentage: " + percent);
		System.out.println("\n\t\t=================================================================\n\n\n");
	}
}
