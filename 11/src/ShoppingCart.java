
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	//List of items
	List<Item> items;
	
	public ShoppingCart(){
		this.items=new ArrayList<Item>();
	}
	
	public void addItem(Item item){
		this.items.add(item);
	}
	
	public void removeItem(String name){
		for(int i = 0; i < items.size(); i++) {
			if(items.get(i).getName().equals(name)) {
				this.items.remove(i);
				System.out.println("\nItem removed.");
				return;
			}
		}
		System.out.println("\nNo such item with the entered details found.");
	}
	
	public int calculateTotal(){
		int sum = 0;
		for(Item item : items){
			sum += item.getPrice();
		}
		return sum;
	}
	
	public void pay(PaymentStrategy paymentMethod){
		int amount = calculateTotal();
		paymentMethod.pay(amount);
		items.clear();
	}
	
	public void display() {
		System.out.print("\n\nYOUR CART\n\nName\t\t\tUPC\t\t\tPrice\n");
		for(int i = 0; i < items.size(); i++) {
			System.out.print("\n" + items.get(i).getName() + "\t\t\t" + items.get(i).getUpcCode() + "\t\t\t₹ " + items.get(i).getPrice());
		}
	}
}
