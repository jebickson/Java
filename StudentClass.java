//Object and class
// Example 1: Student class 

package Java;

class Student { // class - Create a class
    // Student - Class name
    
    String name; // These are called instance variable(fields).
    //Every STUDENT object will have:
    int age;

    void display(){ // Creates a method to display the student's information.
        System.out.println("name:" + name);
        System.out.println("age:" + age);
    }
}
public class StudentClass{
    public static void main(String[]args){

        Student s1 = new Student(); // Student - Class name (data type)
        // s1 - Object name 
        // = - Assignment operator
        // new - create a new object 
        // Student - calls the constructor

        s1.name = "john"; // Stores Value in the object's variables.
        s1.age = 20;

        s1.display(); // Calls the display() method for the object s1.
    }
}
