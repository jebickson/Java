// File: com/company/employee/Manager.java
package com.company.employee;

public class Manager extends Employee {
    private int teamSize;
    private double bonusPercentage;
    
    public Manager(String name, int id, double salary, int teamSize, double bonusPercentage) {
        super(name, id, salary);
        this.teamSize = teamSize;
        this.bonusPercentage = bonusPercentage;
    }
    
    @Override
    public double calculateBonus() {
        return salary * bonusPercentage + (teamSize * 100);
    }
    
    public void conductMeeting() {
        System.out.println(name + " is conducting a team meeting");
    }
    
    public void reviewPerformance() {
        System.out.println(name + " is reviewing team performance");
    }
}