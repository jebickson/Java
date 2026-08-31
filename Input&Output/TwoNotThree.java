import java.util.*;

public class TwoNotThree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double s1 = input.nextDouble();
        double s2 = input.nextDouble();
        double s3 = input.nextDouble();

        double s = (s1 + s2 + s3) / 2.0;

        double area = Math.sqrt(s * (s - s1) * (s - s2) * (s - s3));

        System.out.println(String.format("%.2f", area));
    }
}