import java.util.Scanner;

public class CurrencyConverter {
    private static final double EXCHANGE_RATE = 0.92; // 1 USD = 0.92 EUR
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== CURRENCY CONVERTER ===");
        System.out.println("1. USD to EUR");
        System.out.println("2. EUR to USD");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        
        if (choice == 1) {
            double result = usdToEur(amount);
            System.out.printf("%.2f USD = %.2f EUR%n", amount, result);
        } else if (choice == 2) {
            double result = eurToUsd(amount);
            System.out.printf("%.2f EUR = %.2f USD%n", amount, result);
        } else {
            System.out.println("Invalid choice!");
        }
        
        scanner.close();
    }
    
    public static double usdToEur(double usd) {
        return usd * EXCHANGE_RATE;
    }
    
    public static double eurToUsd(double eur) {
        return eur / EXCHANGE_RATE;
    }
}