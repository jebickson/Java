import java.util.*;
import java.io.*;
public class Three {
	 public static void main(String[] args) { 
		Scanner input = new Scanner(System.in);
		
		int amtgiven = input.nextInt();
		int billamt = input.nextInt();
		
		int quotient = amtgiven/billamt;
		int remainder = amtgiven % billamt;
		
		System.out.println("Quotient:" + quotient);
		System.out.println("Remainder:" + remainder);
	}
}