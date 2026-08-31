import java.util.Scanner;
public class Twentynine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            long X = sc.nextLong();
            long Y = sc.nextLong();
            if (X % 2 == 0) {
                if (X > 0 || Y % 2 == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}