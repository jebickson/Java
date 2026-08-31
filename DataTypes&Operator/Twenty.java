import java.util.*;
public class Twenty {
    public static void main(String[] args) {
        Scanner r = new Scanner(System.in);
        int N = r.nextInt();
        int M = r.nextInt();
        System.out.println(N >= M);
        System.out.println(N <= M);
        r.close();
    }
}