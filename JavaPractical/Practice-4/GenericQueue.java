public class GenericQueue<T> {
    private T[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int size;
    
    @SuppressWarnings("unchecked")
    public GenericQueue(int capacity) {
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public void enqueue(T element) {
        if (isFull()) {
            System.out.println("❌ Queue Overflow! Cannot enqueue " + element);
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = element;
        size++;
        System.out.println("✅ Enqueued " + element + " to queue");
    }
    
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("❌ Queue Underflow! Cannot dequeue");
            return null;
        }
        T element = arr[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("✅ Dequeued " + element + " from queue");
        return element;
    }
    
    public T peek() {
        if (isEmpty()) {
            System.out.println("❌ Queue is empty");
            return null;
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
        System.out.println(" | Size: " + size + "/" + capacity);
    }
    
    public static void main(String[] args) {
        // Queue of Strings
        System.out.println("=== STRING QUEUE ===");
        GenericQueue<String> stringQueue = new GenericQueue<>(3);
        stringQueue.enqueue("Hello");
        stringQueue.enqueue("World");
        stringQueue.enqueue("Java");
        stringQueue.display();
        System.out.println("Dequeued: " + stringQueue.dequeue());
        stringQueue.display();
        
        // Queue of Doubles
        System.out.println("\n=== DOUBLE QUEUE ===");
        GenericQueue<Double> doubleQueue = new GenericQueue<>(4);
        doubleQueue.enqueue(3.14);
        doubleQueue.enqueue(2.71);
        doubleQueue.enqueue(1.618);
        doubleQueue.display();
        System.out.println("Front: " + doubleQueue.peek());
        
        // Queue of Custom Objects
        System.out.println("\n=== STUDENT QUEUE ===");
        GenericQueue<Student> studentQueue = new GenericQueue<>(3);
        studentQueue.enqueue(new Student("Alice", 20));
        studentQueue.enqueue(new Student("Bob", 22));
        studentQueue.enqueue(new Student("Charlie", 21));
        studentQueue.display();
        
        Student s = studentQueue.dequeue();
        System.out.println("Dequeued: " + s);
    }
}

class Student {
    private String name;
    private int age;
    
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return name + "(" + age + ")";
    }
}