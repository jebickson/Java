import java.util.*;
import java.io.*;
public class Seven {
	 public static void main(String[] args) { 
		Scanner input = new Scanner(System.in);
		
		float val1 = input.nextFloat();
		float val2 = input.nextFloat();
		
		float result = val1 * val2;
		
		System.out.println(String.format("%.4f",result));
	}
}