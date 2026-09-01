// File: com/company/employee/Employee.java
package com.company.employee;

public abstract class Employee {
    protected String name;
    protected int id;
    protected double salary;
    
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    
    public abstract double calculateBonus();
    
    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: $" + salary);
        System.out.println("Bonus: $" + calculateBonus());
    }
    
    // Getters
    public String getName() { return name; }
    public int getId() { return id; }
    public double getSalary() { return salary; }
}