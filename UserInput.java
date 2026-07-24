package Java;
import java.util.Scanner; // import - Brings a library into your program.
// java.util - The Java utility package.
// Scanner - A class used to read input from the keyboard

public class UserInput { // public - The class can be accessed from anywhere.
    // class - Defines a class in java
    // Main - The name of the class.
    public static void main(String[] args){ // Public - The method is accessible by the JVM
        // Static - Can run without creating an object.
        // Void - This method does not return any value.
        // main - TThe starting point of every java program.
        // String[] args - Stores command-line arguments.

        Scanner sc = new Scanner(System.in); // The data type (Scanner class).
        // sc - The object name.
        // new -Create a new object.
        // Scanner( System.in) - Creates a Scanner object that reads input from the Keyboard.
        // System.in - Standard input (Keyboard).

        System.out.println("Enter your name:"); // System - java's build-in system class.
        // out - Standard output (Screen).
        // print() - Display text without moving to the next line.
        String name = sc.nextLine(); 
        // String - Data type.
        // name - Variable name.
        // = - Assignment operator.
        // sc.nextLine() - Reads an entire line of text enetered by the user.

        System.out.print("Enter your age:");
        // Displays the message asking the user to enter their age.
        int age = sc.nextInt(); // int - integer data type.
        // age - Variable name.
        // sc.nextint() - Reads an integer from the keyboard.

        System.out.println(" name:"+ name); // println() - prints the text and then moves to the next line.
        // + - Concatenates(joins) the string "Name:" with the value of name.
        System.out.println(" Age:" + age);
        // print "Age:" followed by the value stored in the age variable.

        sc.close();  // Closes the Scanner object.
        // This releases the input resources after you're done using it.
    }
}
