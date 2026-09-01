import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoiAdvanced {
    private Stack<Integer>[] towers;
    private int totalDisks;
    private int moves;
    private long startTime;
    private long endTime;
    
    @SuppressWarnings("unchecked")
    public TowerOfHanoiAdvanced(int disks) {
        this.totalDisks = disks;
        this.moves = 0;
        towers = new Stack[3];
        
        for (int i = 0; i < 3; i++) {
            towers[i] = new Stack<>();
        }
        
        for (int i = disks; i >= 1; i--) {
            towers[0].push(i);
        }
    }
    
    public void solve() {
        startTime = System.currentTimeMillis();
        solveHanoi(totalDisks, 0, 1, 2);
        endTime = System.currentTimeMillis();
    }
    
    private void solveHanoi(int n, int source, int auxiliary, int destination) {
        if (n == 1) {
            moveDisk(source, destination);
            return;
        }
        
        solveHanoi(n - 1, source, destination, auxiliary);
        moveDisk(source, destination);
        solveHanoi(n - 1, auxiliary, source, destination);
    }
    
    private void moveDisk(int source, int destination) {
        if (!towers[source].isEmpty()) {
            int disk = towers[source].pop();
            towers[destination].push(disk);
            moves++;
        }
    }
    
    public void displayTowers() {
        // Find max height for formatting
        int maxHeight = totalDisks;
        
        System.out.println("\n┌─────────────────────────────────────────┐");
        System.out.println("│           TOWER CONFIGURATION           │");
        System.out.println("├─────────┬─────────┬─────────────────────┤");
        
        for (int level = maxHeight - 1; level >= 0; level--) {
            System.out.print("│");
            for (int tower = 0; tower < 3; tower++) {
                if (towers[tower].size() > level) {
                    int disk = towers[tower].get(level);
                    System.out.printf(" %2d     │", disk);
                } else {
                    System.out.print("      │");
                }
            }
            System.out.println();
        }
        
        System.out.println("├─────────┼─────────┼─────────────────────┤");
        System.out.printf("│   A     │   B     │   C                │%n");
        System.out.println("└─────────┴─────────┴─────────────────────┘");
        
        System.out.println("Tower A: " + towers[0]);
        System.out.println("Tower B: " + towers[1]);
        System.out.println("Tower C: " + towers[2]);
    }
    
    public void showStats() {
        System.out.println("\n📊 STATISTICS:");
        System.out.println("  • Total Disks: " + totalDisks);
        System.out.println("  • Total Moves: " + moves);
        System.out.println("  • Minimum Moves Required: " + ((int) Math.pow(2, totalDisks) - 1));
        System.out.println("  • Time Taken: " + (endTime - startTime) + " ms");
        System.out.println("  • Moves Efficiency: " + 
                          String.format("%.2f%%", (double) moves / ((int) Math.pow(2, totalDisks) - 1) * 100));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== TOWER OF HANOI ADVANCED ===\n");
        System.out.println("The objective is to move all disks from Tower A to Tower C.");
        System.out.println("Rules:");
        System.out.println("  1. Only one disk can be moved at a time");
        System.out.println("  2. Each move involves taking the top disk from one tower");
        System.out.println("  3. No disk may be placed on top of a smaller disk");
        System.out.println("  4. Only top disk can be moved\n");
        
        System.out.print("Enter number of disks (1-10): ");
        int disks = scanner.nextInt();
        
        if (disks < 1 || disks > 10) {
            System.out.println("Invalid input! Using default 3 disks.");
            disks = 3;
        }
        
        TowerOfHanoiAdvanced toh = new TowerOfHanoiAdvanced(disks);
        
        System.out.println("\nInitial Configuration:");
        toh.displayTowers();
        
        System.out.println("\nPress Enter to start solving...");
        scanner.nextLine(); // Consume newline
        scanner.nextLine();
        
        System.out.println("🔄 Solving Tower of Hanoi...\n");
        toh.solve();
        
        System.out.println("✅ Solution Complete!");
        toh.displayTowers();
        toh.showStats();
        
        scanner.close();
    }
}
