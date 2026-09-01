import java.util.Scanner;
import java.util.Stack;

public class HanoiGame {
    private Stack<Integer>[] towers;
    private int totalDisks;
    private int moves;
    private boolean isGameOver;
    
    @SuppressWarnings("unchecked")
    public HanoiGame(int disks) {
        this.totalDisks = disks;
        this.moves = 0;
        this.isGameOver = false;
        
        towers = new Stack[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Stack<>();
        }
        
        for (int i = disks; i >= 1; i--) {
            towers[0].push(i);
        }
    }
    
    public void displayGame() {
        System.out.println("\n┌────────────────────────────────────────┐");
        System.out.println("│         TOWER OF HANOI GAME            │");
        System.out.println("├────────────────────────────────────────┤");
        System.out.println("│ Moves: " + moves + "                    │");
        System.out.println("│ Disks: " + totalDisks + "                  │");
        System.out.println("└────────────────────────────────────────┘");
        
        int maxHeight = totalDisks;
        for (int level = maxHeight - 1; level >= 0; level--) {
            System.out.print("  ");
            for (int tower = 0; tower < 3; tower++) {
                if (towers[tower].size() > level) {
                    int disk = towers[tower].get(level);
                    int width = disk * 2 + 1;
                    String diskStr = "=".repeat(Math.min(width, 20));
                    System.out.printf("%-15s", diskStr);
                } else {
                    System.out.print("  │           ");
                }
            }
            System.out.println();
        }
        System.out.println("  A            B            C");
        System.out.println("──────────────────────────────────────────");
    }
    
    public boolean moveDisk(int from, int to) {
        if (from == to) {
            System.out.println("⚠️ Cannot move disk to the same tower!");
            return false;
        }
        
        if (from < 0 || from > 2 || to < 0 || to > 2) {
            System.out.println("⚠️ Invalid tower number! Use 0, 1, or 2.");
            return false;
        }
        
        if (towers[from].isEmpty()) {
            System.out.println("⚠️ No disk to move from Tower " + (char)('A' + from) + "!");
            return false;
        }
        
        if (!towers[to].isEmpty() && towers[from].peek() > towers[to].peek()) {
            System.out.println("⚠️ Cannot place larger disk on smaller disk!");
            return false;
        }
        
        int disk = towers[from].pop();
        towers[to].push(disk);
        moves++;
        
        System.out.println("✅ Moved disk " + disk + " from " + (char)('A' + from) + 
                          " to " + (char)('A' + to));
        
        // Check if game is won
        if (towers[2].size() == totalDisks) {
            isGameOver = true;
            System.out.println("\n🎉 CONGRATULATIONS! You solved the puzzle!");
            System.out.println("Total moves: " + moves);
            System.out.println("Minimum moves: " + ((int) Math.pow(2, totalDisks) - 1));
        }
        
        return true;
    }
    
    public boolean isGameOver() {
        return isGameOver;
    }
    
    public void showHint() {
        System.out.println("\n💡 HINT:");
        System.out.println("  • Use Tower B as auxiliary");
        System.out.println("  • Move smaller disks first");
        System.out.println("  • Plan your moves ahead");
        System.out.println("  • Minimum moves needed: " + ((int) Math.pow(2, totalDisks) - 1));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("=== TOWER OF HANOI INTERACTIVE GAME ===\n");
        System.out.print("Choose difficulty (Enter number of disks, 2-6): ");
        int disks = scanner.nextInt();
        
        if (disks < 2 || disks > 6) {
            System.out.println("Invalid choice! Using default 3 disks.");
            disks = 3;
        }
        
        HanoiGame game = new HanoiGame(disks);
        game.displayGame();
        
        while (!game.isGameOver()) {
            System.out.println("\nOptions:");
            System.out.println("  1. Make a move");
            System.out.println("  2. Show hint");
            System.out.println("  3. Restart game");
            System.out.println("  4. Exit game");
            System.out.print("Your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("\nEnter source tower (A=0, B=1, C=2): ");
                    int from = scanner.nextInt();
                    System.out.print("Enter destination tower (A=0, B=1, C=2): ");
                    int to = scanner.nextInt();
                    game.moveDisk(from, to);
                    game.displayGame();
                    break;
                    
                case 2:
                    game.showHint();
                    break;
                    
                case 3:
                    game = new HanoiGame(disks);
                    System.out.println("\n🔄 Game restarted!");
                    game.displayGame();
                    break;
                    
                case 4:
                    System.out.println("👋 Thanks for playing!");
                    scanner.close();
                    return;
                    
                default:
                    System.out.println("⚠️ Invalid choice!");
            }
        }
        
        scanner.close();
    }
}
