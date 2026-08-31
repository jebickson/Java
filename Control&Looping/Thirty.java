import java.util.Scanner;
public class Thirty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 0; t < T; t++) {
            long[] p = {sc.nextLong(), sc.nextLong(), sc.nextLong()};
            long x = sc.nextLong(), y = sc.nextLong();
            if (p[0] + p[1] + p[2] != x + y) {
                System.out.println("NO");
                continue;
            }else{}
            int ok = 0;
            for (int i = 0; i < 3; i++) {
                long r1 = p[(i + 1) % 3], r2 = p[(i + 2) % 3];
                if (x >= r1 && y >= r2) ok = 1;
                if (x >= r2 && y >= r1) ok = 1;
            }
            System.out.println(ok == 1 ? "YES" : "NO");
        }
        sc.close();
    }
}