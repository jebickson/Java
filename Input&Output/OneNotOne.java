import java.util.*;

public class OneNotOne{
    
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        int basic = input.nextInt();
        int da1 = input.nextInt();
        int hra1 = input.nextInt();
        
        int da = (da1*basic)/100;
        int hra = (hra1 * basic)/100;
        
        int GrossPayment = basic + da + hra;
        
        System.out.println(GrossPayment);
    }
}