package assignment_11;

public class PaypalStrategy implements PaymentStrategy {
	private String emailId;
	private String password;

	public PaypalStrategy(String email, String pwd){
		this.emailId=email;
		this.password=pwd;
	}

	@Override
	public void pay(int amount) {
//		System.out.println("\n₹ " + amount + " paid using Paypal.");
	}
}
