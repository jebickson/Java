import java.util.Scanner;
public class Thirteen {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  double a,b,c;
  a = sc.nextDouble();
  b = sc.nextDouble();
  c=sc.nextDouble();
  System.out.print((int)Math.max(0,Math.ceil((a-b)*c/b)));
 }
}