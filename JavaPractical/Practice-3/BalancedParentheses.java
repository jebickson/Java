public class BalancedParentheses {
    private char[] arr;
    private int top;
    private int capacity;
    
    public BalancedParentheses(int size) {
        arr = new char[size];
        capacity = size;
        top = -1;
    }
    
    public void push(char element) {
        if (top == capacity - 1) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = element;
    }
    
    public char pop() {
        if (isEmpty()) {
            return '\0';
        }
        return arr[top--];
    }
    
    public char peek() {
        if (isEmpty()) {
            return '\0';
        }
        return arr[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    // Check if parentheses are balanced
    public static boolean areBalanced(String expression) {
        BalancedParentheses stack = new BalancedParentheses(expression.length());
        
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            
            // If opening bracket, push to stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // If closing bracket, check for match
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        String[] testCases = {
            "()",
            "(){}[]",
            "({[]})",
            "([)]",
            "((()))",
            "({[}])",
            ""
        };
        
        System.out.println("=== BALANCED PARENTHESES CHECKER ===");
        for (String expr : testCases) {
            System.out.printf("%-15s -> %s%n", 
                expr.isEmpty() ? "(empty)" : expr,
                areBalanced(expr) ? "✅ Balanced" : "❌ Not Balanced");
        }
        
        // Test with user input
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("\nEnter an expression to check: ");
        String expr = scanner.nextLine();
        System.out.println("Result: " + (areBalanced(expr) ? "Balanced ✅" : "Not Balanced ❌"));
        scanner.close();
    }
}