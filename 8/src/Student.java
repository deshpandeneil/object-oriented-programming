
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Student {
	// data members
	static int id;
	String name, address, student_id;
	int roll_no; 
	double marks[];
	
	// file paths
	private String FILE_PATH = "/media/neil/New Volume/ubuntu/college/sem 3/oop/lab/assignments/8/src/";
	private String FILE_NAME = "student_database.txt";
	
	Student() {
	}
	
	public void input() {
		Scanner sc = new Scanner(System.in);
		File f = new File(FILE_PATH, FILE_NAME); // file object of specified file path
		if(!f.exists()) { // create file if it does not exist
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else { // else go as per procedure
			try {
				FileWriter fw = new FileWriter(f, true); // file writer opened in append mode
				student_id = "I2K19" + Integer.toString(load_max_id(f)); // auto assign next greatest ID available
				fw.write(student_id + "\t"); // separate fields by a tab space, this tab will later be used to differentiate between different fields
				System.out.print("\nEnter student's name: ");
				fw.write(sc.nextLine() + "\t");
				System.out.print("\nEnter student's address: ");
				fw.write(sc.nextLine() + "\t");
				System.out.print("\nEnter student's roll number: ");
				fw.write(Integer.toString(get_roll_no(f)) + "\t"); // roll number should not be duplicate
				for(int i = 0; i < 5; i++) {
					System.out.print("\nEnter marks of subject " + (i + 1) + ": ");
					fw.write(Double.toString(get_marks()) + "\t"); // marks must be valid
				}
				fw.write("\n"); // enter a new line after current entry
				fw.close(); // close file
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("\nNew entry created."); // success message
			;
		}
	}
	
	private int load_max_id(File f){
		String current_id = "0"; // default ID = 0
		Scanner fr = null;
		try {
			fr = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(fr.hasNextLine()) { // loop through all entries in the file
			String [] details = fr.nextLine().split("\t"); // split entry with tab space as delimiter
			if(Integer.parseInt(details[0].substring(5)) > Integer.parseInt(current_id)) // check last digit of ID for each entry
				current_id = details[0].substring(5); // store max ID in current ID
		}
		return (Integer.parseInt(current_id) + 1); // return next greatest available ID
	}
	
	private int get_roll_no(File f) {
		int roll_no = 0;
		Scanner sc = new Scanner(System.in);
		Scanner fr = null;
		do { // loop till valid roll number is not entered
			try {
				roll_no = sc.nextInt();
				if(roll_no <= 23100 || roll_no > 23185) { // roll no should be in limits
					System.out.print("\nPlease enter roll number within correct range (23101 to 23185).\nEnter roll number again: ");
					continue;
				}
				else { // search if roll number already exists in file
					try {
						fr = new Scanner(f);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					boolean flag = false;
					while(fr.hasNextLine()) {
						String [] details = fr.nextLine().split("\t"); // split entry using tab space
						if(Integer.parseInt(details[3]) == roll_no) { // compare roll numbers
							System.out.print("\nThis roll number is already assigned to another student.\nPlease enter another roll number: ");
							flag = true;
							break;
						}
						else {
							flag = false;
							continue;
						} // flag variables set as per requirement
					}
					if(flag == true)
						continue;
					else
						break;
				}
			}
			catch(InputMismatchException e) {
				System.out.print("\nPlease enter correct roll number.\nEnter roll number again: ");
				sc.nextLine();
				continue;
			}
		}while(true);
		;
		return roll_no;
	}
	
	private double get_marks() {
		Scanner sc = new Scanner(System.in);
		double marks = 0;
		boolean flag = false;
		do { // loop till correct marks are not entered
			try {
				marks = sc.nextDouble();
				if(marks < 0 || marks > 100) { // within limits
					System.out.print("\nPlease enter marks in the correct range (0 to 100).\nEnter marks again: ");
					flag = true;
					continue;
				}
				else
					flag = false;
			}
			catch(InputMismatchException e){
				System.out.print("\n" + e + ". Please enter correct marks.\nEnter marks again: ");
				sc.nextLine();
				flag = true; // flag variables set to re iterate do while loop
			}
		} while(flag == true);
		;
		return marks;
	}
	
	public void display_details(int roll_no) { // search function
		boolean flag = false;
		File f = new File(FILE_PATH, FILE_NAME); // open file specified in path
		Scanner fr = null;
		try {
			fr = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(fr.hasNextLine()) {
			String [] details = fr.nextLine().split("\t"); // split entry with tab space
			if(Integer.parseInt(details[3]) == roll_no) { // compare roll numbers
				for(int i = 0; i < details.length; i++) {
					if(i != 2)
						System.out.print(details[i] + "\t\t"); // display details if found
				}
				flag = true;
				break;
			}
		}
		if(!flag)
			System.out.println("\nNo student with the roll number " + roll_no + " found\n");
	}
	
	public void display_database() {
		File f = new File(FILE_PATH, FILE_NAME);
		try {
			Scanner fr = new Scanner(f);
			System.out.print("\n\nSTUDENT DATABASE\n\n");
			System.out.print("\nID\t\tName\t\tRoll No.\t\tMarks\n\n");
			while(fr.hasNextLine()) {
				String [] details = fr.nextLine().split("\t"); // split into array
				for(int i = 0; i < details.length; i++) {
					if(i != 2)
						System.out.print(details[i] + "\t\t"); // display contents in proper format
				}
				System.out.print("\n");
			}
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int is_empty() { // utility function
		File f = new File(FILE_PATH, FILE_NAME);
		try {
			Scanner fr = new Scanner(f);
			if(!fr.hasNextLine()) {
				fr.close();
				return 1;
			} else {
				fr.close();
				return 0;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public void delete(String id) {
		File f = new File(FILE_PATH, FILE_NAME);
		StringBuilder sb = new StringBuilder(); // string builder to store file contents
	    try {
	    	Scanner fs = new Scanner(f);
	        String current_line;
	        while(fs.hasNextLine()){
	            current_line = fs.nextLine();
	            String [] details = current_line.split("\t"); // split entry into array
	            if(!details[0].equals(id)){
	            	sb.append(current_line + "\n"); // if not at entry to be deleted append string to string builder object
	            }
	            
	        }
	        fs.close();
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			FileWriter fw = new FileWriter(f); // open file using writer in overwrite mode
			fw.write(sb.toString()); // replace contents with builder contents
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void update(String id) {
		File f = new File(FILE_PATH, FILE_NAME);
		StringBuilder sb = new StringBuilder();
	    try {
	    	Scanner fs = new Scanner(f);
	    	Scanner sc = new Scanner(System.in);
	        String current_line, updated_line = "";
	        while(fs.hasNextLine()){
	            current_line = fs.nextLine();
	            String [] details = current_line.split("\t"); // split entry into array
	            if(details[0].equals(id)){ // replace only if ID matches
	            	System.out.print("\nEnter student's name: ");
					details[1] = "\t" + sc.nextLine() + "\t"; // write new details in array itself
					System.out.print("\nEnter student's address: ");
					details[2] = sc.nextLine() + "\t";
					for(int j = 0; j < 5; j++) {
						System.out.print("\nEnter marks of subject " + (j + 1) + ": ");
						details[4 + j] = "\t" + Double.toString(get_marks());
					}
					for(int i = 0; i < details.length; i++) {
						updated_line += details[i]; // append array contents to string
					}
					sb.append(updated_line + "\n"); // append string to builder object
	            }
	            else
	            	sb.append(current_line + "\n");
	        }
	        ;
	    } catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			FileWriter fw = new FileWriter(f); // open file with overwrite mode on
			fw.write(sb.toString()); // overwrite contents with builder contents
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
