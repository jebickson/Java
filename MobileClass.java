//Object And Class
//Create a Mobile Class

package Java;

class Mobile{

    String brand;
    int price;

    void display(){
        System.out.println("Brand:"+ brand);
        System.out.println("Price" + price);
    }
}

public class MobileClass {
    
    public static void main(String[] args){

        Mobile m1 = new Mobile();

        m1.brand = "Samsung";
        m1.price = 25000;

        m1.display();
    }
}
