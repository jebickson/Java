import java.util.Stack;

public class TowerOfHanoiVisual {
    private Stack<Integer>[] towers;
    private int totalDisks;
    private int moves;
    
    @SuppressWarnings("unchecked")
    public TowerOfHanoiVisual(int disks) {
        this.totalDisks = disks;
        this.moves = 0;
        towers = new Stack[3];
        
        // Initialize three towers
        for (int i = 0; i < 3; i++) {
            towers[i] = new Stack<>();
        }
        
        // Push disks to first tower (disk 1 is smallest at top)
        for (int i = disks; i >= 1; i--) {
            towers[0].push(i);
        }
        
        System.out.println("Initial Tower Configuration:");
        displayTowers();
        System.out.println("====================================\n");
    }
    
    public void solve() {
        solveHanoi(totalDisks, 0, 1, 2);
        System.out.println("\n✅ Solved in " + moves + " moves!");
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
        if (towers[source].isEmpty()) {
            System.out.println("❌ Invalid move: Tower " + (char)('A' + source) + " is empty!");
            return;
        }
        
        int disk = towers[source].pop();
        towers[destination].push(disk);
        moves++;
        
        System.out.println("Move #" + moves + ": Disk " + disk + 
                          " from " + (char)('A' + source) + 
                          " → " + (char)('A' + destination));
        displayTowers();
        System.out.println("------------------------------------");
    }
    
    public void displayTowers() {
        for (int i = 0; i < 3; i++) {
            System.out.print("Tower " + (char)('A' + i) + ": ");
            if (towers[i].isEmpty()) {
                System.out.println("Empty");
            } else {
                System.out.println(towers[i]);
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== TOWER OF HANOI VISUALIZATION ===\n");
        
        int disks = 3;
        TowerOfHanoiVisual toh = new TowerOfHanoiVisual(disks);
        toh.solve();
        
        System.out.println("\n=== TOWER OF HANOI WITH 4 DISKS ===\n");
        TowerOfHanoiVisual toh2 = new TowerOfHanoiVisual(4);
        toh2.solve();
    }
}
