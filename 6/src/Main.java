
public class Main {


	public static void divide(int b, int c) throws ArithmeticException{
		try{
			System.out.println("Division of " + b + " and " + c + " is: " + (b / c));
		}
		catch(ArithmeticException e){
			throw new ArithmeticException();
		}
	}

	public static void display_array(String args[]){
		try{
			System.out.println(args[2]);
		}
		catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Array index exception: " + e);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			int a = args.length, b, c;
			System.out.println("a = " + a);

			for(int i = 0; i < args.length; i++){
				System.out.println("Arguments are: " + args[i]);
			}

			b = Integer.parseInt(args[0]);
			c = Integer.parseInt(args[1]);

			divide(b, c);

			display_array(args);
			
		}
		catch(NumberFormatException e){
			System.out.println("Number format error: " + e);
		}
	}

}
