// File: com/company/interfaces/functional/EmployeeFilter.java
package com.company.interfaces.functional;

@FunctionalInterface
public interface EmployeeFilter {
    boolean filter(com.company.employee.Employee employee);
}

// File: com/company/interfaces/functional/SalaryCalculator.java
package com.company.interfaces.functional;

@FunctionalInterface
public interface SalaryCalculator {
    double calculate(double baseSalary);
}

// File: com/company/interfaces/functional/EmployeeProcessor.java
package com.company.interfaces.functional;

@FunctionalInterface
public interface EmployeeProcessor {
    void process(com.company.employee.Employee employee);
}