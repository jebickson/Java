// File: com/company/interfaces/constants/EmployeeConstants.java
package com.company.interfaces.constants;

public interface EmployeeConstants {
    // Salary constants
    double MIN_SALARY = 30000;
    double MAX_SALARY = 200000;
    double DEFAULT_BONUS_RATE = 0.10;
    
    // Department constants
    String DEPT_IT = "Information Technology";
    String DEPT_HR = "Human Resources";
    String DEPT_FINANCE = "Finance";
    String DEPT_SALES = "Sales";
    
    // Status constants
    int STATUS_ACTIVE = 1;
    int STATUS_INACTIVE = 0;
    int STATUS_ON_LEAVE = 2;
    int STATUS_TERMINATED = 3;
    
    // Default values
    String DEFAULT_DEPARTMENT = DEPT_IT;
    int DEFAULT_STATUS = STATUS_ACTIVE;
}
