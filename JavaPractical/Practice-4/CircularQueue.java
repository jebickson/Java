public class CircularQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;
    
    public CircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("❌ Queue Overflow! Cannot enqueue " + element);
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = element;
        size++;
        System.out.println("✅ Enqueued " + element + " to circular queue");
    }
    
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("❌ Queue Underflow! Cannot dequeue");
            return -1;
        }
        int element = arr[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("✅ Dequeued " + element + " from circular queue");
        return element;
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("❌ Queue is empty");
            return -1;
        }
        return arr[front];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
    
    public int getSize() {
        return size;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("📭 Circular Queue is empty");
            return;
        }
        
        System.out.print("\n🔄 Circular Queue (front to rear): ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(arr[index] + " ");
            if (i < size - 1) System.out.print("→ ");
        }
        System.out.println();
        System.out.println("Front: " + arr[front] + " | Rear: " + arr[rear] + 
                          " | Size: " + size + "/" + capacity);
    }
    
    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        
        System.out.println("=== CIRCULAR QUEUE DEMONSTRATION ===");
        
        // Enqueue elements
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);
        cq.display();
        
        // Dequeue some elements
        System.out.println("\nDequeuing operations:");
        cq.dequeue();
        cq.dequeue();
        cq.display();
        
        // Enqueue more elements (should wrap around)
        cq.enqueue(60);
        cq.enqueue(70);
        cq.display();
        
        // Try to enqueue when full
        cq.enqueue(80);
        
        // Dequeue all
        System.out.println("\nDequeuing all elements:");
        while (!cq.isEmpty()) {
            System.out.println("Dequeued: " + cq.dequeue());
        }
        cq.display();
    }
}