class Test {

    static void display() {  // Static method
        System.out.println("Hello");
    }
}

public class Withstatic {
    public static void main(String[] args) {

        Test.display();  // Call directly using class name
    }
}
// display() is static
// So NO object needed
// Called using class name: Test.display()