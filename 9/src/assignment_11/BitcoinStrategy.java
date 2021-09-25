package assignment_11;

public class BitcoinStrategy implements PaymentStrategy {
	String emailId, password, accNum;
	
	public BitcoinStrategy(String emailId, String password, String accNum){
		this.emailId = emailId;
		this.password = password;
		this.accNum = accNum;
	}

	@Override
	public void pay(int amount) {
		// TODO Auto-generated method stub
//		System.out.println("\n₹ " +amount +" paid in bitcoins.");
	}

}
