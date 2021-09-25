package StudentDatabase;
import java.util.Scanner;

public class Marks extends Student {
	double sub_1_mrks, sub_2_mrks, sub_3_mrks, sub_4_mrks, sub_5_mrks, prac_1_mrks, prac_2_mrks;
	
	Marks(){
		input_mrks();
	}
	
	public void input_mrks() {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter marks of subject 1: ");
		sub_1_mrks = sc.nextDouble();
		System.out.print("Enter marks of subject 2: ");
		sub_2_mrks = sc.nextDouble();
		System.out.print("Enter marks of subject 3: ");
		sub_3_mrks = sc.nextDouble();
		System.out.print("Enter marks of subject 4: ");
		sub_4_mrks = sc.nextDouble();
		System.out.print("Enter marks of subject 5: ");
		sub_5_mrks = sc.nextDouble();
		System.out.print("Enter marks of practical subject 1: ");
		prac_1_mrks = sc.nextDouble();
		System.out.print("Enter marks of practical subject 2: ");
		prac_2_mrks = sc.nextDouble();
	}
}
