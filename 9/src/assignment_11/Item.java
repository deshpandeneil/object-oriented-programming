package assignment_11;

public class Item {

	private String upcCode, name;
	private int price;
	
	public Item(String upc, String name, int cost){
		this.upcCode=upc;
		this.setName(name);
		this.price=cost;
	}

	public String getUpcCode() {
		return upcCode;
	}

	public int getPrice() {
		return price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
