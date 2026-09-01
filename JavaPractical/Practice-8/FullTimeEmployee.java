// File: com/company/interfaces/impl/FullTimeEmployee.java
package com.company.interfaces.impl;

import com.company.interfaces.Payable;
import com.company.interfaces.Workable;
import com.company.interfaces.Reportable;
import com.company.interfaces.Trainable;
import com.company.util.Logger;

public class FullTimeEmployee implements Payable, Workable, Reportable, Trainable {
    private String name;
    private int id;
    private double monthlySalary;
    private boolean isWorking;
    private boolean certified;
    
    public FullTimeEmployee(String name, int id, double monthlySalary) {
        this.name = name;
        this.id = id;
        this.monthlySalary = monthlySalary;
        this.isWorking = false;
        this.certified = false;
        Logger.getInstance().info("FullTimeEmployee created: " + name);
    }
    
    // Payable interface methods
    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
    
    @Override
    public void processPayment() {
        System.out.println("Processing full-time payment of $" + calculateSalary() + 
                          " for " + name);
        Logger.getInstance().info("Payment processed for " + name);
    }
    
    @Override
    public String getPaymentDetails() {
        return "Full-time employee: " + name + ", ID: " + id + 
               ", Monthly Salary: $" + monthlySalary;
    }
    
    // Workable interface methods
    @Override
    public void startWork() {
        isWorking = true;
        System.out.println(name + " started working");
        Logger.getInstance().info(name + " started work");
    }
    
    @Override
    public void stopWork() {
        isWorking = false;
        System.out.println(name + " stopped working");
        Logger.getInstance().info(name + " stopped work");
    }
    
    @Override
    public void performDuties() {
        if (isWorking) {
            System.out.println(name + " is performing full-time duties");
        } else {
            System.out.println("Please start work first");
        }
    }
    
    // Reportable interface methods
    @Override
    public void generateReport() {
        System.out.println(name + " is generating monthly report");
    }
    
    @Override
    public void submitReport() {
        System.out.println(name + " submitted report");
    }
    
    @Override
    public void reviewReport() {
        System.out.println(name + " is reviewing report");
    }
    
    // Trainable interface methods
    @Override
    public void attendTraining() {
        System.out.println(name + " is attending training session");
    }
    
    @Override
    public void conductTraining() {
        System.out.println(name + " is conducting training");
    }
    
    @Override
    public boolean isCertified() {
        return certified;
    }
    
    public void setCertified(boolean certified) {
        this.certified = certified;
        Logger.getInstance().info(name + " certification status: " + certified);
    }
}
