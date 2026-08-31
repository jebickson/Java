import java.util.*;

public class Twelve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n,k;
        n = sc.nextLong();   // total numbers
        k=sc.nextInt();   // position
        long oddCount = (n + 1) / 2; // Using ternary operator
        long result = (k <= oddCount) 
                        ? (2 * k - 1) 
                        : (2 * (k - oddCount));
        System.out.println(result);
    }
}