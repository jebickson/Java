// Base Class
class Employee {
    protected String name;
    protected int employeeId;
    protected double baseSalary;
    protected String department;
    
    // Constructor
    public Employee(String name, int employeeId, double baseSalary, String department) {
        this.name = name;
        this.employeeId = employeeId;
        this.baseSalary = baseSalary;
        this.department = department;
    }
    
    // Method to be overridden
    public double calculateSalary() {
        return baseSalary;
    }
    
    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Total Salary: $" + calculateSalary());
    }
    
    public void work() {
        System.out.println(name + " is working...");
    }
    
    // Getters and Setters
    public String getName() { return name; }
    public int getEmployeeId() { return employeeId; }
    public double getBaseSalary() { return baseSalary; }
    public String getDepartment() { return department; }
}

// Subclass 1: Manager
class Manager extends Employee {
    private double bonus;
    private int teamSize;
    
    public Manager(String name, int employeeId, double baseSalary, String department, 
                   double bonus, int teamSize) {
        super(name, employeeId, baseSalary, department);
        this.bonus = bonus;
        this.teamSize = teamSize;
    }
    
    @Override
    public double calculateSalary() {
        // Manager gets base salary + bonus + team size bonus
        return super.calculateSalary() + bonus + (teamSize * 100);
    }
    
    @Override
    public void work() {
        System.out.println(name + " is managing a team of " + teamSize + " employees");
    }
    
    public void conductMeeting() {
        System.out.println(name + " is conducting a team meeting");
    }
    
    public void reviewWork() {
        System.out.println(name + " is reviewing team's work");
    }
}

// Subclass 2: Developer
class Developer extends Employee {
    private String programmingLanguage;
    private int yearsOfExperience;
    private double projectBonus;
    
    public Developer(String name, int employeeId, double baseSalary, String department,
                     String programmingLanguage, int yearsOfExperience, double projectBonus) {
        super(name, employeeId, baseSalary, department);
        this.programmingLanguage = programmingLanguage;
        this.yearsOfExperience = yearsOfExperience;
        this.projectBonus = projectBonus;
    }
    
    @Override
    public double calculateSalary() {
        // Developer gets base salary + experience bonus + project bonus
        double experienceBonus = yearsOfExperience * 500;
        return super.calculateSalary() + experienceBonus + projectBonus;
    }
    
    @Override
    public void work() {
        System.out.println(name + " is coding in " + programmingLanguage);
    }
    
    public void debugCode() {
        System.out.println(name + " is debugging code");
    }
    
    public void writeCode() {
        System.out.println(name + " is writing " + programmingLanguage + " code");
    }
}

// Subclass 3: Intern
class Intern extends Employee {
    private String university;
    private int durationMonths;
    
    public Intern(String name, int employeeId, double baseSalary, String department,
                  String university, int durationMonths) {
        super(name, employeeId, baseSalary, department);
        this.university = university;
        this.durationMonths = durationMonths;
    }
    
    @Override
    public double calculateSalary() {
        // Intern gets half of base salary
        return super.calculateSalary() * 0.5;
    }
    
    @Override
    public void work() {
        System.out.println(name + " is learning and assisting team members");
    }
    
    public void learn() {
        System.out.println(name + " is learning from " + university);
    }
    
    public void assistTeam() {
        System.out.println(name + " is assisting the team");
    }
}