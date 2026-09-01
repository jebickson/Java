public class TowerOfHanoi {
    
    // Recursive method to solve Tower of Hanoi
    public void solveHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            return;
        }
        
        // Move n-1 disks from source to auxiliary using destination as helper
        solveHanoi(n - 1, source, destination, auxiliary);
        
        // Move the nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        
        // Move n-1 disks from auxiliary to destination using source as helper
        solveHanoi(n - 1, auxiliary, source, destination);
    }
    
    // Method to track moves count
    public void solveWithTracking(int n, char source, char auxiliary, char destination, 
                                  int[] moveCount) {
        if (n == 1) {
            moveCount[0]++;
            System.out.println("Move #" + moveCount[0] + ": Disk 1 from " + 
                              source + " → " + destination);
            return;
        }
        
        solveWithTracking(n - 1, source, destination, auxiliary, moveCount);
        
        moveCount[0]++;
        System.out.println("Move #" + moveCount[0] + ": Disk " + n + 
                          " from " + source + " → " + destination);
        
        solveWithTracking(n - 1, auxiliary, source, destination, moveCount);
    }
    
    // Method to get minimum moves without printing
    public int getMinimumMoves(int n) {
        return (int) Math.pow(2, n) - 1;
    }
    
    public static void main(String[] args) {
        TowerOfHanoi toh = new TowerOfHanoi();
        
        System.out.println("=== TOWER OF HANOI - CLASSIC SOLUTION ===\n");
        
        int disks = 3;
        System.out.println("Solving Tower of Hanoi with " + disks + " disks:");
        System.out.println("Rules: Move disks from Tower A to Tower C using Tower B\n");
        
        toh.solveHanoi(disks, 'A', 'B', 'C');
        
        System.out.println("\nMinimum moves required: " + toh.getMinimumMoves(disks));
        
        System.out.println("\n=== TOWER OF HANOI WITH MOVE TRACKING ===\n");
        int disks2 = 4;
        int[] moveCount = {0};
        System.out.println("Solving with " + disks2 + " disks (detailed moves):\n");
        toh.solveWithTracking(disks2, 'A', 'B', 'C', moveCount);
        System.out.println("\nTotal moves: " + moveCount[0]);
    }
}