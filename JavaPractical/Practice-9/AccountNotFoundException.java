// File: com/company/exceptions/AccountNotFoundException.java
package com.company.exceptions;

public class AccountNotFoundException extends Exception {
    private String accountNumber;
    
    public AccountNotFoundException(String message) {
        super(message);
    }
    
    public AccountNotFoundException(String message, String accountNumber) {
        super(message);
        this.accountNumber = accountNumber;
    }
    
    public String getAccountNumber() {
        return accountNumber;
    }
    
    @Override
    public String toString() {
        return "AccountNotFoundException: " + getMessage() + " [Account: " + accountNumber + "]";
    }
}
