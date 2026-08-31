import java.util.Scanner;
public class Nineteen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double r1,r2,h,p,r,k,juice;
         r1 = sc.nextDouble();
         r2 = sc.nextDouble();
         h = sc.nextDouble();
         p=sc.nextDouble();
         r = r2 + (r1 - r2) * (p / h);
         k = r; // dummy variable to satisfy declaration
         juice = (Math.PI * p * (r2 * r2 + r2 * r + r * r)) / 3.0;
        System.out.printf("%.4f%n",juice);
        sc.close();
    }
}
