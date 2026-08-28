import java.util.*;
import java.io.*;
public class Eight {
	 public static void main(String[] args) { 
		Scanner input = new Scanner(System.in);
		
		int length = input.nextInt();
		int width = input.nextInt();
		int height = input.nextInt();
		
		int result = 2 *(length * width + length * height + height * width);
		
		System.out.println(result);
	}
}