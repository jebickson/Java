public class TwoStacks {
    private int[] arr;
    private int top1;
    private int top2;
    private int capacity;
    
    public TwoStacks(int size) {
        arr = new int[size];
        capacity = size;
        top1 = -1;
        top2 = size;
    }
    
    // Push to stack 1
    public void push1(int element) {
        if (top1 + 1 >= top2) {
            System.out.println("❌ Stack Overflow! Cannot push " + element + " to Stack 1");
            return;
        }
        arr[++top1] = element;
        System.out.println("✅ Pushed " + element + " to Stack 1");
    }
    
    // Push to stack 2
    public void push2(int element) {
        if (top2 - 1 <= top1) {
            System.out.println("❌ Stack Overflow! Cannot push " + element + " to Stack 2");
            return;
        }
        arr[--top2] = element;
        System.out.println("✅ Pushed " + element + " to Stack 2");
    }
    
    // Pop from stack 1
    public int pop1() {
        if (top1 < 0) {
            System.out.println("❌ Stack 1 Underflow");
            return -1;
        }
        return arr[top1--];
    }
    
    // Pop from stack 2
    public int pop2() {
        if (top2 >= capacity) {
            System.out.println("❌ Stack 2 Underflow");
            return -1;
        }
        return arr[top2++];
    }
    
    // Peek stack 1
    public int peek1() {
        if (top1 < 0) {
            System.out.println("Stack 1 is empty");
            return -1;
        }
        return arr[top1];
    }
    
    // Peek stack 2
    public int peek2() {
        if (top2 >= capacity) {
            System.out.println("Stack 2 is empty");
            return -1;
        }
        return arr[top2];
    }
    
    public boolean isEmpty1() {
        return top1 < 0;
    }
    
    public boolean isEmpty2() {
        return top2 >= capacity;
    }
    
    public int size1() {
        return top1 + 1;
    }
    
    public int size2() {
        return capacity - top2;
    }
    
    public void display() {
        System.out.println("\n📊 Two Stacks Visualization:");
        System.out.println("┌────────────┬────────────┬────────────┐");
        System.out.println("│  Index     │  Value     │  Stack     │");
        System.out.println("├────────────┼────────────┼────────────┤");
        
        for (int i = 0; i < capacity; i++) {
            String stack;
            if (i <= top1) stack = "1";
            else if (i >= top2) stack = "2";
            else stack = " ";
            
            String value = (i <= top1 || i >= top2) ? String.valueOf(arr[i]) : " ";
            System.out.printf("│  %-8d │  %-8s │  %-8s │%n", i, value, stack);
        }
        System.out.println("└────────────┴────────────┴────────────┘");
        System.out.println("Stack 1 size: " + size1() + ", Stack 2 size: " + size2());
    }
    
    public static void main(String[] args) {
        TwoStacks stacks = new TwoStacks(8);
        
        System.out.println("=== TWO STACKS IN ONE ARRAY ===");
        
        // Push to stack 1
        stacks.push1(10);
        stacks.push1(20);
        stacks.push1(30);
        
        // Push to stack 2
        stacks.push2(100);
        stacks.push2(200);
        stacks.push2(300);
        stacks.push2(400);
        
        stacks.display();
        
        System.out.println("\nStack 1 Top: " + stacks.peek1());
        System.out.println("Stack 2 Top: " + stacks.peek2());
        
        // Try to push when full
        stacks.push1(40); // This should fail
        
        System.out.println("\nPopping from Stack 1: " + stacks.pop1());
        System.out.println("Popping from Stack 2: " + stacks.pop2());
        
        stacks.display();
    }
}