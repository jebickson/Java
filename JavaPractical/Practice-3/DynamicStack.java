public class DynamicStack {
    private int[] arr;
    private int top;
    private int capacity;
    
    public DynamicStack() {
        this(10); // Default capacity 10
    }
    
    public DynamicStack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    
    private void resize() {
        int newCapacity = capacity * 2;
        int[] newArr = new int[newCapacity];
        
        // Copy old elements to new array
        for (int i = 0; i <= top; i++) {
            newArr[i] = arr[i];
        }
        
        arr = newArr;
        capacity = newCapacity;
        System.out.println("Stack resized to capacity: " + capacity);
    }
    
    public void push(int element) {
        if (isFull()) {
            resize();
        }
        arr[++top] = element;
        System.out.println("Pushed " + element + " to stack");
    }
    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow! Cannot pop");
            return -1;
        }
        return arr[top--];
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
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
    
    public int getCapacity() {
        return capacity;
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
        System.out.println("Capacity: " + capacity + ", Size: " + size());
    }
    
    public static void main(String[] args) {
        DynamicStack stack = new DynamicStack(3);
        
        System.out.println("=== DYNAMIC STACK ===");
        System.out.println("Initial capacity: " + stack.getCapacity());
        
        for (int i = 1; i <= 10; i++) {
            stack.push(i * 10);
        }
        
        stack.display();
        
        System.out.println("\nPopping elements:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Popped: " + stack.pop());
        }
        
        stack.display();
    }
}