import java.util.*;

public class OneNotTen {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        float height = input.nextFloat();
        float base = input.nextFloat();

        float area = (height * base) / 2;

        System.out.println(String.format("%.3f", area));
    }
}