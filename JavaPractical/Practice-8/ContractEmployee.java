// File: com/company/interfaces/impl/ContractEmployee.java
package com.company.interfaces.impl;

import com.company.interfaces.Payable;
import com.company.interfaces.Workable;
import com.company.util.Logger;

public class ContractEmployee implements Payable, Workable {
    private String name;
    private int id;
    private double hourlyRate;
    private int hoursWorked;
    private boolean isWorking;
    
    public ContractEmployee(String name, int id, double hourlyRate) {
        this.name = name;
        this.id = id;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = 0;
        this.isWorking = false;
        Logger.getInstance().info("ContractEmployee created: " + name);
    }
    
    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
    
    @Override
    public void processPayment() {
        System.out.println("Processing contract payment of $" + calculateSalary() + 
                          " for " + name);
        Logger.getInstance().info("Contract payment processed for " + name);
    }
    
    @Override
    public String getPaymentDetails() {
        return "Contract employee: " + name + ", ID: " + id + 
               ", Hours: " + hoursWorked + ", Rate: $" + hourlyRate;
    }
    
    @Override
    public void startWork() {
        isWorking = true;
        System.out.println(name + " started working (contract)");
    }
    
    @Override
    public void stopWork() {
        isWorking = false;
        System.out.println(name + " stopped working (contract)");
    }
    
    @Override
    public void performDuties() {
        if (isWorking) {
            hoursWorked++;
            System.out.println(name + " is performing contract duties - Hour " + hoursWorked);
        } else {
            System.out.println("Please start work first");
        }
    }
    
    public void setHoursWorked(int hours) {
        this.hoursWorked = hours;
    }
    
    public int getHoursWorked() {
        return hoursWorked;
    }
}