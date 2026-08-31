import java.util.*;

public class OneNotThree {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int feet = input.nextInt();
        int inches = input.nextInt();

        double cm = (feet * 12 + inches) * 2.54;

        System.out.println("Your height in centimeters is:" + String.format("%.2f", cm));
    }
}