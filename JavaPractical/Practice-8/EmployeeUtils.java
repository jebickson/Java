// File: com/company/interfaces/constants/EmployeeUtils.java
package com.company.interfaces.constants;

import com.company.employee.Employee;
import com.company.util.Validator;
import com.company.util.Logger;

public class EmployeeUtils implements EmployeeConstants {
    private static Logger logger = Logger.getInstance();
    
    public static boolean validateEmployee(Employee emp) {
        boolean valid = true;
        
        if (!Validator.isValidName(emp.getName())) {
            logger.error("Invalid name: " + emp.getName());
            valid = false;
        }
        
        if (!Validator.isValidId(emp.getId())) {
            logger.error("Invalid ID: " + emp.getId());
            valid = false;
        }
        
        if (!Validator.isValidSalary(emp.getSalary())) {
            logger.error("Invalid salary: " + emp.getSalary());
            valid = false;
        }
        
        if (emp.getSalary() < MIN_SALARY) {
            logger.warning("Salary below minimum: " + emp.getSalary());
        }
        
        if (emp.getSalary() > MAX_SALARY) {
            logger.warning("Salary above maximum: " + emp.getSalary());
        }
        
        return valid;
    }
    
    public static String getStatusText(int status) {
        switch (status) {
            case STATUS_ACTIVE:
                return "Active";
            case STATUS_INACTIVE:
                return "Inactive";
            case STATUS_ON_LEAVE:
                return "On Leave";
            case STATUS_TERMINATED:
                return "Terminated";
            default:
                return "Unknown";
        }
    }
    
    public static double calculateDefaultBonus(double salary) {
        return salary * DEFAULT_BONUS_RATE;
    }
}
