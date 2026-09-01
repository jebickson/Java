public class DynamicQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;
    
    public DynamicQueue() {
        this(10); // Default capacity
    }
    
    public DynamicQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    private void resize() {
        int newCapacity = capacity * 2;
        int[] newArr = new int[newCapacity];
        
        // Copy elements in order
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[(front + i) % capacity];
        }
        
        arr = newArr;
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
        System.out.println("🔄 Queue resized to capacity: " + capacity);
    }
    
    public void enqueue(int element) {
        if (isFull()) {
            resize();
        }
        rear = (rear + 1) % capacity;
        arr[rear] = element;
        size++;
        System.out.println("✅ Enqueued " + element + " to queue");
    }
    
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
    
    public int getCapacity() {
        return capacity;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("📭 Queue is empty");
            return;
        }
        
        System.out.print("Queue (front to rear): ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(arr[index] + " ");
        }
        System.out.println("| Size: " + size + "/" + capacity);
    }
    
    public static void main(String[] args) {
        DynamicQueue queue = new DynamicQueue(3);
        
        System.out.println("=== DYNAMIC QUEUE ===");
        System.out.println("Initial capacity: " + queue.getCapacity());
        
        // Add elements to trigger resize
        for (int i = 1; i <= 10; i++) {
            queue.enqueue(i * 10);
        }
        
        queue.display();
        
        System.out.println("\nDequeuing elements:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Dequeued: " + queue.dequeue());
        }
        
        queue.display();
        System.out.println("Final capacity: " + queue.getCapacity());
    }
}