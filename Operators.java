package Java;

public class Operators {
    public static void main(String[] args){

        int a = 10;
        int b = 5;

        // Arithmetic Operators 
        System.out.println("Addition:"+(a + b)); // Addition
        System.out.println("Subtraction:"+(a - b)); //Subtraction 
        System.out.println("Multipllication:"+(a * b)); // Multiplication
        System.out.println("Division:"+(a / b)); // Divition
        System.out.println("Modulus:"+(a % b)); // Modulus

        // Relation Operation
        System.out.println("a == b:"+(a == b)); // Equal to
        System.out.println("a != b:"+ (a != b)); // Not equal to 
        System.out.println("a > b:"+ (a > b)); // Greater than
        System.out.println("a < b:"+ (a < b)); // Less that
        System.out.println("a >= b:"+ (a >= b) ); // Greater than equal to
        System.out.println("a <= b:"+ (a <= b)); // Less than equal to

        // Logical Operators
        boolean x = true; // Boolean true
        boolean y = false; // Boolean false
        System.out.println("x && y:" + (x && y)); // Logical AND
        System.out.println("x||y:" + (x||y)); // Logical OR
        System.out.println("!x:" + (!x)); // Logical NOT

        //Assignment Operators

        int c  = 10; //Assign
        c +=5 ; // Add and assign
        c -= 2; // Subtract and assign
        c *= 3; // Multiply and assign 
        c /= 2; // Divide and assign
        c %= 4; // Modulus and assign
        System.out.println("Assignment Result:" + c);
        
        // Increment and Decrement
        int d=5;
        System.out.println("d++ :" + (d++)); // Increment
        System.out.println("After d++ :" + (d++)); // After Increment
        System.out.println("++d :"+(++d)); // Increment
        System.out.println(" d-- :"+(d--)); // Decrement
        System.out.println("After d--"+ d); // After Decrement 
        System.out.println("--d:"+(--d)); // Decrement

        //Ternary Operator
        int max = (a > b) ? a:b; // Conditional (Ternary) operator
        System.out.println("Maximum:"+ max);


    }
}
