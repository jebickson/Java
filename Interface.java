/*An interface is a blueprint of a class that contains:

abstract methods (by default)
Used to achieve 100% abstraction
Supports multiple inheritance */

// interface → only method declarations (no full implementation by default)

interface Animal {
    //Interface (no object can be created)
    void sound(); // Abstract method (no body), only declared, must be implemented in class that implements this interface
    // No Body → only declaration
}
class Dog implements Animal {
    // implemnts is used istead of 'extends'

    @Override
    public void sound(){
        // MUST implement interface method
        System.out.println("Dog barks");
    }
}