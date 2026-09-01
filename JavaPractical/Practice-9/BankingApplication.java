// File: com/company/main/BankingApplication.java
package com.company.main;

import com.company.banking.*;
import com.company.exceptions.*;
import com.company.exceptions.ExceptionHandlingPatterns;
import java.util.Scanner;

public class BankingApplication {
    private static BankService bankService = new BankService();
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("=== BANKING APPLICATION WITH EXCEPTION HANDLING ===\n");
        
        // Initialize with some accounts
        initializeBank();
        
        // Demonstrate exception handling
        demonstrateExceptionHandling();
        
        // Interactive menu
        interactiveMenu();
        
        System.out.println("\n=== APPLICATION ENDED ===");
    }
    
    private static void initializeBank() {
        try {
            bankService.createAccount("ACC001", "Alice Johnson", 5000, "Savings");
            bankService.createAccount("ACC002", "Bob Smith", 3000, "Checking");
            bankService.createAccount("ACC003", "Carol White", 10000, "Savings");
            bankService.createAccount("ACC004", "David Brown", 2000, "Checking");
            System.out.println("Bank initialized with 4 accounts\n");
        } catch (IllegalArgumentException e) {
            System.err.println("Initialization error: " + e.getMessage());
        }
    }
    
    private static void demonstrateExceptionHandling() {
        System.out.println("=== EXCEPTION HANDLING DEMONSTRATION ===\n");
        
        // 1. Demonstrate NegativeAmountException
        System.out.println("1. Negative Amount Exception:");
        try {
            bankService.deposit("ACC001", -100);
        } catch (Exception e) {
            System.out.println("Caught: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage() + "\n");
        }
        
        // 2. Demonstrate InsufficientBalanceException
        System.out.println("2. Insufficient Balance Exception:");
        try {
            bankService.withdraw("ACC001", 10000);
        } catch (Exception e) {
            System.out.println("Caught: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
            if (e instanceof InsufficientBalanceException) {
                InsufficientBalanceException ibe = (InsufficientBalanceException) e;
                System.out.println("Current Balance: $" + ibe.getCurrentBalance());
                System.out.println("Attempted: $" + ibe.getAttemptedWithdrawal() + "\n");
            }
        }
        
        // 3. Demonstrate AccountNotFoundException
        System.out.println("3. Account Not Found Exception:");
        try {
            bankService.findAccount("INVALID");
        } catch (Exception e) {
            System.out.println("Caught: " + e.getClass().getSimpleName());
            System.out.println("Message: " + e.getMessage());
            if (e instanceof AccountNotFoundException) {
                AccountNotFoundException anfe = (AccountNotFoundException) e;
                System.out.println("Account Number: " + anfe.getAccountNumber() + "\n");
            }
        }
        
        // 4. Demonstrate successful operations
        System.out.println("4. Successful Operations:");
        try {
            bankService.deposit("ACC001", 1000);
            bankService.withdraw("ACC001", 500);
            bankService.transfer("ACC001", "ACC002", 200);
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
        
        System.out.println("\nFinal Account Status:");
        bankService.displayAccount("ACC001");
        bankService.displayAccount("ACC002");
        System.out.println();
    }
    
    private static void interactiveMenu() {
        while (true) {
            System.out.println("\n=== BANKING MENU ===");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Transfer Money");
            System.out.println("4. View Account");
            System.out.println("5. View All Accounts");
            System.out.println("6. View Transaction Log");
            System.out.println("7. Demonstration Patterns");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                
                switch (choice) {
                    case 1:
                        depositMoney();
                        break;
                    case 2:
                        withdrawMoney();
                        break;
                    case 3:
                        transferMoney();
                        break;
                    case 4:
                        viewAccount();
                        break;
                    case 5:
                        bankService.displayAllAccounts();
                        break;
                    case 6:
                        bankService.displayTransactionLog();
                        break;
                    case 7:
                        demonstratePatterns();
                        break;
                    case 8:
                        System.out.println("Exiting application...");
                        return;
                    default:
                        System.out.println("Invalid choice");
                }
            } catch (NumberFormatException e) {
                System.err.println("Invalid input. Please enter a number.");
            } catch (Exception e) {
                System.err.println("Unexpected error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
    
    private static void depositMoney() {
        try {
            System.out.print("Enter account number: ");
            String accountNumber = scanner.nextLine().trim();
            System.out.print("Enter amount to deposit: ");
            double amount = Double.parseDouble(scanner.nextLine().trim());
            
            bankService.deposit(accountNumber, amount);
        } catch (AccountNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Account number: " + e.getAccountNumber());
        } catch (NegativeAmountException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Amount: $" + e.getAmount());
        } catch (NumberFormatException e) {
            System.err.println("Invalid amount format");
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
    
    private static void withdrawMoney() {
        try {
            System.out.print("Enter account number: ");
            String accountNumber = scanner.nextLine().trim();
            System.out.print("Enter amount to withdraw: ");
            double amount = Double.parseDouble(scanner.nextLine().trim());
            
            bankService.withdraw(accountNumber, amount);
        } catch (AccountNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Account number: " + e.getAccountNumber());
        } catch (NegativeAmountException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Amount: $" + e.getAmount());
        } catch (InsufficientBalanceException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Balance: $" + e.getCurrentBalance());
            System.err.println("Attempted: $" + e.getAttemptedWithdrawal());
        } catch (NumberFormatException e) {
            System.err.println("Invalid amount format");
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
    
    private static void transferMoney() {
        try {
            System.out.print("Enter source account number: ");
            String source = scanner.nextLine().trim();
            System.out.print("Enter destination account number: ");
            String destination = scanner.nextLine().trim();
            System.out.print("Enter amount to transfer: ");
            double amount = Double.parseDouble(scanner.nextLine().trim());
            
            bankService.transfer(source, destination, amount);
        } catch (AccountNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Account number: " + e.getAccountNumber());
        } catch (NegativeAmountException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Amount: $" + e.getAmount());
        } catch (InsufficientBalanceException e) {
            System.err.println("Error: " + e.getMessage());
            System.err.println("Balance: $" + e.getCurrentBalance());
            System.err.println("Attempted: $" + e.getAttemptedWithdrawal());
        } catch (NumberFormatException e) {
            System.err.println("Invalid amount format");
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
    
    private static void viewAccount() {
        try {
            System.out.print("Enter account number: ");
            String accountNumber = scanner.nextLine().trim();
            bankService.displayAccount(accountNumber);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    private static void demonstratePatterns() {
        System.out.println("\n=== EXCEPTION HANDLING PATTERNS ===\n");
        
        ExceptionHandlingPatterns patterns = new ExceptionHandlingPatterns();
        
        System.out.println("1. Try-Catch-Finally Pattern:");
        patterns.readFileWithTryCatchFinally("nonexistent.txt");
        System.out.println();
        
        System.out.println("2. Try-with-Resources Pattern:");
        patterns.readFileWithTryWithResources("nonexistent.txt");
        System.out.println();
        
        System.out.println("3. Multiple Catch Blocks:");
        patterns.processNumber("abc");
        patterns.processNumber("0");
        patterns.processNumber("10");
        System.out.println();
        
        System.out.println("4. Nested Try-Catch:");
        patterns.nestedTryCatch();
        System.out.println();
        
        System.out.println("5. Finally Block:");
        patterns.demonstrateFinally();
        System.out.println();
        
        System.out.println("6. Custom Exception with Chaining:");
        try {
            patterns.processPayment(1000, 500);
        } catch (InsufficientBalanceException e) {
            System.err.println("Caught: " + e.getMessage());
            System.err.println("Cause: " + e.getCause());
        }
        System.out.println();
    }
}