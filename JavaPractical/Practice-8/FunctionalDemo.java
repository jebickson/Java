// File: com/company/interfaces/functional/FunctionalDemo.java
package com.company.interfaces.functional;

import com.company.employee.Employee;
import com.company.employee.Manager;
import com.company.employee.Developer;
import com.company.employee.hr.HRManager;
import com.company.employee.tech.TeamLead;
import com.company.util.Logger;

import java.util.ArrayList;
import java.util.List;

public class FunctionalDemo {
    private List<Employee> employees;
    private Logger logger;
    
    public FunctionalDemo() {
        this.employees = new ArrayList<>();
        this.logger = Logger.getInstance();
    }
    
    public void addEmployee(Employee emp) {
        employees.add(emp);
        logger.info("Employee added: " + emp.getName());
    }
    
    // Filtering employees using functional interface
    public List<Employee> filterEmployees(EmployeeFilter filter) {
        List<Employee> result = new ArrayList<>();
        for (Employee emp : employees) {
            if (filter.filter(emp)) {
                result.add(emp);
            }
        }
        return result;
    }
    
    // Processing employees
    public void processEmployees(EmployeeProcessor processor) {
        for (Employee emp : employees) {
            processor.process(emp);
        }
    }
    
    // Calculate adjusted salary
    public double calculateAdjustedSalary(Employee emp, SalaryCalculator calculator) {
        return calculator.calculate(emp.getSalary());
    }
    
    public void demonstrateFunctionalInterfaces() {
        System.out.println("\n=== Functional Interfaces Demo ===");
        
        // Adding employees
        employees.clear();
        employees.add(new Manager("Alice", 1, 75000, 5, 0.15));
        employees.add(new Developer("Bob", 2, 65000, "Java", 8));
        employees.add(new HRManager("Carol", 3, 70000, 3, 0.12, "Recruitment"));
        employees.add(new TeamLead("David", 4, 80000, "Python", 10, 4));
        
        // Filter employees with salary > 70000
        System.out.println("\n1. Filter: Employees with salary > 70000");
        EmployeeFilter salaryFilter = emp -> emp.getSalary() > 70000;
        List<Employee> highSalaryEmployees = filterEmployees(salaryFilter);
        for (Employee emp : highSalaryEmployees) {
            System.out.println("   - " + emp.getName() + ": $" + emp.getSalary());
        }
        
        // Filter employees whose name starts with 'A'
        System.out.println("\n2. Filter: Employees with name starting with 'A'");
        EmployeeFilter nameFilter = emp -> emp.getName().startsWith("A");
        List<Employee> nameEmployees = filterEmployees(nameFilter);
        for (Employee emp : nameEmployees) {
            System.out.println("   - " + emp.getName());
        }
        
        // Process employees (print their info)
        System.out.println("\n3. Process: Display all employees");
        EmployeeProcessor displayProcessor = emp -> {
            System.out.println("   - " + emp.getName() + " (ID: " + emp.getId() + ")");
        };
        processEmployees(displayProcessor);
        
        // Calculate adjusted salary with 10% bonus
        System.out.println("\n4. Salary Calculator: Base + 10% bonus");
        SalaryCalculator bonusCalculator = baseSalary -> baseSalary * 1.10;
        for (Employee emp : employees) {
            double adjusted = calculateAdjustedSalary(emp, bonusCalculator);
            System.out.println("   - " + emp.getName() + ": " + adjusted);
        }
        
        // Multiple filters using lambda expressions
        System.out.println("\n5. Combined Filter: Salary > 70000 AND name starts with 'A'");
        EmployeeFilter combinedFilter = emp -> 
            emp.getSalary() > 70000 && emp.getName().startsWith("A");
        List<Employee> combinedResult = filterEmployees(combinedFilter);
        for (Employee emp : combinedResult) {
            System.out.println("   - " + emp.getName() + ": $" + emp.getSalary());
        }
    }
}
