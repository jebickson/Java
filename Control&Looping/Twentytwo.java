import java.util.Scanner;
public class Twentytwo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long count = 0;
        if (n > 0) {
            for (long i = 1; i <= n; i++) {
                if (i % 7 == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
        sc.close();
    }
}