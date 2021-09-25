import java.util.InputMismatchException;
import java.util.Scanner;

public class TeamLead extends Employee { // inherit from class employee
	// declaring data members
	String post;
	double bp, da, hra, pf, club_fund, gross_salary, net_salary;
	
	TeamLead(){
		post = "Team Lead"; // creating an instance assigns the post
	}
	
	public void read_bp() {
		Scanner sc = new Scanner(System.in);
		read(); // calling read method from parent class
		boolean bp_flag = false; // flag for validations
		do {
			boolean type_flag = false; // flag for validations
			do {
				System.out.print("Enter the basic pay amount (minimum ₹40k): ");
				try { // executes following code block
					bp = sc.nextDouble();
					type_flag = false; // set flag to break from loop
					break;
				} catch(InputMismatchException e) { // if scanner instance throws an error, this code block will handle it
					sc.nextLine();
					System.out.println("\nPlease enter a valid number.");
					type_flag = true; // set flag for next iteration
					continue;
				}
			} while(type_flag == true);
			if(bp < 40000.0 || bp > 50000.0) {
				bp_flag = true; // set flag for next iteration
				System.out.println("Please enter the minimum reqired amount.");
				continue;
			} else {
				bp_flag = false; // set flag to break from loop
				break;
			}
		}while(bp_flag = true);
		// calculate other data member values using bp
		da = 0.97 * bp;
		hra = 0.1 * bp;
		pf = 0.12 * bp;
		club_fund = 0.001 * bp;
		gross_salary = bp + da + hra;
		net_salary = gross_salary - pf - club_fund;
	}
	// function to search a employee by ID
	public void search(TeamLead[] team_leads,int team_lead_count , int id) {
		boolean found = false;
		for(int i = 0; i < team_lead_count; i++) { // pass through all elements of array
			if(team_leads[i].id == id) {
				found = true;
				display_payslip(team_leads[i]);
			}
		}
		if(found == false) {
			System.out.println("\nNo team leader with employee ID " + id + " found.");
		}
	}
	
	public void display_payslip(TeamLead tl) {
		display();
		System.out.println("\t=====================================================");
		System.out.println("\n\tEmployee post: \t\t\t\t" + tl.post);
		System.out.println("\n\tGross salary: \t\t\t\t₹ " + tl.gross_salary);
		System.out.println("\tNet salary: \t\t\t\t₹ " + tl.net_salary);
		System.out.println("\t=====================================================");
	}
}
