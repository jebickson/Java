// Three Dimensional(3D) Array
// A 3D array stores data in three dimensions. You can think of it as multiple 2D arrays.


package Java;

public class ThreeDimentionalArray {
    public static void main(String [] args){
        
        int[][][]cube = {
        {
            {1,2},
            {3,4}
        },
        {
            {5,6},
            {7,8}
        }
    };

    System.out.println(cube[0][0][0]);
    System.out.println(cube[1][1][1]);
}
}
