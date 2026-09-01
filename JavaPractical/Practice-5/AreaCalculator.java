public class AreaCalculator {
    
    // Area of square
    public double area(double side) {
        return side * side;
    }
    
    // Area of rectangle
    public double area(double length, double width) {
        return length * width;
    }
    
    // Area of triangle
    public double area(double base, double height, String shape) {
        if (shape.equalsIgnoreCase("triangle")) {
            return 0.5 * base * height;
        }
        return 0;
    }
    
    // Area of circle
    public double area(float radius) {
        return Math.PI * radius * radius;
    }
    
    // Area of trapezoid
    public double area(double base1, double base2, double height, boolean isTrapezoid) {
        if (isTrapezoid) {
            return ((base1 + base2) / 2) * height;
        }
        return 0;
    }
    
    public static void main(String[] args) {
        AreaCalculator area = new AreaCalculator();
        
        System.out.println("=== AREA CALCULATOR (METHOD OVERLOADING) ===");
        System.out.println("Square (side=5): " + area.area(5));
        System.out.println("Rectangle (5x10): " + area.area(5, 10));
        System.out.println("Triangle (base=6, height=8): " + area.area(6, 8, "triangle"));
        System.out.println("Circle (radius=3): " + area.area(3.0f));
        System.out.println("Trapezoid (b1=5, b2=7, h=4): " + area.area(5, 7, 4, true));
    }
}