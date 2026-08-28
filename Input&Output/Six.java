import java.io.*;
import java.util.*;

public class Six {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        float radiusofball = input.nextFloat();
        double volume = (4.0 / 3.0) * 3.14 * radiusofball * radiusofball * radiusofball;
        System.out.println(String.format("%.6f", volume));
    }
}