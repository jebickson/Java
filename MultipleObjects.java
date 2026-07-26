package Java;

class Student{

    String name;
    int age;
}

public class MultipleObjects {
    public static void main(String[] args){

        Student s1 = new Student();
        Student s2 = new Student();

        s1.name = "John";
        s1.age = 20;

        s2.name = "Alice";
        s2.age = 22;

        System.out.println(s1.name);
        System.out.println(s2.name);
    }
}
