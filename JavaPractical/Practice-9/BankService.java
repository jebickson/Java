// File: com/company/banking/BankService.java
package com.company.banking;

import com.company.exceptions.*;
import java.util.*;

public class BankService {
    private Map<String, Account> accounts;
    private List<String> transactionLog;
    
    public BankService() {
        this.accounts = new HashMap<>();
        this.transactionLog = new ArrayList<>();
    }
    
    // Create account with exception handling
    public Account createAccount(String accountNumber, String accountHolder, 
                                double initialBalance, String accountType) 
            throws IllegalArgumentException {
        
        // Validate inputs
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Account number cannot be empty");
        }
        if (accountHolder == null || accountHolder.trim().isEmpty()) {
            throw new IllegalArgumentException("Account holder name cannot be empty");
        }
        if (accounts.containsKey(accountNumber)) {
            throw new IllegalArgumentException("Account number already exists: " + accountNumber);
        }
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        
        // Create account
        Account account = new Account(accountNumber, accountHolder, initialBalance, accountType);
        accounts.put(accountNumber, account);
        logTransaction("Account created: " + account);
        return account;
    }
    
    // Find account with exception handling
    public Account findAccount(String accountNumber) throws AccountNotFoundException {
        if (accountNumber == null || accountNumber.trim().isEmpty()) {
            throw new AccountNotFoundException("Account number cannot be empty");
        }
        
        Account account = accounts.get(accountNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found: " + accountNumber, accountNumber);
        }
        return account;
    }
    
    // Deposit with exception handling
    public void deposit(String accountNumber, double amount) 
            throws AccountNotFoundException, NegativeAmountException {
        try {
            Account account = findAccount(accountNumber);
            account.deposit(amount);
            logTransaction("Deposit: " + accountNumber + " +$" + amount);
        } catch (AccountNotFoundException e) {
            logTransaction("ERROR: " + e.getMessage());
            throw e;
        } catch (NegativeAmountException e) {
            logTransaction("ERROR: " + e.getMessage());
            throw e;
        } catch (IllegalStateException e) {
            logTransaction("ERROR: " + e.getMessage());
            throw e;
        }
    }
    
    // Withdraw with exception handling
    public void withdraw(String accountNumber, double amount) 
            throws AccountNotFoundException, NegativeAmountException, 
                   InsufficientBalanceException {
        try {
            Account account = findAccount(accountNumber);
            account.withdraw(amount);
            logTransaction("Withdrawal: " + accountNumber + " -$" + amount);
        } catch (AccountNotFoundException e) {
            logTransaction("ERROR: " + e.getMessage());
            throw e;
        } catch (NegativeAmountException e) {
            logTransaction("ERROR: " + e.getMessage());
            throw e;
        } catch (InsufficientBalanceException e) {
            logTransaction("ERROR: " + e.getMessage());
            throw e;
        } catch (IllegalStateException e) {
            logTransaction("ERROR: " + e.getMessage());
            throw e;
        }
    }
    
    // Transfer with exception handling
    public void transfer(String sourceNumber, String destinationNumber, double amount) 
            throws AccountNotFoundException, NegativeAmountException, 
                   InsufficientBalanceException {
        try {
            Account source = findAccount(sourceNumber);
            Account destination = findAccount(destinationNumber);
            
            source.transfer(destination, amount);
            logTransaction("Transfer: " + sourceNumber + " -> " + destinationNumber + " $" + amount);
        } catch (AccountNotFoundException e) {
            logTransaction("ERROR: " + e.getMessage());
            throw e;
        } catch (NegativeAmountException e) {
            logTransaction("ERROR: " + e.getMessage());
            throw e;
        } catch (InsufficientBalanceException e) {
            logTransaction("ERROR: " + e.getMessage());
            throw e;
        } catch (IllegalStateException e) {
            logTransaction("ERROR: " + e.getMessage());
            throw e;
        }
    }
    
    // Display account details with exception handling
    public void displayAccount(String accountNumber) {
        try {
            Account account = findAccount(accountNumber);
            System.out.println("\n=== Account Details ===");
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Account Holder: " + account.getAccountHolder());
            System.out.println("Account Type: " + account.getAccountType());
            System.out.println("Balance: $" + account.getBalance());
            System.out.println("Status: " + (account.isActive() ? "ACTIVE" : "INACTIVE"));
        } catch (AccountNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    // Display all accounts
    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts in the system");
            return;
        }
        
        System.out.println("\n=== All Accounts ===");
        for (Account account : accounts.values()) {
            System.out.println(account);
        }
    }
    
    // Transaction logging
    private void logTransaction(String message) {
        String logEntry = new Date() + " - " + message;
        transactionLog.add(logEntry);
        System.out.println("[LOG] " + logEntry);
    }
    
    // Display transaction log
    public void displayTransactionLog() {
        System.out.println("\n=== Transaction Log ===");
        if (transactionLog.isEmpty()) {
            System.out.println("No transactions recorded");
            return;
        }
        for (String log : transactionLog) {
            System.out.println(log);
        }
    }
}