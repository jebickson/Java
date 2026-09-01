// Abstract Bank Account
abstract class BankAccount {
    protected String accountNumber;
    protected String accountHolder;
    protected double balance;
    protected double interestRate;
    
    public BankAccount(String accountNumber, String accountHolder, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.interestRate = 0.03; // Default 3%
    }
    
    // Abstract methods
    public abstract void deposit(double amount);
    public abstract void withdraw(double amount);
    public abstract double calculateInterest();
    public abstract String getAccountType();
    
    // Concrete methods
    public void displayBalance() {
        System.out.println("Account: " + accountNumber);
        System.out.println("Holder: " + accountHolder);
        System.out.println("Type: " + getAccountType());
        System.out.println("Balance: $" + balance);
        System.out.println("Interest Rate: " + (interestRate * 100) + "%");
        System.out.println("Interest Earned: $" + calculateInterest());
    }
    
    public double getBalance() { return balance; }
    public String getAccountNumber() { return accountNumber; }
}

// Savings Account
class SavingsAccount extends BankAccount {
    private int withdrawalsLimit;
    private int withdrawalsMade;
    private double minimumBalance;
    
    public SavingsAccount(String accountNumber, String accountHolder, double initialBalance) {
        super(accountNumber, accountHolder, initialBalance);
        this.withdrawalsLimit = 6;
        this.withdrawalsMade = 0;
        this.minimumBalance = 500;
        this.interestRate = 0.045; // 4.5% for savings
    }
    
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " to savings account");
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    @Override
    public void withdraw(double amount) {
        if (withdrawalsMade >= withdrawalsLimit) {
            System.out.println("Withdrawal limit exceeded!");
            return;
        }
        
        if (amount > 0 && amount <= balance) {
            if (balance - amount >= minimumBalance) {
                balance -= amount;
                withdrawalsMade++;
                System.out.println("Withdrew $" + amount + " from savings account");
            } else {
                System.out.println("Minimum balance of $" + minimumBalance + " required");
            }
        } else {
            System.out.println("Invalid withdrawal amount or insufficient balance");
        }
    }
    
    @Override
    public double calculateInterest() {
        return balance * interestRate;
    }
    
    @Override
    public String getAccountType() {
        return "Savings Account";
    }
    
    public void resetWithdrawals() {
        withdrawalsMade = 0;
        System.out.println("Withdrawal limit reset for next month");
    }
}

// Checking Account
class CheckingAccount extends BankAccount {
    private double overdraftLimit;
    private int transactionCount;
    private double transactionFee;
    
    public CheckingAccount(String accountNumber, String accountHolder, double initialBalance) {
        super(accountNumber, accountHolder, initialBalance);
        this.overdraftLimit = 1000;
        this.transactionCount = 0;
        this.transactionFee = 2.5;
        this.interestRate = 0.01; // 1% for checking
    }
    
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionCount++;
            System.out.println("Deposited $" + amount + " to checking account");
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
    
    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance + overdraftLimit) {
                balance -= amount;
                transactionCount++;
                System.out.println("Withdrew $" + amount + " from checking account");
                
                if (balance < 0) {
                    System.out.println("Account is overdrawn by $" + Math.abs(balance));
                }
            } else {
                System.out.println("Withdrawal exceeds overdraft limit");
            }
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }
    
    @Override
    public double calculateInterest() {
        return balance > 0 ? balance * interestRate : 0;
    }
    
    @Override
    public String getAccountType() {
        return "Checking Account";
    }
    
    public void applyTransactionFee() {
        if (transactionCount > 10) {
            double fee = (transactionCount - 10) * transactionFee;
            balance -= fee;
            System.out.println("Applied transaction fee: $" + fee);
        }
    }
    
    public int getTransactionCount() {
        return transactionCount;
    }
}

// Fixed Deposit Account
class FixedDepositAccount extends BankAccount {
    private int termMonths;
    private double penaltyRate;
    private boolean matured;
    
    public FixedDepositAccount(String accountNumber, String accountHolder, 
                              double initialBalance, int termMonths) {
        super(accountNumber, accountHolder, initialBalance);
        this.termMonths = termMonths;
        this.penaltyRate = 0.02;
        this.matured = false;
        this.interestRate = 0.07; // 7% for fixed deposit
    }
    
    @Override
    public void deposit(double amount) {
        System.out.println("Cannot deposit to fixed deposit account until maturity");
    }
    
    @Override
    public void withdraw(double amount) {
        if (matured) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrew $" + amount + " from fixed deposit");
            } else {
                System.out.println("Invalid withdrawal amount");
            }
        } else {
            System.out.println("Premature withdrawal! Penalty applies.");
            double penalty = amount * penaltyRate;
            if (amount + penalty <= balance) {
                balance -= (amount + penalty);
                System.out.println("Withdrew $" + amount + " with $" + penalty + " penalty");
            } else {
                System.out.println("Insufficient balance after penalty");
            }
        }
    }
    
    @Override
    public double calculateInterest() {
        return balance * interestRate * (termMonths / 12.0);
    }
    
    @Override
    public String getAccountType() {
        return "Fixed Deposit Account";
    }
    
    public void mature() {
        matured = true;
        double interest = calculateInterest();
        balance += interest;
        System.out.println("FD matured! Interest earned: $" + interest);
    }
}
