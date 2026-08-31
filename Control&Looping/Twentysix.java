import java.util.Scanner;
public class Twentysix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r,o,c;
        r = sc.nextInt();
        o = sc.nextInt();
        c = sc.nextInt();
        int maxPossible = c + (20 - o) * 36;
        if (maxPossible > r) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
        sc.close();
    }
}