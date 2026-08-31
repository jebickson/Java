import java.util.Scanner;
public class Fifteen {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  int r,o,c;
  r = sc.nextInt();
  o = sc.nextInt();
  c = sc.nextInt();
  int max = c + (20 - o) * 36;
  String ans = (max > r) ? "YES" : "NO";
  System.out.println(ans);
  sc.close();
 }
}