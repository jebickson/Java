import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<String> students;
    
    public StudentManager() {
        students = new ArrayList<>();
    }
    
    // Add single student
    public void addStudent(String name) {
        students.add(name);
        System.out.println("Added student: " + name);
    }
    
    // Add multiple students
    public void addStudent(String... names) {
        for (String name : names) {
            students.add(name);
            System.out.println("Added student: " + name);
        }
    }
    
    // Add student with ID
    public void addStudent(int id, String name) {
        students.add(id + ": " + name);
        System.out.println("Added student: ID=" + id + ", Name=" + name);
    }
    
    // Search by name
    public boolean searchStudent(String name) {
        return students.contains(name);
    }
    
    // Search by partial name
    public List<String> searchStudent(String partialName, boolean partial) {
        List<String> results = new ArrayList<>();
        for (String student : students) {
            if (student.toLowerCase().contains(partialName.toLowerCase())) {
                results.add(student);
            }
        }
        return results;
    }
    
    public void displayAll() {
        System.out.println("\nAll Students: " + students);
    }
    
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        
        System.out.println("=== STUDENT MANAGEMENT (OVERLOADING) ===");
        manager.addStudent("Alice");
        manager.addStudent("Bob");
        manager.addStudent("Charlie", "David", "Eve");
        manager.addStudent(101, "Frank");
        
        manager.displayAll();
        
        System.out.println("\nSearch 'Ali': " + manager.searchStudent("Ali"));
        System.out.println("Partial search 'a': " + manager.searchStudent("a", true));
    }
}