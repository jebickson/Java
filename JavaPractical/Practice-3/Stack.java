public class Stack {
    private int[] arr;
    private int top;
    private int capacity;
    
    // Constructor to initialize stack
    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    
    // Push operation - add element to top
    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + element);
            return;
        }
        arr[++top] = element;
        System.out.println("Pushed " + element + " to stack");
    }
    
    // Pop operation - remove element from top
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop");
            return -1;
        }
        return arr[top--];
    }
    
    // Peek operation - view top element without removing
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return arr[top];
    }
    
    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
    
    // Check if stack is full
    public boolean isFull() {
        return top == capacity - 1;
    }
    
    // Get current size of stack
    public int size() {
        return top + 1;
    }
    
    // Display all elements in stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack elements (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    // Main method for testing
    public static void main(String[] args) {
        Stack stack = new Stack(5);
        
        System.out.println("=== STACK OPERATIONS ===");
        System.out.println("Is stack empty? " + stack.isEmpty());
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        
        // Try to push when full
        stack.push(60);
        
        stack.display();
        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.peek());
        
        System.out.println("\nPopping elements:");
        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        
        stack.display();
        System.out.println("Stack size: " + stack.size());
        System.out.println("Is stack empty? " + stack.isEmpty());
    }
}
