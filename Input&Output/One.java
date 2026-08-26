import java.io.*;
import java.util.*;
public class One {
	 public static void main(String[] args) { 
		Scanner input = new Scanner(System.in);
		
		int alvqntoffood = input.nextInt();  // total food
		int messcnt = input.nextInt(); //number of messcnt
		
		int share = alvqntoffood / messcnt; // equal share
		int remain = alvqntoffood % messcnt; // remaining
		
		System.out.println(share +" "+ remain);
	}
}