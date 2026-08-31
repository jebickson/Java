import java.util.*;

public class OneNotSeven {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double basic,sal;

        basic=input.nextDouble();

        double hra = 0.8 * basic;
        double da = 0.4 * basic;

        sal = basic + hra + da;

        System.out.println(String.format("%.2f", sal));
    }
}