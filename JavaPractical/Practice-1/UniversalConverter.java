import java.util.Scanner;

public class UniversalConverter {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== UNIVERSAL UNIT CONVERTER ===");
            System.out.println("1. Temperature");
            System.out.println("2. Currency");
            System.out.println("3. Length");
            System.out.println("4. Weight");
            System.out.println("5. Exit");
            System.out.print("Select conversion type: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1: convertTemperature(); break;
                case 2: convertCurrency(); break;
                case 3: convertLength(); break;
                case 4: convertWeight(); break;
                case 5: 
                    System.out.println("Thank you for using Universal Converter!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
    
    private static void convertTemperature() {
        System.out.println("\n--- Temperature Conversion ---");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        
        System.out.print("Enter value: ");
        double value = scanner.nextDouble();
        
        if (choice == 1) {
            double result = (value * 9/5) + 32;
            System.out.printf("%.2f°C = %.2f°F%n", value, result);
        } else {
            double result = (value - 32) * 5/9;
            System.out.printf("%.2f°F = %.2f°C%n", value, result);
        }
    }
    
    private static void convertCurrency() {
        System.out.println("\n--- Currency Conversion ---");
        System.out.println("1. USD to EUR");
        System.out.println("2. EUR to USD");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        
        System.out.print("Enter amount: ");
        double amount = scanner.nextDouble();
        double rate = 0.92;
        
        if (choice == 1) {
            System.out.printf("%.2f USD = %.2f EUR%n", amount, amount * rate);
        } else {
            System.out.printf("%.2f EUR = %.2f USD%n", amount, amount / rate);
        }
    }
    
    private static void convertLength() {
        System.out.println("\n--- Length Conversion ---");
        System.out.println("1. Meters to Feet");
        System.out.println("2. Feet to Meters");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        
        System.out.print("Enter length: ");
        double length = scanner.nextDouble();
        
        if (choice == 1) {
            System.out.printf("%.2f m = %.2f ft%n", length, length * 3.28084);
        } else {
            System.out.printf("%.2f ft = %.2f m%n", length, length * 0.3048);
        }
    }
    
    private static void convertWeight() {
        System.out.println("\n--- Weight Conversion ---");
        System.out.println("1. Kilograms to Pounds");
        System.out.println("2. Pounds to Kilograms");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        
        System.out.print("Enter weight: ");
        double weight = scanner.nextDouble();
        
        if (choice == 1) {
            System.out.printf("%.2f kg = %.2f lbs%n", weight, weight * 2.20462);
        } else {
            System.out.printf("%.2f lbs = %.2f kg%n", weight, weight * 0.453592);
        }
    }
}