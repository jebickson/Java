import java.util.Scanner;
public class Sixteen {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int n,m;
   n = sc.nextInt();
   m = sc.nextInt();
  int ans = Math.min((n + m) / 3, Math.min(n, m));
  System.out.println(ans);
  sc.close();
 }
}