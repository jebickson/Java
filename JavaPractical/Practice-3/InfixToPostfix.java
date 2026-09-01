public class InfixToPostfix {
    private char[] arr;
    private int top;
    private int capacity;
    
    public InfixToPostfix(int size) {
        arr = new char[size];
        capacity = size;
        top = -1;
    }
    
    public void push(char element) {
        if (top == capacity - 1) {
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
    
    // Get precedence of operators
    private static int precedence(char op) {
        switch (op) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
    
    // Check if character is operator
    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^';
    }
    
    // Convert infix to postfix
    public static String convert(String infix) {
        InfixToPostfix stack = new InfixToPostfix(infix.length());
        StringBuilder postfix = new StringBuilder();
        
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            
            // If character is operand, add to output
            if (Character.isLetterOrDigit(ch)) {
                postfix.append(ch);
            }
            // If character is '(', push to stack
            else if (ch == '(') {
                stack.push(ch);
            }
            // If character is ')', pop until '('
            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Remove '('
                }
            }
            // If character is operator
            else if (isOperator(ch)) {
                while (!stack.isEmpty() && stack.peek() != '(' && 
                       precedence(stack.peek()) >= precedence(ch)) {
                    postfix.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        
        // Pop all remaining operators
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }
        
        return postfix.toString();
    }
    
    public static void main(String[] args) {
        String[] expressions = {
            "A+B*C",
            "(A+B)*C",
            "A+B*C-D",
            "A+B*(C-D)",
            "A*B+C-D/E"
        };
        
        System.out.println("=== INFIX TO POSTFIX CONVERTER ===");
        System.out.printf("%-20s -> %s%n", "Infix", "Postfix");
        System.out.println("----------------------------------------");
        
        for (String expr : expressions) {
            String postfix = convert(expr);
            System.out.printf("%-20s -> %s%n", expr, postfix);
        }
        
        // Test with user input
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("\nEnter an infix expression: ");
        String expr = scanner.nextLine().replaceAll("\\s+", "");
        System.out.println("Postfix: " + convert(expr));
        scanner.close();
    }
}