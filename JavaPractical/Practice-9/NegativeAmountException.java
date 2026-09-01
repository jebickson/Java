// File: com/company/exceptions/NegativeAmountException.java
package com.company.exceptions;

public class NegativeAmountException extends Exception {
    private double amount;
    
    public NegativeAmountException(String message) {
        super(message);
    }
    
    public NegativeAmountException(String message, double amount) {
        super(message);
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }
    
    @Override
    public String toString() {
        return "NegativeAmountException: " + getMessage() + " [Amount: $" + amount + "]";
    }
}
