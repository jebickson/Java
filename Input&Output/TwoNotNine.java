import java.util.*;

public class TwoNotNine {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int hno = input.nextInt();
        int pincode = input.nextInt();
        int employeeID = input.nextInt();
        int areacode = input.nextInt();

        System.out.println("EmployeeID : " + employeeID);
        System.out.println("Area Code : " + areacode);
        System.out.println("House Number : " + hno);
        System.out.println("Pincode : " + pincode);
    }
}