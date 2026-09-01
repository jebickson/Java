// File: com/company/banking/Account.java
package com.company.banking;

import com.company.exceptions.*;

public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String accountType;
    private boolean isActive;
    
    public Account(String accountNumber, String accountHolder, double initialBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.accountType = accountType;
        this.isActive = true;
    }
    
    // Deposit money
    public void deposit(double amount) throws NegativeAmountException {
        if (amount < 0) {
            throw new NegativeAmountException("Cannot deposit negative amount", amount);
        }
        if (amount == 0) {
            throw new NegativeAmountException("Cannot deposit zero amount", amount);
        }
        if (!isActive) {
            throw new IllegalStateException("Account is inactive");
        }
        
        balance += amount;
        System.out.println("Deposited $" + amount + " to account " + accountNumber);
        System.out.println("New balance: $" + balance);
    }
    
    // Withdraw money
    public void withdraw(double amount) throws NegativeAmountException, InsufficientBalanceException {
        if (amount < 0) {
            throw new NegativeAmountException("Cannot withdraw negative amount", amount);
        }
        if (amount == 0) {
            throw new NegativeAmountException("Cannot withdraw zero amount", amount);
        }
        if (!isActive) {
            throw new IllegalStateException("Account is inactive");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance for withdrawal",
                balance,
                amount
            );
        }
        
        balance -= amount;
        System.out.println("Withdrew $" + amount + " from account " + accountNumber);
        System.out.println("New balance: $" + balance);
    }
    
    // Transfer money
    public void transfer(Account destination, double amount) 
            throws NegativeAmountException, InsufficientBalanceException, 
                   InvalidAccountException, AccountNotFoundException {
        
        if (destination == null) {
            throw new AccountNotFoundException("Destination account not found");
        }
        if (amount < 0) {
            throw new NegativeAmountException("Cannot transfer negative amount", amount);
        }
        if (amount == 0) {
            throw new NegativeAmountException("Cannot transfer zero amount", amount);
        }
        if (!isActive) {
            throw new IllegalStateException("Source account is inactive");
        }
        if (!destination.isActive) {
            throw new IllegalStateException("Destination account is inactive");
        }
        if (amount > balance) {
            throw new InsufficientBalanceException(
                "Insufficient balance for transfer",
                balance,
                amount
            );
        }
        
        // Perform transfer
        this.balance -= amount;
        destination.balance += amount;
        
        System.out.println("Transferred $" + amount + " from " + accountNumber + 
                          " to " + destination.accountNumber);
        System.out.println("Source balance: $" + this.balance);
        System.out.println("Destination balance: $" + destination.balance);
    }
    
    // Getters
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }
    public String getAccountType() { return accountType; }
    public boolean isActive() { return isActive; }
    
    public void setActive(boolean active) { isActive = active; }
    
    @Override
    public String toString() {
        return "Account[" + accountNumber + "] " + accountHolder + 
               " - $" + balance + " (" + accountType + ") " + 
               (isActive ? "ACTIVE" : "INACTIVE");
    }
}