package Input&Output;

import java.util.*;
import java.io.*;

public class Two {
    public static void main(String[] args) { 
		
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		int x = (n*(n + 1)*(2 * n + 1))/6;
		
		System.out.println(x); 
	}
}
