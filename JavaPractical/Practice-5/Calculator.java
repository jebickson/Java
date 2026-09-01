public class Calculator {
    
    // Overloaded methods for addition
    public int add(int a, int b) {
        return a + b;
    }
    
    public int add(int a, int b, int c) {
        return a + b + c;
    }
    
    public double add(double a, double b) {
        return a + b;
    }
    
    public String add(String a, String b) {
        return a + b;
    }
    
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
        System.out.println("=== METHOD OVERLOADING DEMONSTRATION ===");
        System.out.println("add(5, 10): " + calc.add(5, 10));
        System.out.println("add(5, 10, 15): " + calc.add(5, 10, 15));
        System.out.println("add(3.5, 2.7): " + calc.add(3.5, 2.7));
        System.out.println("add(\"Hello \", \"World\"): " + calc.add("Hello ", "World"));
    }
}