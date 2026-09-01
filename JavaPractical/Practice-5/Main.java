class Student {
    private int rollNo;
    private String name;
    private String course;
    private double fee;
    private String email;
    
    // Default constructor
    public Student() {
        this.rollNo = 0;
        this.name = "Unknown";
        this.course = "Not Assigned";
        this.fee = 0.0;
        this.email = "No Email";
        System.out.println("Default constructor called");
    }
    
    // Constructor with rollNo and name
    public Student(int rollNo, String name) {
        this(); // Calling default constructor
        this.rollNo = rollNo;
        this.name = name;
        System.out.println("Constructor with rollNo and name called");
    }
    
    // Constructor with all details
    public Student(int rollNo, String name, String course, double fee) {
        this.rollNo = rollNo;
        this.name = name;
        this.course = course;
        this.fee = fee;
        this.email = "Not Provided";
        System.out.println("Constructor with all details called");
    }
    
    // Constructor with all details including email
    public Student(int rollNo, String name, String course, double fee, String email) {
        this(rollNo, name, course, fee); // Calling parameterized constructor
        this.email = email;
        System.out.println("Constructor with email called");
    }
    
    // Copy constructor
    public Student(Student other) {
        this.rollNo = other.rollNo;
        this.name = other.name;
        this.course = other.course;
        this.fee = other.fee;
        this.email = other.email;
        System.out.println("Copy constructor called");
    }
    
    public void display() {
        System.out.println("\nStudent Details:");
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("Fee: $" + fee);
        System.out.println("Email: " + email);
    }
    
    public static void main(String[] args) {
        System.out.println("=== CONSTRUCTOR OVERLOADING DEMONSTRATION ===\n");
        
        // Using default constructor
        Student s1 = new Student();
        s1.display();
        
        System.out.println("\n---");
        // Using constructor with rollNo and name
        Student s2 = new Student(101, "John Doe");
        s2.display();
        
        System.out.println("\n---");
        // Using constructor with all details
        Student s3 = new Student(102, "Jane Smith", "Computer Science", 5000.0);
        s3.display();
        
        System.out.println("\n---");
        // Using constructor with all details including email
        Student s4 = new Student(103, "Bob Johnson", "Engineering", 6000.0, "bob@email.com");
        s4.display();
        
        System.out.println("\n---");
        // Using copy constructor
        Student s5 = new Student(s4);
        s5.display();
    }
}
