package Input&Output;

import java.util.*;
import java.io.*;

public class OneNotTwo {
    public static void main(String[] args) { 
		Scanner input = new Scanner(System.in);
		
		float spacenum;
		int num, digit;
		spacenum = input.nextFloat();
		
		num = (int) spacenum;
		digit = num % 10;
		
		System.out.println(digit);
	}
}
