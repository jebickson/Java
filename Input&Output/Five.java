import java.io.*;
import java.util.*;
public class Five{
	 public static void main(String[] args) { 
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int m = input.nextInt();
		
		int ans = n * (m - 1) + m *(n - 1);
		
		System.out.println(ans);
	}
}