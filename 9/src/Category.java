
import java.util.LinkedList;
import java.util.Scanner;

public class Category {
	String category_name, category_description;
	
	Category(){ // initialize data members
		category_name = "";
		category_description = "";
	}
	
	Category(LinkedList<Category> categoryList){
		input(categoryList);
	}
	
	private void input(LinkedList<Category> categoryList) {
		Category c = new Category();
		Scanner sc = new Scanner(System.in);
		boolean exists = false;
		System.out.print("\nEnter product's category: "); // ask for category name
		sc.next();
		c.category_name = sc.nextLine();
		for(int i = 0; i < categoryList.size(); i++) { // check if category exists
			if(categoryList.get(i).category_name.equals(c.category_name)) {
				exists = true;
				break;
			} else {
				exists = false;
				continue;
			}
		}
		if(!exists) { // if not ask for description
			System.out.print("\nThis is a new category, please enter a description for this category: ");
			category_description = sc.nextLine();
			categoryList.add(c);
		}
	}
}
