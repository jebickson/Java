package Java;

public class MethodsWithoutParameters {
    // public - The class can be accessed from anywhere.
    // class - Dfines a class.
    // Main - The name of the class.
    
    static void greet(){
        // Static - This method belongs to the class, so you can call it without creating an object.
        // void - The method does not return any value.
        // greet - The method name.
        // () - No parameters(no input is passed to the method).
        System.out.println("Welcome to Java");
        // System - Build in java class.
        // out - Standard output (console/screen).
        // println() - prints test and moves to the next line.
        // "Welcome to Java" - The text that will be printed.
    }

    public static void main(String [] args){
        // public - Accessible by the Java Virtual Machine(JVM).
        // Static - Can run without creating an onject.
        // void - Returns nothing 
        // main - Stores command-line
        // String []args - Stores command- line arguments.
        greet();
        // Calls the greet() method.
        // When Java reaches this line, it jumps to the greet() method, executes it, prints
        // "Welcome to Java", and then returns to the main() method.
    }
}


/*
 Program flow

 1. JVM Starts the program. 
 2.it enters the main() method.
 3. greet() method runs.
 5. "Welcome to Java" is printed.
 6. greet() Finishes and returns to main().
 7.main() ends.
 8. The program stops.




*/