import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		
		int menu_option = 0, post_option = 0, programmer_count = 0, team_lead_count = 0, proj_manager_count = 0, asst_proj_manager_count = 0; // counters and option variables
		Scanner sc = new Scanner(System.in); // scanner object
		
		Programmer[] programmers = new Programmer[10]; // array of programmer class instances
		TeamLead[] team_leads = new TeamLead[10]; // array of team lead class instances
		ProjectManager[] proj_managers = new ProjectManager[10]; // array of project manager class instances
		AssistantProjectManager[] asst_proj_managers = new AssistantProjectManager[10]; // array of assistant project manager class instances
		
		do {
			boolean menu_flag = false; // flag for validations
			do {// displaying menu
				System.out.println("\n\nMenu\n\n1. Add Employee\n2. Display all employee's payslip\n3. Search by employee ID\n4. Exit");
				System.out.print("Enter the serial number of the operation you want to perform: ");
				try { // executes following code block
					menu_option = sc.nextInt();
					menu_flag = false;
					break;
				} catch(InputMismatchException e) { // if scanner instance throws an error, this code block will handle it
					sc.nextLine();
					System.out.println("\nPlease enter a valid integer.");
					menu_flag = true;
					continue;
				}
			} while(menu_flag == true);
			
			if(menu_option == 4) {
				break; // exit
			}
			
			switch(menu_option) {
			case 1:
				boolean post_flag = false; // flag for validations
				do { // displaying sub-menu options
					System.out.println("\n\nAvailable employee posts\n\n1. Programmer\n2. Team Lead\n3. Project Manager\n4. Assistant Project Manager");
					System.out.print("Enter the serial number of employee's post: ");
					try { // executes following code block
						post_option = sc.nextInt();
						post_flag = false;
						break;
					} catch(InputMismatchException e) { // if scanner instance throws an error, this code block will handle it
						sc.nextLine();
						System.out.println("\nPlease enter a valid integer.");
						post_flag = true;
						continue;
					}
				} while(post_flag == true);
				// call constructor of selected post class, call read function and update counter of respective arrays
				switch(post_option) {
				case 1:
					programmers[programmer_count] = new Programmer();
					programmers[programmer_count].read_bp();
					programmer_count++;
					break;
				case 2:
					team_leads[team_lead_count] = new TeamLead();
					team_leads[team_lead_count].read_bp();
					team_lead_count++;
					break;
				case 3:
					proj_managers[proj_manager_count] = new ProjectManager();
					proj_managers[proj_manager_count].read_bp();
					proj_manager_count++;
					break;
				case 4:
					asst_proj_managers[asst_proj_manager_count] = new AssistantProjectManager();
					asst_proj_managers[asst_proj_manager_count].read_bp();
					asst_proj_manager_count++;
					break;
				default:
					System.out.println("\nPlease select appropriate choice.");
					break;
				}
				break;
			case 2:
				// display all members of arrays which have at least one entry using for loop
				if(programmer_count > 0) {
					for(int i = 0; i < programmer_count; i++) {
						programmers[programmer_count - 1].display_payslip(programmers[i]);
					}
				}
				if(team_lead_count > 0) {
					for(int i = 0; i < team_lead_count; i++) {
						team_leads[team_lead_count - 1].display_payslip(team_leads[i]);
					}
				}
				if(proj_manager_count > 0) {
					for(int i = 0; i < proj_manager_count; i++) {
						proj_managers[proj_manager_count - 1].display_payslip(proj_managers[i]);
					}
				}
				if(asst_proj_manager_count > 0) {
					for(int i = 0; i < asst_proj_manager_count; i++) {
						asst_proj_managers[asst_proj_manager_count - 1].display_payslip(asst_proj_managers[i]);
					}
				}
				break;
			case 3:
				String post;
				int id;
				System.out.print("Enter the post of the employee you want to search: ");
				sc.nextLine();
				post = sc.nextLine();
				System.out.print("Enter the ID of the employee you want to search: ");
				id = sc.nextInt();
				// call search function of respective post if the array of instances of that class has at least one object
				if(post.equals("programmer") && programmer_count > 0) {
					programmers[programmer_count - 1].search(programmers, programmer_count, id);
				}
				else if(post.equals("team lead") && team_lead_count > 0) {
					team_leads[team_lead_count - 1].search(team_leads, team_lead_count, id);
				}
				else if(post.equals("project manager") && proj_manager_count > 0) {
					proj_managers[proj_manager_count - 1].search(proj_managers, asst_proj_manager_count, id);
				}
				else if(post.equals("assistant project manager") && asst_proj_manager_count > 0) {
					asst_proj_managers[asst_proj_manager_count - 1].search(asst_proj_managers, asst_proj_manager_count, id);
				}
				else {
					System.out.println("No employee with the given post and ID found.");
				}
				break;
			default:
				System.out.println("\nPlease select appropriate option.");
				break;
			}
		} while(menu_option != 4);
	}

}
