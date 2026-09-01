import java.util.Scanner;

public class StackMenu {
    private int[] arr;
    private int top;
    private int capacity;
    
    public StackMenu(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    
    public void push(int element) {
        if (isFull()) {
            System.out.println("❌ Stack Overflow! Cannot push " + element);
            return;
        }
        arr[++top] = element;
        System.out.println("✅ Pushed " + element + " to stack");
    }
    
    public int pop() {
        if (isEmpty()) {
            System.out.println("❌ Stack Underflow! Cannot pop");
            return -1;
        }
        int element = arr[top--];
        System.out.println("✅ Popped " + element + " from stack");
        return element;
    }
    
    public int peek() {
        if (isEmpty()) {
            System.out.println("❌ Stack is empty");
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
    
    public void display() {
        if (isEmpty()) {
            System.out.println("📭 Stack is empty");
            return;
        }
        System.out.println("\n📚 Stack Contents:");
        System.out.println("┌─────────┐");
        for (int i = top; i >= 0; i--) {
            System.out.printf("│ %-7d │%n", arr[i]);
            if (i > 0) System.out.println("├─────────┤");
        }
        System.out.println("└─────────┘");
        System.out.println("Top: " + arr[top] + " | Size: " + size() + "/" + capacity);
    }
    
    public void clear() {
        top = -1;
        System.out.println("🗑️ Stack cleared");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter stack size: ");
        int size = scanner.nextInt();
        StackMenu stack = new StackMenu(size);
        
        while (true) {
            System.out.println("\n=== STACK OPERATIONS MENU ===");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Peek");
            System.out.println("4. Check if Empty");
            System.out.println("5. Check if Full");
            System.out.println("6. Get Size");
            System.out.println("7. Display Stack");
            System.out.println("8. Clear Stack");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;
                    
                case 2:
                    int popped = stack.pop();
                    if (popped != -1) {
                        System.out.println("Popped value: " + popped);
                    }
                    break;
                    
                case 3:
                    int topElement = stack.peek();
                    if (topElement != -1) {
                        System.out.println("Top element: " + topElement);
                    }
                    break;
                    
                case 4:
                    System.out.println("Is stack empty? " + stack.isEmpty());
                    break;
                    
                case 5:
                    System.out.println("Is stack full? " + stack.isFull());
                    break;
                    
                case 6:
                    System.out.println("Stack size: " + stack.size());
                    break;
                    
                case 7:
                    stack.display();
                    break;
                    
                case 8:
                    stack.clear();
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
