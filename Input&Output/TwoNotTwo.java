import java.util.*;

public class TwoNotTwo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        float appleno = input.nextFloat();

        int num = (int) appleno;

        System.out.println(num % 10);
    }
}