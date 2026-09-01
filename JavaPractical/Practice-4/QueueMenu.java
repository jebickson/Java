import java.util.Scanner;

public class QueueMenu {
    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;
    
    public QueueMenu(int capacity) {
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
    
    public void display() {
        if (isEmpty()) {
            System.out.println("\n📭 Queue is empty");
            return;
        }
        
        System.out.println("\n📊 Queue Visualization:");
        System.out.println("┌─────────┬─────────┬─────────┐");
        System.out.println("│ Index   │ Value   │ Status  │");
        System.out.println("├─────────┼─────────┼─────────┤");
        
        for (int i = 0; i < capacity; i++) {
            String status;
            String value;
            if (i >= front && i <= rear && size > 0) {
                // Simple case without wrap-around
                if (front <= rear) {
                    if (i >= front && i <= rear) {
                        status = "Occupied";
                        value = String.valueOf(arr[i]);
                    } else {
                        status = "Empty";
                        value = " ";
                    }
                } else {
                    // Wrap-around case
                    if (i >= front || i <= rear) {
                        status = "Occupied";
                        value = String.valueOf(arr[i]);
                    } else {
                        status = "Empty";
                        value = " ";
                    }
                }
            } else {
                status = "Empty";
                value = " ";
            }
            System.out.printf("│  %-6d │  %-6s │  %-8s │%n", i, value, status);
        }
        System.out.println("└─────────┴─────────┴─────────┘");
        System.out.println("Front: " + arr[front] + " | Rear: " + arr[rear] + 
                          " | Size: " + size + "/" + capacity);
    }
    
    public void clear() {
        front = 0;
        rear = -1;
        size = 0;
        System.out.println("🗑️ Queue cleared");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter queue size: ");
        int size = scanner.nextInt();
        QueueMenu queue = new QueueMenu(size);
        
        while (true) {
            System.out.println("\n=== QUEUE OPERATIONS MENU ===");
            System.out.println("1. Enqueue (Add)");
            System.out.println("2. Dequeue (Remove)");
            System.out.println("3. Peek (Front)");
            System.out.println("4. Check if Empty");
            System.out.println("5. Check if Full");
            System.out.println("6. Get Size");
            System.out.println("7. Display Queue");
            System.out.println("8. Clear Queue");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    int element = scanner.nextInt();
                    queue.enqueue(element);
                    break;
                    
                case 2:
                    int dequeued = queue.dequeue();
                    if (dequeued != -1) {
                        System.out.println("Dequeued value: " + dequeued);
                    }
                    break;
                    
                case 3:
                    int frontElement = queue.peek();
                    if (frontElement != -1) {
                        System.out.println("Front element: " + frontElement);
                    }
                    break;
                    
                case 4:
                    System.out.println("Is queue empty? " + queue.isEmpty());
                    break;
                    
                case 5:
                    System.out.println("Is queue full? " + queue.isFull());
                    break;
                    
                case 6:
                    System.out.println("Queue size: " + queue.getSize());
                    break;
                    
                case 7:
                    queue.display();
                    break;
                    
                case 8:
                    queue.clear();
                    break;
                    
                case 9:
                    System.out.println("👋 Goodbye!");
                    scanner.close();
                    System.exit(0);
                    
                default:
                    System.out.println("❌ Invalid choice! Please try again.");
            }
        }
    }
}