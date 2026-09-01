import java.util.Scanner;

public class MultiCriteriaSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        
        String[] names = new String[n];
        int[] ages = new int[n];
        double[] grades = new double[n];
        
        // Input student data
        for (int i = 0; i < n; i++) {
            System.out.println("\nStudent " + (i + 1) + ":");
            System.out.print("Name: ");
            names[i] = scanner.nextLine();
            System.out.print("Age: ");
            ages[i] = scanner.nextInt();
            System.out.print("Grade: ");
            grades[i] = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
        }
        
        // Display menu
        System.out.println("\n=== SORT BY ===");
        System.out.println("1. Name (Alphabetical)");
        System.out.println("2. Age (Ascending)");
        System.out.println("3. Grade (Descending)");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        
        // Sort based on choice
        switch (choice) {
            case 1:
                sortByName(names, ages, grades);
                break;
            case 2:
                sortByAge(names, ages, grades);
                break;
            case 3:
                sortByGrade(names, ages, grades);
                break;
            default:
                System.out.println("Invalid choice!");
                return;
        }
        
        // Display sorted data
        displayStudents(names, ages, grades);
        scanner.close();
    }
    
    public static void sortByName(String[] names, int[] ages, double[] grades) {
        int n = names.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (names[i].compareTo(names[j]) > 0) {
                    // Swap all corresponding elements
                    swap(names, i, j);
                    swap(ages, i, j);
                    swap(grades, i, j);
                }
            }
        }
    }
    
    public static void sortByAge(String[] names, int[] ages, double[] grades) {
        int n = ages.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ages[i] > ages[j]) {
                    swap(names, i, j);
                    swap(ages, i, j);
                    swap(grades, i, j);
                }
            }
        }
    }
    
    public static void sortByGrade(String[] names, int[] ages, double[] grades) {
        int n = grades.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (grades[i] < grades[j]) { // Descending order
                    swap(names, i, j);
                    swap(ages, i, j);
                    swap(grades, i, j);
                }
            }
        }
    }
    
    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void swap(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void displayStudents(String[] names, int[] ages, double[] grades) {
        System.out.println("\n=== SORTED STUDENT DATA ===");
        System.out.printf("%-15s %-10s %-10s%n", "Name", "Age", "Grade");
        System.out.println("-------------------------------");
        for (int i = 0; i < names.length; i++) {
            System.out.printf("%-15s %-10d %-10.2f%n", names[i], ages[i], grades[i]);
        }
    }
}