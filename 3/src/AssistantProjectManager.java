import java.util.InputMismatchException;
import java.util.Scanner;

public class AssistantProjectManager extends Employee { // inherit from employee class
	// data members
	String post;
	double bp, da, hra, pf, club_fund, gross_salary, net_salary;
	
	AssistantProjectManager(){
		post = "Assistant Project Manager"; // set post
	}
	
	public void read_bp() {
		Scanner sc = new Scanner(System.in);
		read();
		boolean bp_flag = false;
		do {
			boolean type_flag = false;
			do {
				System.out.print("Enter the basic pay amount (minimum ₹50k): ");
				try {
					bp = sc.nextDouble();
					type_flag = false;
					break;
				} catch(InputMismatchException e) {
					sc.nextLine();
					System.out.println("\nPlease enter a valid number.");
					type_flag = true;
					continue;
				}
			} while(type_flag == true);
			if(bp < 50000.0 || bp > 60000.0) {
				bp_flag = true;
				System.out.println("Please enter the minimum reqired amount.");
				continue;
			} else {
				bp_flag = false;
				break;
			}
		}while(bp_flag = true);
		
		da = 0.97 * bp;
		hra = 0.1 * bp;
		pf = 0.12 * bp;
		club_fund = 0.001 * bp;
		gross_salary = bp + da + hra;
		net_salary = gross_salary - pf - club_fund;
	}
	
	public void search(AssistantProjectManager[] asst_proj_managers,int asst_proj_manager_count , int id) {
		boolean found = false;
		for(int i = 0; i < asst_proj_manager_count; i++) {
			if(asst_proj_managers[i].id == id) {
				found = true;
				display_payslip(asst_proj_managers[i]);
			}
		}
		if(found == false) {
			System.out.println("\nNo assistant project manager with employee ID " + id + " found.");
		}
	}
	
	public void display_payslip(AssistantProjectManager apm) {
		display();
		System.out.println("\t=====================================================");
		System.out.println("\n\tEmployee post: \t\t\t\t" + apm.post);
		System.out.println("\n\tGross salary: \t\t\t\t₹ " + apm.gross_salary);
		System.out.println("\tNet salary: \t\t\t\t₹ " + apm.net_salary);
		System.out.println("\t=====================================================");
	}
}
