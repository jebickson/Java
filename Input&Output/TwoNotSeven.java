import java.util.*;

public class TwoNotSeven {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int days = input.nextInt();
        int hours = input.nextInt();
        int minutes = input.nextInt();
        int seconds = input.nextInt();

        int total = (days * 86400) + (hours * 3600) + (minutes * 60) + seconds;

        System.out.println(total + " seconds");
    }
}