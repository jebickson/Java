// File: com/company/test/ExceptionTest.java
package com.company.test;

import com.company.banking.*;
import com.company.exceptions.*;

public class ExceptionTest {
    
    public static void main(String[] args) {
        System.out.println("=== COMPREHENSIVE EXCEPTION TEST ===\n");
        
        BankService service = new BankService();
        
        // Test 1: Create accounts
        System.out.println("1. Creating Accounts:");
        try {
            service.createAccount("A001", "User1", 1000, "Savings");
            service.createAccount("A002", "User2", 2000, "Checking");
            System.out.println("Accounts created successfully");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Test 2: Duplicate account creation
        System.out.println("\n2. Duplicate Account Creation:");
        try {
            service.createAccount("A001", "User3", 500, "Savings");
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }
        
        // Test 3: Invalid account operations
        System.out.println("\n3. Invalid Account Operations:");
        try {
            service.deposit("INVALID", 100);
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }
        
        // Test 4: Negative amount operations
        System.out.println("\n4. Negative Amount Operations:");
        try {
            service.deposit("A001", -50);
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
            if (e instanceof NegativeAmountException) {
                NegativeAmountException nae = (NegativeAmountException) e;
                System.out.println("Amount: $" + nae.getAmount());
            }
        }
        
        // Test 5: Insufficient balance
        System.out.println("\n5. Insufficient Balance:");
        try {
            service.withdraw("A001", 5000);
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
            if (e instanceof InsufficientBalanceException) {
                InsufficientBalanceException ibe = (InsufficientBalanceException) e;
                System.out.println("Balance: $" + ibe.getCurrentBalance());
                System.out.println("Attempted: $" + ibe.getAttemptedWithdrawal());
            }
        }
        
        // Test 6: Successful transactions
        System.out.println("\n6. Successful Transactions:");
        try {
            service.deposit("A001", 500);
            service.withdraw("A001", 200);
            service.transfer("A001", "A002", 300);
            System.out.println("All transactions successful");
            service.displayAccount("A001");
            service.displayAccount("A002");
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
        
        // Test 7: Transfer to same account
        System.out.println("\n7. Transfer to Same Account:");
        try {
            service.transfer("A001", "A001", 100);
        } catch (Exception e) {
            System.out.println("Expected error: " + e.getMessage());
        }
        
        // Test 8: Multiple exceptions in one operation
        System.out.println("\n8. Multiple Exceptions Handling:");
        performOperationsWithCatchAll(service);
        
        // Test 9: Finally block demonstration
        System.out.println("\n9. Finally Block Demo:");
        testFinallyBlock(service);
        
        // Test 10: Print final state
        System.out.println("\n10. Final State:");
        service.displayAllAccounts();
        service.displayTransactionLog();
        
        System.out.println("\n=== ALL TESTS COMPLETED ===");
    }
    
    private static void performOperationsWithCatchAll(BankService service) {
        String[] testOperations = {
            "deposit|INVALID|100",
            "withdraw|A001|-50",
            "transfer|A001|INVALID|200",
            "deposit|A001|abc",
            "withdraw|A001|5000"
        };
        
        for (String operation : testOperations) {
            try {
                String[] parts = operation.split("\\|");
                String type = parts[0];
                
                System.out.println("Testing: " + operation);
                
                switch (type) {
                    case "deposit":
                        service.deposit(parts[1], Double.parseDouble(parts[2]));
                        break;
                    case "withdraw":
                        service.withdraw(parts[1], Double.parseDouble(parts[2]));
                        break;
                    case "transfer":
                        service.transfer(parts[1], parts[2], Double.parseDouble(parts[3]));
                        break;
                }
            } catch (NumberFormatException e) {
                System.out.println("  - Number format error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("  - Exception: " + e.getClass().getSimpleName() + 
                                 ": " + e.getMessage());
            }
        }
    }
    
    private static void testFinallyBlock(BankService service) {
        System.out.println("Starting finally block test...");
        
        try {
            System.out.println("Try: Attempting operation");
            service.withdraw("A001", 100);
        } catch (InsufficientBalanceException e) {
            System.err.println("Catch: " + e.getMessage());
        } finally {
            System.out.println("Finally: This always executes!");
            System.out.println("Current balance: $" + 
                              (service.findAccount("A001").getBalance()));
        }
    }
}