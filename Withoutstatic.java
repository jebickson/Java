class Test {
    void display(){ // Normal method (non-static)
        System.out.println("Hello");
    }
}
public class Withoutstatic {
    public static void main(String[] argss){
        Test t1 = new Test(); // Create object
        t1.display(); // Call method using object
    }
}

// display() is NOT static
// So we MUST create object to call it