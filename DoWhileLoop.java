// do while loop 
// A do whule loop always executes the code at least once, even if the confition is false.

package Java;

public class DoWhileLoop {
    /* Syntax 
    do{
      //code
    }while(condition);
     */
    public static void main(String [] args){

        int i = 1;

        do{ 
            System.out.println(i);
            i ++;
        } while(i <= 5);
    }
    
}
