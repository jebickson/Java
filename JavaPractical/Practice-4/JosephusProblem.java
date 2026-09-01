public class JosephusProblem {
    public static int josephus(int n, int k) {
        GenericQueue<Integer> queue = new GenericQueue<>(n);
        
        // Add all people to queue
        for (int i = 1; i <= n; i++) {
            queue.enqueue(i);
        }
        
        System.out.println("Initial queue: ");
        queue.display();
        
        while (queue.getSize() > 1) {
            // Skip k-1 people
            for (int i = 0; i < k - 1; i++) {
                int person = queue.dequeue();
                queue.enqueue(person);
            }
            
            // Remove kth person
            int eliminated = queue.dequeue();
            System.out.println("❌ Eliminated person " + eliminated);
        }
        
        int survivor = queue.peek();
        queue.display();
        return survivor;
    }
    
    public static void main(String[] args) {
        int n = 7; // Number of people
        int k = 3; // Step count
        
        System.out.println("=== JOSEPHUS PROBLEM ===");
        System.out.println("People: " + n + ", Step: " + k);
        
        int survivor = josephus(n, k);
        System.out.println("\n🎯 Survivor: Person " + survivor);
        
        // Test with different values
        System.out.println("\n--- Testing different combinations ---");
        int[][] tests = {{5, 2}, {10, 3}, {7, 4}};
        for (int[] test : tests) {
            int result = josephus(test[0], test[1]);
            System.out.println("n=" + test[0] + ", k=" + test[1] + " -> Survivor: " + result);
        }
    }
}