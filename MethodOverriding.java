class Animal { //Parent class

    void sound(){ //Method in parent class
        System.out.println("Animal makes a sound"); // Default behavior
    }
}

class Dog extends Animal { //Child class inherits Animal

    @Override // Annotation (optional but recommended)
    void sound(){ // Same method as parent
        System.out.println("Dog barks"); // Overridden behavior
    }
}

public class MethodOverriding {
    public static void main(String[] args) { // Entry point
         
        Animal obj = new Dog(); //Upcasting (Parent reference, Child object)
        obj.sound(); // Calls Dog's method due to runtime polymorphism (method overriding)
    }
}

/*Same method name + same parameters
Child class replaces parent behavior

Java decides method at runtime*/

// Overriding → Same method, child changes parent behavior (runtime)