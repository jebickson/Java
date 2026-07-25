// Example 5: Find the Largest Numbers

package Java;

public class Example5 {
    public static void main(String[]args){

        int[] numbers = {15,80,25,60,40};
        
        int largest = numbers[0];

        for (int i = 1; i<numbers.length;i++){
            if(numbers[i]>largest){
                largest = numbers[i];
            }
        }
        System.out.println("Largest="+ largest);
    }
}
