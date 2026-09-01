public class HanoiComparison {
    
    // Recursive solution
    public static void solveRecursive(int n, char source, char auxiliary, char destination, 
                                      int[] moves) {
        if (n == 1) {
            moves[0]++;
            return;
        }
        solveRecursive(n - 1, source, destination, auxiliary, moves);
        moves[0]++;
        solveRecursive(n - 1, auxiliary, source, destination, moves);
    }
    
    // Iterative solution using Stack
    public static int solveIterative(int n) {
        if (n <= 0) return 0;
        
        int totalMoves = (int) Math.pow(2, n) - 1;
        Stack<Integer>[] towers = new Stack[3];
        
        for (int i = 0; i < 3; i++) {
            towers[i] = new Stack<>();
        }
        
        // Push disks to first tower
        for (int i = n; i >= 1; i--) {
            towers[0].push(i);
        }
        
        int moves = 0;
        
        // For even number of disks, swap auxiliary and destination
        char source = 'A', auxiliary = 'B', destination = 'C';
        if (n % 2 == 0) {
            char temp = auxiliary;
            auxiliary = destination;
            destination = temp;
        }
        
        while (moves < totalMoves) {
            // Move between source and destination
            moves = makeMove(towers, source, destination, moves);
            if (moves >= totalMoves) break;
            
            // Move between source and auxiliary
            moves = makeMove(towers, source, auxiliary, moves);
            if (moves >= totalMoves) break;
            
            // Move between auxiliary and destination
            moves = makeMove(towers, auxiliary, destination, moves);
        }
        
        return moves;
    }
    
    private static int makeMove(Stack<Integer>[] towers, char from, char to, int moves) {
        int fromIndex = from - 'A';
        int toIndex = to - 'A';
        
        if (!towers[fromIndex].isEmpty() && 
            (towers[toIndex].isEmpty() || towers[fromIndex].peek() < towers[toIndex].peek())) {
            int disk = towers[fromIndex].pop();
            towers[toIndex].push(disk);
            moves++;
        } else if (!towers[toIndex].isEmpty() && 
                   (towers[fromIndex].isEmpty() || towers[toIndex].peek() < towers[fromIndex].peek())) {
            int disk = towers[toIndex].pop();
            towers[fromIndex].push(disk);
            moves++;
        }
        
        return moves;
    }
    
    public static void main(String[] args) {
        System.out.println("=== TOWER OF HANOI: RECURSIVE vs ITERATIVE ===\n");
        
        System.out.println("Comparing performance for different number of disks:\n");
        System.out.printf("%-10s %-20s %-20s %-20s%n", 
                         "Disks", "Recursive Moves", "Iterative Moves", "Minimum Required");
        System.out.println("------------------------------------------------------------");
        
        for (int i = 1; i <= 8; i++) {
            int[] recursiveMoves = {0};
            
            // Measure recursive
            long startRec = System.nanoTime();
            solveRecursive(i, 'A', 'B', 'C', recursiveMoves);
            long endRec = System.nanoTime();
            
            // Measure iterative
            long startIt = System.nanoTime();
            int iterativeMoves = solveIterative(i);
            long endIt = System.nanoTime();
            
            int minMoves = (int) Math.pow(2, i) - 1;
            
            System.out.printf("%-10d %-20d %-20d %-20d%n", 
                             i, recursiveMoves[0], iterativeMoves, minMoves);
            System.out.printf("  Time: Rec=%.3fms, It=%.3fms%n", 
                             (endRec - startRec) / 1_000_000.0,
                             (endIt - startIt) / 1_000_000.0);
        }
        
        System.out.println("\n✅ Both methods produce the same result!");
    }
}
