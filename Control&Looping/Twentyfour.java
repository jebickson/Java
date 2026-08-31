import java.util.Scanner;
public class Twentyfour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N,M;
         N = sc.nextInt();
         M = sc.nextInt();
        if (N <= 9) {
            System.out.println(M + (10 - N) * 100);
        } else {
            System.out.println(M);
        }
        sc.close();
    }
}