// File: com/company/employee/tech/TeamLead.java
package com.company.employee.tech;

import com.company.employee.Developer;

public class TeamLead extends Developer {
    private int teamMembers;
    
    public TeamLead(String name, int id, double salary, String programmingLanguage, 
                    int projectsCompleted, int teamMembers) {
        super(name, id, salary, programmingLanguage, projectsCompleted);
        this.teamMembers = teamMembers;
    }
    
    @Override
    public double calculateBonus() {
        return super.calculateBonus() + (teamMembers * 150);
    }
    
    @Override
    public void writeCode() {
        System.out.println(name + " is reviewing code of " + teamMembers + " team members");
    }
    
    public void assignTasks() {
        System.out.println(name + " is assigning tasks to team");
    }
}