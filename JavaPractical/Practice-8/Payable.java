// File: com/company/interfaces/Payable.java
package com.company.interfaces;

public interface Payable {
    double calculateSalary();
    void processPayment();
    String getPaymentDetails();
    
    // Default method (Java 8+)
    default void printPaymentSlip() {
        System.out.println("=== Payment Slip ===");
        System.out.println("Amount: $" + calculateSalary());
        System.out.println("Details: " + getPaymentDetails());
    }
    
    // Static method (Java 8+)
    static void printPaymentPolicy() {
        System.out.println("Payments are processed on the 1st of every month");
    }
}