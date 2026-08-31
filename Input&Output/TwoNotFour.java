import java.util.*;

public class TwoNotFour {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double base1 = input.nextDouble();
        double base2 = input.nextDouble();
        double height = input.nextDouble();

        double area = ((base1 + base2) * height) / 2.0;

        System.out.println(String.format("%.2f", area));
    }
}