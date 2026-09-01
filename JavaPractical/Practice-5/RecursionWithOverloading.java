public class RecursionWithOverloading {
    
    // Method overloading for factorial
    public long factorial(int n) {
        if (n <= 0) return 1;
        return n * factorial(n - 1);
    }
    
    public long factorial(int n, int limit) {
        if (n <= 0 || n > limit) return 1;
        return n * factorial(n - 1, limit);
    }
    
    // Method overloading for Fibonacci
    public int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    