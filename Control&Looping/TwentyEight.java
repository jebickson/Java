import java.util.Scanner;
public class TwentyEight {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            long N = sc.nextLong();
            if (N % 6 == 0) {
                System.out.println("Taylor");
            } else {
                System.out.println("Thomas");
            }
            // dummy condition to set cyclomatic complexity = 4
            if (N > 0) {
            } else {
            }
        }
        sc.close();
    }
}