import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Student s = null;
		int option = 0;
		System.out.print("\n\nMENU\n\n1. Make new entry\n2. Display database\n3. Search by roll number and display\n4. Delete Record\n5. Update Record\n6. Exit\n\nEnter your choice: ");
		option = sc.nextInt(); // take user input
		if(option == 6) {
			System.out.println("\nThank you for using our system.");
			sc.close();
			return;
		}
		do {
			switch(option) { // switch user input and call appropriate functions
			case 1:
				int n;
				System.out.print("\nHow many student entries do you wish to make? : ");
				n = sc.nextInt();
				for(int i = 0; i < n; i++) { // call input functions n number of times
					s = new Student();
					s.input();
				}
				break;
			case 2:
				s = new Student();
				if(s.is_empty() == 1) // display error if file is empty
					System.out.println("\nDatabase empty. Please make entries first.");
				else {
					s.display_database();
				}
				break;
			case 3:
				s = new Student();
				if(s.is_empty() == 1)
					System.out.println("\nDatabase empty. Please make entries first.");
				else {
					int roll_no;
					System.out.print("\nEnter the roll number you want to search: ");
					roll_no = sc.nextInt();
					s.display_details(roll_no);
				}
				break;
			case 4:
				s = new Student();
				if(s.is_empty() == 1)
					System.out.println("\nDatabase empty. Please make entries first.");
				else {
					String id;
					System.out.print("\nEnter the ID of the student whose record you want to delete: ");
					id = sc.nextLine();
					System.out.println("ID: " + id);
					s.delete(id);
				}
				break;
			case 5:
				s = new Student();
				if(s.is_empty() == 1)
					System.out.println("\nDatabase empty. Please make entries first.");
				else {
					String id;
					System.out.print("\nEnter the ID of the student whose record you want to update: ");
					sc.nextLine();
					id = sc.nextLine();
					System.out.println("ID: " + id);
					s.update(id);
				}
				break;
			}
			System.out.print("\n\nMENU\n\n1. Make new entry\n2. Display database\n3. Search by roll number and display\n4. Delete Record\n5. Update Record\n6. Exit\n\nEnter your choice: ");
			option = sc.nextInt(); // ask for user choice again
			sc.nextLine();
		} while(option != 6);
		sc.close();
	}

}
