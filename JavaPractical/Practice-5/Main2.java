class Shape {
    protected String color;
    protected boolean filled;
    protected String name;
    
    // Default constructor
    public Shape() {
        this("White", false, "Unknown Shape");
        System.out.println("Shape default constructor called");
    }
    
    // Constructor with color
    public Shape(String color) {
        this(color, false, "Unknown Shape");
        System.out.println("Shape color constructor called");
    }
    
    // Constructor with color and filled
    public Shape(String color, boolean filled) {
        this(color, filled, "Unknown Shape");
        System.out.println("Shape filled constructor called");
    }
    
    // Constructor with all details
    public Shape(String color, boolean filled, String name) {
        this.color = color;
        this.filled = filled;
        this.name = name;
        System.out.println("Shape full constructor called");
    }
    
    public void display() {
        System.out.println("Shape: " + name);
        System.out.println("Color: " + color);
        System.out.println("Filled: " + filled);
    }
}

class Circle extends Shape {
    private double radius;
    
    // Default circle constructor
    public Circle() {
        this(1.0);
        System.out.println("Circle default constructor called");
    }
    
    // Constructor with radius
    public Circle(double radius) {
        this(radius, "Yellow");
        System.out.println("Circle radius constructor called");
    }
    
    // Constructor with radius and color
    public Circle(double radius, String color) {
        this(radius, color, true);
        System.out.println("Circle radius-color constructor called");
    }
    
    // Constructor with all details
    public Circle(double radius, String color, boolean filled) {
        super(color, filled, "Circle");
        this.radius = radius;
        System.out.println("Circle full constructor called");
    }
    
    public double getArea() {
        return Math.PI * radius * radius;
    }
    
    @Override
    public void display() {
        super.display();
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + getArea());
    }
}

class Rectangle extends Shape {
    private double length;
    private double width;
    
    // Default rectangle
    public Rectangle() {
        this(1.0, 1.0);
        System.out.println("Rectangle default constructor called");
    }
    
    // Constructor with length and width
    public Rectangle(double length, double width) {
        this(length, width, "Blue");
        System.out.println("Rectangle length-width constructor called");
    }
    
    // Constructor with length, width and color
    public Rectangle(double length, double width, String color) {
        this(length, width, color, false);
        System.out.println("Rectangle length-width-color constructor called");
    }
    
    // Constructor with all details
    public Rectangle(double length, double width, String color, boolean filled) {
        super(color, filled, "Rectangle");
        this.length = length;
        this.width = width;
        System.out.println("Rectangle full constructor called");
    }
    
    public double getArea() {
        return length * width;
    }
    
    @Override
    public void display() {
        super.display();
        System.out.println("Length: " + length);
        System.out.println("Width: " + width);
        System.out.println("Area: " + getArea());
    }
    
    public static void main(String[] args) {
        System.out.println("=== SHAPE HIERARCHY WITH CONSTRUCTOR OVERLOADING ===\n");
        
        System.out.println("Creating Circle:");
        Circle c1 = new Circle(5.0, "Red", true);
        c1.display();
        
        System.out.println("\n---");
        System.out.println("Creating Rectangle:");
        Rectangle r1 = new Rectangle(10.0, 5.0, "Green", true);
        r1.display();
    }
}
