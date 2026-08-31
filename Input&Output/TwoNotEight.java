import java.util.*;

public class TwoNotEight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double celsius = input.nextDouble();

        double fahrenheit = (celsius * 9 / 5) + 32;

        System.out.println(String.format("%.2f fahrenheit", fahrenheit));
    }
}