import java.util.*;

public class TwoNotSix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double base = input.nextDouble();
        double exp = input.nextDouble();

        double result = Math.pow(base, exp);

        System.out.println(String.format("%.2f", result));
    }
}