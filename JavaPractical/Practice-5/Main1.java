import java.util.Date;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String accountType;
    private Date openingDate;
    private double interestRate;
    
    // Constructor 1: Basic account
    public BankAccount(String accountNumber, String accountHolder) {
        this(accountNumber, accountHolder, 0.0, "Savings");
        System.out.println("Basic account created");
    }
    
    // Constructor 2: Account with initial deposit
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this(accountNumber, accountHolder, balance, "Savings");
        System.out.println("Account with initial deposit created");
    }
    
    // Constructor 3: Full account details
    public BankAccount(String accountNumber, String accountHolder, double balance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
        this.accountType = accountType;
        this.openingDate = new Date();
        this.interestRate = getDefaultInterestRate(accountType);
        System.out.println("Full account details created");
    }
    
    // Constructor 4: Account with custom interest rate
    public BankAccount(String accountNumber, String accountHolder, double balance, 
                       String accountType, double interestRate) {
        this(accountNumber, accountHolder, balance, accountType);
        this.interestRate = interestRate;
        System.out.println("Account with custom interest rate created");
    }
    
    private double getDefaultInterestRate(String type) {
        if (type.equalsIgnoreCase("Savings")) {
            return 4.5;
        } else if (type.equalsIgnoreCase("Current")) {
            return 2.0;
        } else if (type.equalsIgnoreCase("Fixed Deposit")) {
            return 7.0;
        }
        return 3.0;
    }
    
    public void display() {
        System.out.println("\nBank Account Details:");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: $" + balance);
        System.out.println("Account Type: " + accountType);
        System.out.println("Opening Date: " + openingDate);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
    
    public static void main(String[] args) {
        System.out.println("=== BANK ACCOUNT (CONSTRUCTOR OVERLOADING) ===\n");
        
        BankAccount acc1 = new BankAccount("SAV001", "Alice Johnson");
        acc1.display();
        
        System.out.println("\n---");
        BankAccount acc2 = new BankAccount("SAV002", "Bob Wilson", 5000.0);
        acc2.display();
        
        System.out.println("\n---");
        BankAccount acc3 = new BankAccount("FD001", "Charlie Brown", 10000.0, "Fixed Deposit");
        acc3.display();
        
        System.out.println("\n---");
        BankAccount acc4 = new BankAccount("CUR001", "Diana Ross", 2000.0, "Current", 3.0);
        acc4.display();
    }
}