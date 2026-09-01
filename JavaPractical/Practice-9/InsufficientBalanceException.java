// File: com/company/exceptions/InsufficientBalanceException.java
package com.company.exceptions;

public class InsufficientBalanceException extends Exception {
    private double currentBalance;
    private double attemptedWithdrawal;
    
    public InsufficientBalanceException(String message) {
        super(message);
    }
    
    public InsufficientBalanceException(String message, double currentBalance, double attemptedWithdrawal) {
        super(message);
        this.currentBalance = currentBalance;
        this.attemptedWithdrawal = attemptedWithdrawal;
    }
    
    public double getCurrentBalance() {
        return currentBalance;
    }
    
    public double getAttemptedWithdrawal() {
        return attemptedWithdrawal;
    }
    
    @Override
    public String toString() {
        return "InsufficientBalanceException: " + getMessage() + 
               " [Balance: $" + currentBalance + ", Attempted: $" + attemptedWithdrawal + "]";
    }
}
