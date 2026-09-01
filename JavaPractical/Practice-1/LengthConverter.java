import java.util.Scanner;

public class LengthConverter {
    private static final double METERS_TO_FEET = 3.28084;
    private static final double FEET_TO_METERS = 0.3048;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== LENGTH CONVERTER ===");
        System.out.println("1. Meters to Feet");
        System.out.println("2. Feet to Meters");
        System.out.println("3. Kilometers to Miles");
        System.out.println("4. Miles to Kilometers");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        
        System.out.print("Enter length: ");
        double length = scanner.nextDouble();
        
        switch (choice) {
            case 1:
                System.out.printf("%.2f meters = %.2f feet%n", length, metersToFeet(length));
                break;
            case 2:
                System.out.printf("%.2f feet = %.2f meters%n", length, feetToMeters(length));
                break;
            case 3:
                System.out.printf("%.2f km = %.2f miles%n", length, kmToMiles(length));
                break;
            case 4:
                System.out.printf("%.2f miles = %.2f km%n", length, milesToKm(length));
                break;
            default:
                System.out.println("Invalid choice!");
        }
        
        scanner.close();
    }
    
    public static double metersToFeet(double meters) {
        return meters * METERS_TO_FEET;
    }
    
    public static double feetToMeters(double feet) {
        return feet * FEET_TO_METERS;
    }
    
    public static double kmToMiles(double km) {
        return km * 0.621371;
    }
    
    public static double milesToKm(double miles) {
        return miles * 1.60934;
    }
}