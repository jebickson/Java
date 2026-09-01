public class Queue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;
    
    // Constructor
    public Queue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    // Enqueue - Add element to rear
    public void enqueue(int element) {
        if (isFull()) {
            System.out.println("❌ Queue Overflow! Cannot enqueue " + element);
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = element;
        size++;
        System.out.println("✅ Enqueued " + element + " to queue");
    }
    
    // Dequeue - Remove element from front
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("❌ Queue Underflow! Cannot dequeue");
            return -1;
        }
        int element = arr[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("✅ Dequeued " + element + " from queue");
        return element;
    }
    
    // Peek - View front element without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("❌ Queue is empty");
            return -1;
        }
        return arr[front];
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Check if queue is full
    public boolean isFull() {
        return size == capacity;
    }
    
    // Get current size
    public int getSize() {
        return size;
    }
    
    // Get capacity
    public int getCapacity() {
        return capacity;
    }
    
    // Display all elements
    public void display() {
        if (isEmpty()) {
            System.out.println("📭 Queue is empty");
            return;
        }
        
        System.out.print("\n📋 Queue Contents (front to rear): ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(arr[index] + " ");
        }
        System.out.println();
        System.out.println("Front: " + arr[front] + " | Rear: " + arr[rear] + 
                          " | Size: " + size + "/" + capacity);
    }
    
    // Main method for testing
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        
        System.out.println("=== QUEUE OPERATIONS ===");
        System.out.println("Is queue empty? " + queue.isEmpty());
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);
        
        queue.display();
        
        // Try to enqueue when full
        queue.enqueue(60);
        
        System.out.println("\nFront element: " + queue.peek());
        System.out.println("Queue size: " + queue.getSize());
        
        System.out.println("\nDequeue operations:");
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        
        queue.display();
        
        System.out.println("Is queue empty? " + queue.isEmpty());
        System.out.println("Is queue full? " + queue.isFull());
    }
}