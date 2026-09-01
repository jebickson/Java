import java.util.Scanner;

public class WeightConverter {
    private static final double KG_TO_LBS = 2.20462;
    private static final double LBS_TO_KG = 0.453592;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== WEIGHT CONVERTER ===");
        System.out.println("1. Kilograms to Pounds");
        System.out.println("2. Pounds to Kilograms");
        System.out.println("3. Grams to Ounces");
        System.out.println("4. Ounces to Grams");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        
        System.out.print("Enter weight: ");
        double weight = scanner.nextDouble();
        
        String[] options = {
            "kg to lbs", "lbs to kg", "g to oz", "oz to g"
        };
        
        double result = 0;
        switch (choice) {
            case 1: result = kgToLbs(weight); break;
            case 2: result = lbsToKg(weight); break;
            case 3: result = gramsToOunces(weight); break;
            case 4: result = ouncesToGrams(weight); break;
            default: System.out.println("Invalid choice!"); return;
        }
        
        System.out.printf("%.2f %s = %.2f %s%n", 
            weight, options[(choice-1)*2], result, options[(choice-1)*2 + 1]);
        
        scanner.close();
    }
    
    public static double kgToLbs(double kg) { return kg * KG_TO_LBS; }
    public static double lbsToKg(double lbs) { return lbs * LBS_TO_KG; }
    public static double gramsToOunces(double g) { return g * 0.035274; }
    public static double ouncesToGrams(double oz) { return oz * 28.3495; }
}