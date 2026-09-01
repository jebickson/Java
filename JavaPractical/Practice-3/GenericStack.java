public class GenericStack<T> {
    private T[] arr;
    private int top;
    private int capacity;
    
    @SuppressWarnings("unchecked")
    public GenericStack(int size) {
        arr = (T[]) new Object[size];
        capacity = size;
        top = -1;
    }
    
    public void push(T element) {
        if (isFull()) {
            System.out.println("Stack Overflow! Cannot push " + element);
            return;
        }
        arr[++top] = element;
        System.out.println("Pushed " + element + " to stack");
    }
    
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop");
            return null;
        }
        return arr[top--];
    }
    
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return null;
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
        System.out.print("Stack elements (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Stack of Strings
        System.out.println("=== STRING STACK ===");
        GenericStack<String> stringStack = new GenericStack<>(3);
        stringStack.push("Hello");
        stringStack.push("World");
        stringStack.push("Java");
        stringStack.display();
        System.out.println("Popped: " + stringStack.pop());
        stringStack.display();
        
        // Stack of Doubles
        System.out.println("\n=== DOUBLE STACK ===");
        GenericStack<Double> doubleStack = new GenericStack<>(4);
        doubleStack.push(3.14);
        doubleStack.push(2.71);
        doubleStack.push(1.618);
        doubleStack.display();
        System.out.println("Top: " + doubleStack.peek());
    }
}
