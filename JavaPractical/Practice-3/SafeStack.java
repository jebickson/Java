import java.util.EmptyStackException;

class StackFullException extends Exception {
    public StackFullException(String message) {
        super(message);
    }
}

class StackEmptyException extends Exception {
    public StackEmptyException(String message) {
        super(message);
    }
}

public class SafeStack {
    private int[] arr;
    private int top;
    private int capacity;
    
    public SafeStack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    
    public void push(int element) throws StackFullException {
        if (isFull()) {
            throw new StackFullException("Cannot push " + element + ", stack is full");
        }
        arr[++top] = element;
    }
    
    public int pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Cannot pop from empty stack");
        }
        return arr[top--];
    }
    
    public int peek() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Stack is empty");
        }
        return arr[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public boolean isFull() {
        return top == capacity - 1;
    }
    
    public int size() {
        return top + 1;
    }
    
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        SafeStack stack = new SafeStack(3);
        
        System.out.println("=== SAFE STACK WITH EXCEPTION HANDLING ===");
        
        try {
            stack.push(10);
            stack.push(20);
            stack.push(30);
            stack.push(40); // This will throw exception
        } catch (StackFullException e) {
            System.out.println("❌ " + e.getMessage());
        }
        
        stack.display();
        
        try {
            System.out.println("Top element: " + stack.peek());
            System.out.println("Popped: " + stack.pop());
            System.out.println("Popped: " + stack.pop());
            System.out.println("Popped: " + stack.pop());
            System.out.println("Popped: " + stack.pop()); // This will throw exception
        } catch (StackEmptyException e) {
            System.out.println("❌ " + e.getMessage());
        }
        
        stack.display();
    }
}