// File: com/company/employee/hr/HRManager.java
package com.company.employee.hr;

import com.company.employee.Employee;
import com.company.employee.Manager;

public class HRManager extends Manager {
    private String hrSpecialization;
    
    public HRManager(String name, int id, double salary, int teamSize, 
                     double bonusPercentage, String hrSpecialization) {
        super(name, id, salary, teamSize, bonusPercentage);
        this.hrSpecialization = hrSpecialization;
    }
    
    @Override
    public void conductMeeting() {
        System.out.println(name + " is conducting HR meeting about " + hrSpecialization);
    }
    
    public void hireEmployee() {
        System.out.println(name + " is hiring new employees");
    }
    
    public void conductTraining() {
        System.out.println(name + " is conducting training in " + hrSpecialization);
    }
}