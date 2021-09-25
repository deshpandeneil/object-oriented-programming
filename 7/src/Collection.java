import java.util.*;
import java.lang.*;
import java.io.*;

public class Collection {

	static int count;
	
	public void string_operation() {
		count = 0; // initialize count to 0 every time this function is called
		int n;
		Scanner sc = new Scanner(System.in);
		LinkedList<String> string_list = new LinkedList<String>(); // generic type linked list object
		System.out.print("\nHow many strings do you want to enter?: ");
		n = sc.nextInt(); // store linked list size in n
		sc.nextLine();
		for(int i = 0; i < n; i++) { // loop n times and add user input to list
			System.out.print("\nEnter string " + (i + 1) + ": ");
			string_list.add(sc.nextLine());
		}
		System.out.print("\n");
		for(int j = 0; j < n; j++) { // loop through all indexes and call is_palndrome() function for all strings in list
			is_palindrome((String)string_list.get(j));
		}
		System.out.println("\nResult\n\nNumber of palindromes: " + count + "\nNumber of non-palindrome strings: " + (n - count));
	}
	
	public void integer_operation() {
		count = 0; // initialize count to 0 every time function is called
		int n, option;
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> integer_list = new ArrayList<Integer>(); // generic type array list object
		System.out.print("\nHow many integers do you want to enter?: ");
		n = sc.nextInt(); // store array size in n
		for(int i = 0; i < n; i++) { // loop n times and add element to array list
			System.out.print("\nEnter integer " + (i + 1) + ": ");
			integer_list.add(sc.nextInt());
		}
		System.out.print("\nInteger Operation Menu\n\n1. Check if odd or even\n2. Check if prime\n\nEnter your choice: "); // display integer menu
		option = sc.nextInt();
		Iterator<Integer> integer_iterator = integer_list.iterator(); // iterator object to access array elements
		switch(option) {
		// call appropriate function according to user input
		case 1:
			for(int j = 0; j < n; j++) { // loop n times
				is_odd((int)integer_iterator.next()); // call is_odd() function and pass elements to it using iterator object
			}
			System.out.println("\nResult\n\nNumber of odd numbers: " + count + "\nNumber of even numbers: " + (n - count));
			break;
		case 2:
			for(int k = 0; k < n; k++) { // loop n times
				is_prime((int)integer_iterator.next()); // call is_prime() function and pass elements to it using iterator object
			}
			System.out.println("\nResult\n\nNumber of prime numbers: " + count + "\nNumber of non-prime numbers: " + (n - count));
			break;
		default:
			System.out.println("\nPlease enter correct choice.\n");
			break;
		}
	}
	
	public void is_palindrome(String s) {
		StringBuilder s1 = new StringBuilder(s); // string builder object
		if(s.equals(s1.reverse().toString())) { // if reverse of string is same as string
			System.out.println(s + " is a palindrome."); // display message
			count++; // increment count
		}
		else
			System.out.println(s + " is not a palindrome.");
	}

	public void is_odd(int n) {
		if(n % 2 == 0) // if remainder after dividing by 2 is 0
			System.out.println(n + " is even."); // display message
		else {
			System.out.println(n + " is odd.");
			count++; // increment count
		}
	}

	public void is_prime(int n) {
		boolean flag = false;
        if (n <= 1) // if integer is < 1 its not prime
        	System.out.println( n + " is not prime.");
        else {
	        for (int i = 2; i < n / 2; i++) { // loop through 2 to n
	            if(n % i == 0) { // if n divided by loop counter leaves remainder as 0
	            	flag = false; // not prime
	                break; // exit for loop
	            }
	            else {
	            	flag = true; // flag to indicate prime number
	            	continue; // divide by next number
	            }
	        }
	        if(flag) { // if flag is set
	        	System.out.println( n + " is prime.");
	        	count++; // increment count
	        }
	        else
	        	System.out.println( n + " is not prime.");
        }
	}

}
