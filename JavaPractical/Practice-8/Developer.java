// File: com/company/employee/Developer.java
package com.company.employee;

public class Developer extends Employee {
    private String programmingLanguage;
    private int projectsCompleted;
    
    public Developer(String name, int id, double salary, String programmingLanguage, int projectsCompleted) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
        this.projectsCompleted = projectsCompleted;
    }
    
    @Override
    public double calculateBonus() {
        return salary * 0.10 + (projectsCompleted * 200);
    }
    
    public void writeCode() {
        System.out.println(name + " is writing " + programmingLanguage + " code");
    }
    
    public void debugCode() {
        System.out.println(name + " is debugging code");
    }
}