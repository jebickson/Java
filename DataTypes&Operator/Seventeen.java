import java.util.Scanner;
public class Seventeen {
 public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
  double AB,AC,BC,AD,ADE,ABC,rat;
  AB = sc.nextDouble();
  AC = sc.nextDouble();
  BC = sc.nextDouble();
  rat=sc.nextDouble();
  AD = AB * Math.sqrt(rat / (1.0 + rat));
  System.out.printf("%.4f%n", AD);
  sc.close();
 }
}