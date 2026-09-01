import java.util.Arrays;
import java.util.Scanner;

public class SortingDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        while (true) {
            System.out.println("\n=== SORTING ALGORITHMS MENU ===");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Insertion Sort");
            System.out.println("4. Merge Sort");
            System.out.println("5. Quick Sort");
            System.out.println("6. Compare All Algorithms");
            System.out.println("7. Exit");
            System.out.print("Choose an algorithm: ");
            
            int choice = scanner.nextInt();
            
            if (choice == 7) {
                System.out.println("Thank you for using Sorting Demo!");
                break;
            }
            
            // Create a copy for sorting
            int[] copy = Arrays.copyOf(arr, arr.length);
            
            long startTime = System.nanoTime();
            
            switch (choice) {
                case 1:
                    bubbleSort(copy);
                    System.out.println("Bubble Sort Result: " + Arrays.toString(copy));
                    break;
                case 2:
                    selectionSort(copy);
                    System.out.println("Selection Sort Result: " + Arrays.toString(copy));
                    break;
                case 3:
                    insertionSort(copy);
                    System.out.println("Insertion Sort Result: " + Arrays.toString(copy));
                    break;
                case 4:
                    mergeSort(copy, 0, copy.length - 1);
                    System.out.println("Merge Sort Result: " + Arrays.toString(copy));
                    break;
                case 5:
                    quickSort(copy, 0, copy.length - 1);
                    System.out.println("Quick Sort Result: " + Arrays.toString(copy));
                    break;
                case 6:
                    compareAlgorithms(copy);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
            
            long endTime = System.nanoTime();
            if (choice >= 1 && choice <= 5) {
                System.out.println("Time taken: " + (endTime - startTime) / 1000000 + " ms");
            }
        }
        
        scanner.close();
    }
    
    // All sorting methods from previous examples go here...
    // (bubbleSort, selectionSort, insertionSort, mergeSort, quickSort)
    
    public static void compareAlgorithms(int[] arr) {
        System.out.println("\n=== COMPARISON OF SORTING ALGORITHMS ===");
        System.out.println("Array size: " + arr.length);
        
        // Test each algorithm
        int[][] testArrays = new int[5][];
        for (int i = 0; i < 5; i++) {
            testArrays[i] = Arrays.copyOf(arr, arr.length);
        }
        
        long[] times = new long[5];
        String[] names = {"Bubble", "Selection", "Insertion", "Merge", "Quick"};
        
        // Bubble Sort
        long start = System.nanoTime();
        bubbleSort(testArrays[0]);
        times[0] = System.nanoTime() - start;
        
        // Selection Sort
        start = System.nanoTime();
        selectionSort(testArrays[1]);
        times[1] = System.nanoTime() - start;
        
        // Insertion Sort
        start = System.nanoTime();
        insertionSort(testArrays[2]);
        times[2] = System.nanoTime() - start;
        
        // Merge Sort
        start = System.nanoTime();
        mergeSort(testArrays[3], 0, testArrays[3].length - 1);
        times[3] = System.nanoTime() - start;
        
        // Quick Sort
        start = System.nanoTime();
        quickSort(testArrays[4], 0, testArrays[4].length - 1);
        times[4] = System.nanoTime() - start;
        
        // Display results
        System.out.println("\nAlgorithm\tTime (ms)\tSorted Correctly");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < 5; i++) {
            boolean correct = isSorted(testArrays[i]);
            System.out.printf("%-10s\t%8d\t%s%n", 
                names[i], times[i] / 1000000, correct ? "✓" : "✗");
        }
    }
    
    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
    
    // Include all sorting method implementations here
    // (bubbleSort, selectionSort, insertionSort, mergeSort, quickSort)
    
    public static void bubbleSort(int[] arr) {
        // Implementation from above
    }
    
    public static void selectionSort(int[] arr) {
        // Implementation from above
    }
    
    public static void insertionSort(int[] arr) {
        // Implementation from above
    }
    
    public static void mergeSort(int[] arr, int left, int right) {
        // Implementation from above
    }
    
    public static void quickSort(int[] arr, int low, int high) {
        // Implementation from above
    }
}