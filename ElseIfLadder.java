package Java;
// ELSE - IF LADDER
// Use this when you have multiple Conditions.

public class ElseIfLadder {
    public static void main( String[] args){

        int mark = 85;

        if(mark >= 90){
            System.out.println("Grade A");
        } else if ( mark >= 75){
            System.out.println("Grade B");
        } else if (mark >= 50){
            System.out.println("Grade c");
        } else {
            System.out.println("Fail");
        }

    }
}
