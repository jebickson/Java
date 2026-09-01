// File: com/company/main/Application.java
package com.company.main;

import com.company.employee.Employee;
import com.company.employee.Manager;
import com.company.employee.Developer;
import com.company.employee.hr.HRManager;
import com.company.employee.tech.TeamLead;
import com.company.data.DataAccess;
import com.company.util.Logger;
import com.company.util.Validator;
import com.company.interfaces.Payable;
import com.company.interfaces.Workable;
import com.company.interfaces.Reportable;
import com.company.interfaces.impl.FullTimeEmployee;
import com.company.interfaces.impl.ContractEmployee;
import com.company.interfaces.functional.FunctionalDemo;
import com.company.interfaces.constants.EmployeeUtils;
import com.company.interfaces.constants.EmployeeConstants;

import java.util.Scanner;

public class Application {
    private static Logger logger = Logger.getInstance();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== PRACTICE 8: PACKAGES AND INTERFACES ===\n");
        
        // Demonstration of all concepts
        demonstratePackageStructure();
        demonstrateInterfaces();
        demonstrateFunctionalInterfaces();
        demonstrateInterfaceConstants();
        demonstrateDataAccess();
        
        System.out.println("\n=== APPLICATION EXECUTED SUCCESSFULLY ===");
    }
    
    private static void demonstratePackageStructure() {
        System.out.println("\n=== 1. PACKAGE STRUCTURE DEMONSTRATION ===");
        
        // Creating objects from different packages
        Manager manager = new Manager("Alice Johnson", 1001, 75000, 5, 0.15);
        Developer developer = new Developer("Bob Smith", 1002, 65000, "Java", 8);
        HRManager hrManager = new HRManager("Carol White", 1003, 70000, 3, 0.12, "Recruitment");
        TeamLead teamLead = new TeamLead("David Brown", 1004, 80000, "Python", 10, 4);
        
        // Display employee information
        System.out.println("\nManagers:");
        manager.displayInfo();
        manager.conductMeeting();
        manager.reviewPerformance();
        
        System.out.println("\nDevelopers:");
        developer.displayInfo();
        developer.writeCode();
        developer.debugCode();
        
        System.out.println("\nHR Managers:");
        hrManager.displayInfo();
        hrManager.hireEmployee();
        hrManager.conductTraining();
        
        System.out.println("\nTeam Leads:");
        teamLead.displayInfo();
        teamLead.assignTasks();
        teamLead.writeCode();
        
        // Logging
        logger.info("Package structure demonstration completed");
    }
    
    private static void demonstrateInterfaces() {
        System.out.println("\n=== 2. INTERFACE DEMONSTRATION ===");
        
        // Full-time employee
        FullTimeEmployee fullTime = new FullTimeEmployee("Eva Williams", 2001, 55000);
        System.out.println("\nFull-Time Employee:");
        fullTime.startWork();
        fullTime.performDuties();
        fullTime.generateReport();
        fullTime.submitReport();
        fullTime.attendTraining();
        fullTime.processPayment();
        fullTime.printPaymentSlip();
        fullTime.stopWork();
        
        // Contract employee
        ContractEmployee contract = new ContractEmployee("Frank Wilson", 2002, 45);
        System.out.println("\nContract Employee:");
        contract.startWork();
        for (int i = 0; i < 5; i++) {
            contract.performDuties();
        }
        contract.processPayment();
        contract.printPaymentSlip();
        contract.stopWork();
        
        // Polymorphism with interfaces
        System.out.println("\nInterface Polymorphism:");
        Payable[] payables = {fullTime, contract};
        for (Payable p : payables) {
            System.out.println("Payment: " + p.getPaymentDetails());
            p.processPayment();
        }
        
        Workable[] workables = {fullTime, contract};
        for (Workable w : workables) {
            w.startWork();
            w.performDuties();
            w.stopWork();
        }
        
        logger.info("Interface demonstration completed");
    }
    
    private static void demonstrateFunctionalInterfaces() {
        System.out.println("\n=== 3. FUNCTIONAL INTERFACES DEMONSTRATION ===");
        
        FunctionalDemo demo = new FunctionalDemo();
        
        // Add employees
        demo.addEmployee(new Manager("Grace Johnson", 3001, 90000, 6, 0.18));
        demo.addEmployee(new Developer("Henry Brown", 3002, 70000, "C++", 5));
        demo.addEmployee(new HRManager("Ivy White", 3003, 75000, 4, 0.14, "Employee Relations"));
        demo.addEmployee(new TeamLead("Jack Davis", 3004, 85000, "JavaScript", 8, 5));
        
        demo.demonstrateFunctionalInterfaces();
        
        logger.info("Functional interfaces demonstration completed");
    }
    
    private static void demonstrateInterfaceConstants() {
        System.out.println("\n=== 4. INTERFACE CONSTANTS DEMONSTRATION ===");
        
        // Using constants
        System.out.println("Minimum Salary: $" + EmployeeConstants.MIN_SALARY);
        System.out.println("Maximum Salary: $" + EmployeeConstants.MAX_SALARY);
        System.out.println("Default Department: " + EmployeeConstants.DEFAULT_DEPARTMENT);
        System.out.println("Default Bonus Rate: " + (EmployeeConstants.DEFAULT_BONUS_RATE * 100) + "%");
        
        // Using utility methods
        Employee emp = new Manager("Kate Martinez", 1001, 55000, 3, 0.15);
        
        System.out.println("\nValidating employee: " + emp.getName());
        boolean valid = EmployeeUtils.validateEmployee(emp);
        System.out.println("Validation result: " + valid);
        
        System.out.println("\nStatus code: " + EmployeeConstants.STATUS_ACTIVE);
        System.out.println("Status text: " + EmployeeUtils.getStatusText(EmployeeConstants.STATUS_ACTIVE));
        System.out.println("Default bonus: $" + EmployeeUtils.calculateDefaultBonus(emp.getSalary()));
        
        // Test invalid employee
        System.out.println("\nTesting invalid employee:");
        Employee invalidEmp = new Manager("", -1, -1000, 0, 0);
        EmployeeUtils.validateEmployee(invalidEmp);
        
        logger.info("Interface constants demonstration completed");
    }
    
    private static void demonstrateDataAccess() {
        System.out.println("\n=== 5. DATA ACCESS DEMONSTRATION ===");
        
        DataAccess dataAccess = DataAccess.getInstance();
        Employee[] employees = dataAccess.getAllEmployees();
        dataAccess.printAllEmployees(employees);
        
        // Using validator utility
        System.out.println("\n=== Validator Utility ===");
        System.out.println("Valid name 'John Doe': " + Validator.isValidName("John Doe"));
        System.out.println("Valid name 'J': " + Validator.isValidName("J"));
        System.out.println("Valid ID 123: " + Validator.isValidId(123));
        System.out.println("Valid ID -1: " + Validator.isValidId(-1));
        System.out.println("Valid email 'test@email.com': " + Validator.isValidEmail("test@email.com"));
        System.out.println("Valid email 'invalid': " + Validator.isValidEmail("invalid"));
        System.out.println("Valid phone '1234567890': " + Validator.isValidPhone("1234567890"));
        System.out.println("Valid phone '12345': " + Validator.isValidPhone("12345"));
        
        logger.info("Data access demonstration completed");
    }
}