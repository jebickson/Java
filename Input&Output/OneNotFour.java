import java.util.*;

public class OneNotFour {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        float length = input.nextFloat();
        float width = input.nextFloat();

        float area = length * width;

        System.out.println(String.format("%.2f sq.ft", area));
    }
}