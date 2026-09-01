// File: com/company/data/DataAccess.java
package com.company.data;

import com.company.employee.Employee;
import com.company.employee.Manager;
import com.company.employee.Developer;
import com.company.employee.hr.HRManager;
import com.company.employee.tech.TeamLead;

public class DataAccess {
    private static DataAccess instance;
    
    private DataAccess() {
        // Private constructor for singleton
    }
    
    public static DataAccess getInstance() {
        if (instance == null) {
            instance = new DataAccess();
        }
        return instance;
    }
    
    public Employee[] getAllEmployees() {
        return new Employee[] {
            new Manager("Alice Johnson", 1001, 75000, 5, 0.15),
            new Developer("Bob Smith", 1002, 65000, "Java", 8),
            new HRManager("Carol White", 1003, 70000, 3, 0.12, "Recruitment"),
            new TeamLead("David Brown", 1004, 80000, "Python", 10, 4)
        };
    }
    
    public void printAllEmployees(Employee[] employees) {
        System.out.println("=== All Employees ===");
        for (Employee emp : employees) {
            System.out.println("\n" + emp.getClass().getSimpleName() + ":");
            emp.displayInfo();
        }
    }
}
