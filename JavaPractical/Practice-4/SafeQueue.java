// Custom exceptions
class QueueFullException extends Exception {
    public QueueFullException(String message) {
        super(message);
    }
}

class QueueEmptyException extends Exception {
    public QueueEmptyException(String message) {
        super(message);
    }
}

public class SafeQueue {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;
    
    public SafeQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public void enqueue(int element) throws QueueFullException {
        if (isFull()) {
            throw new QueueFullException("Cannot enqueue " + element + ", queue is full");
        }
        rear = (rear + 1) % capacity;
        arr[rear] = element;
        size++;
        System.out.println("✅ Enqueued " + element + " to queue");
    }
    
    public int dequeue() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Cannot dequeue from empty queue");
        }
        int element = arr[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("✅ Dequeued " + element + " from queue");
        return element;
    }
    
    public int peek() throws QueueEmptyException {
        if (isEmpty()) {
            throw new QueueEmptyException("Queue is empty");
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
        SafeQueue queue = new SafeQueue(3);
        
        System.out.println("=== SAFE QUEUE WITH EXCEPTION HANDLING ===");
        
        try {
            queue.enqueue(10);
            queue.enqueue(20);
            queue.enqueue(30);
            queue.enqueue(40); // This will throw exception
        } catch (QueueFullException e) {
            System.out.println("❌ " + e.getMessage());
        }
        
        queue.display();
        
        try {
            System.out.println("Front element: " + queue.peek());
            System.out.println("Dequeued: " + queue.dequeue());
            System.out.println("Dequeued: " + queue.dequeue());
            System.out.println("Dequeued: " + queue.dequeue());
            System.out.println("Dequeued: " + queue.dequeue()); // This will throw exception
        } catch (QueueEmptyException e) {
            System.out.println("❌ " + e.getMessage());
        }
        
        queue.display();
    }
}