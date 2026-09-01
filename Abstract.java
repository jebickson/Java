// Yes, an abstract class can implement an interface
//(but it doesn't have to implement all methods)

interface A {
    void show();
}
abstract class B implements A {
    // No need to implement show() here, as B is abstract
    // B can have its own abstract methods or concrete methods
}
// implements → "I agree to follow all rules of this interface"
class C extends B {
    @Override
    public void show() {
        System.out.println("Implemented in class C");
    }
} 

// ✔ Class → can extend ONLY one abstract class
// ✔ Class → can implement MULTIPLE interfaces
// ✔ Abstract class → can implement interface (optional methods)
// ✔ Concrete class → MUST implement all methods
// Interface → rules only
// Abstract class → rules + some implementation
// Class → full implementation
// Interface = "contract"
// Abstract class = "partial ready system"
// Class = "final working product"