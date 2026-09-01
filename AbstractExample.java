abstract class Animal {
    // Abstract class cannot be instantiated directly
    abstract void sound(); // Abstract method (no body), only declared, must be implemented in subclass
}
class Dog extends Animal {
    // Dog class inherits Animal

    @Override
    void sound(){
        // providing implementation for abstract method
        System.out.println("Dog barks");
    }
}
public class AbstractExample {
    public static void main(String[] args) {
        Animal obj = new Dog(); // Upcasting (Parent reference, Child object)
        obj.sound(); // Calls Dog's implementation of sound()
    }
}

// 1. Abstract method must be inside abstract class
// 2. Abstract method has NO body
// 3. Child class MUST override it
// 4. Cannot create object of abstract class
// 5. Used to achieve abstraction (hiding details)

// @Override → tells compiler: "This method must override parent method"