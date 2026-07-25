// String
// Example 2: Read a String from the User

package Java;
import java.util.Scanner;

public class Example2s {
    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Welcome"+name);

        sc.close();

    }
}
