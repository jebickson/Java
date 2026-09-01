// File: com/company/exceptions/ExceptionHandlingPatterns.java
package com.company.exceptions;

import java.io.*;
import java.util.*;

public class ExceptionHandlingPatterns {
    
    // Pattern 1: Try-Catch-Finally
    public void readFileWithTryCatchFinally(String filename) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
            System.err.println("Error details: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                    System.out.println("File closed successfully");
                }
            } catch (IOException e) {
                System.err.println("Error closing file: " + e.getMessage());
            }
        }
    }
    
    // Pattern 2: Try-with-Resources (Java 7+)
    public void readFileWithTryWithResources(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filename);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    
    // Pattern 3: Multiple Catch Blocks
    public void processNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            double result = 100 / number;
            System.out.println("Result: " + result);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format: " + input);
        } catch (ArithmeticException e) {
            System.err.println("Cannot divide by zero");
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
        }
    }
    
    // Pattern 4: Nested Try-Catch
    public void nestedTryCatch() {
        try {
            System.out.println("Outer try block");
            try {
                System.out.println("Inner try block");
                int[] arr = new int[5];
                arr[10] = 50; // Will throw ArrayIndexOutOfBoundsException
            } catch (ArrayIndexOutOfBoundsException e) {
                System.err.println("Inner catch: " + e.getMessage());
                throw new RuntimeException("Inner exception rethrown", e);
            }
        } catch (RuntimeException e) {
            System.err.println("Outer catch: " + e.getMessage());
            System.err.println("Cause: " + e.getCause());
        }
    }
    
    // Pattern 5: Throw and Throws
    public void validateAge(int age) throws IllegalArgumentException {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative: " + age);
        }
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above: " + age);
        }
        if (age > 120) {
            throw new IllegalArgumentException("Invalid age: " + age);
        }
        System.out.println("Valid age: " + age);
    }
    
    // Pattern 6: Custom Exception with Chaining
    public void processPayment(double amount, double balance) 
            throws InsufficientBalanceException {
        if (amount > balance) {
            InsufficientBalanceException e = new InsufficientBalanceException(
                "Insufficient balance for payment",
                balance,
                amount
            );
            // Add cause
            e.initCause(new IllegalArgumentException("Transaction amount exceeds balance"));
            throw e;
        }
    }
    
    // Pattern 7: Finally Block (Always executes)
    public void demonstrateFinally() {
        try {
            System.out.println("Try block executing...");
            if (new Random().nextBoolean()) {
                throw new RuntimeException("Random exception");
            }
            System.out.println("Try block completed");
        } catch (RuntimeException e) {
            System.err.println("Catch block: " + e.getMessage());
        } finally {
            System.out.println("Finally block always executes!");
        }
    }
    
    // Pattern 8: Try with Multiple Resources
    public void readMultipleFiles(String file1, String file2) {
        try (BufferedReader reader1 = new BufferedReader(new FileReader(file1));
             BufferedReader reader2 = new BufferedReader(new FileReader(file2))) {
            
            System.out.println("Reading file1: " + reader1.readLine());
            System.out.println("Reading file2: " + reader2.readLine());
            
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("IO Error: " + e.getMessage());
        }
    }
}
