class PriorityItem implements Comparable<PriorityItem> {
    private int value;
    private int priority;
    
    public PriorityItem(int value, int priority) {
        this.value = value;
        this.priority = priority;
    }
    
    public int getValue() {
        return value;
    }
    
    public int getPriority() {
        return priority;
    }
    
    @Override
    public int compareTo(PriorityItem other) {
        // Higher priority value = higher priority
        return Integer.compare(other.priority, this.priority);
    }
    
    @Override
    public String toString() {
        return value + "(P:" + priority + ")";
    }
}

public class PriorityQueue {
    private GenericQueue<PriorityItem> queue;
    
    public PriorityQueue(int capacity) {
        queue = new GenericQueue<>(capacity);
    }
    
    public void enqueue(int value, int priority) {
        PriorityItem item = new PriorityItem(value, priority);
        
        // If queue is empty, just add
        if (queue.isEmpty()) {
            queue.enqueue(item);
            return;
        }
        
        // Create a temporary queue
        GenericQueue<PriorityItem> temp = new GenericQueue<>(queue.getCapacity());
        
        // Move elements with higher or equal priority to temp
        boolean added = false;
        while (!queue.isEmpty()) {
            PriorityItem current = queue.dequeue();
            if (!added && item.getPriority() > current.getPriority()) {
                temp.enqueue(item);
                added = true;
            }
            temp.enqueue(current);
        }
        
        // If item wasn't added, add it at the end
        if (!added) {
            temp.enqueue(item);
        }
        
        // Copy back to original queue
        while (!temp.isEmpty()) {
            queue.enqueue(temp.dequeue());
        }
    }
    
    public PriorityItem dequeue() {
        return queue.dequeue();
    }
    
    public PriorityItem peek() {
        return queue.peek();
    }
    
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    public int getSize() {
        return queue.getSize();
    }
    
    public void display() {
        System.out.print("Priority Queue: ");
        queue.display();
    }
    
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(10);
        
        System.out.println("=== PRIORITY QUEUE ===");
        pq.enqueue(10, 1);
        pq.enqueue(20, 3);
        pq.enqueue(30, 2);
        pq.enqueue(40, 5);
        pq.enqueue(50, 4);
        
        pq.display();
        
        System.out.println("\nDequeue operations:");
        while (!pq.isEmpty()) {
            PriorityItem item = pq.dequeue();
            System.out.println("Dequeued: " + item);
        }
    }
}