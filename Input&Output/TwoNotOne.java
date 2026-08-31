import java.util.*;

public class TwoNotOne {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int m = input.nextInt();
        int n = input.nextInt();

        int tiles = (m * n + 1) / 2;

        System.out.println(tiles);
    }
}