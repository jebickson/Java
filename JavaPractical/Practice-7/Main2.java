// Interfaces
interface Academic {
    void study();
    void takeExam();
    double getGPA();
}

interface Research {
    void conductResearch();
    void publishPaper();
    int getPaperCount();
}

interface Extracurricular {
    void participateInSports();
    void joinClub();
    int getClubCount();
}

// Abstract Class
abstract class Person {
    protected String name;
    protected int age;
    protected String address;
    
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    
    public abstract void introduce();
    
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Address: " + address);
    }
}

// Concrete Class with Multiple Inheritance
class Student extends Person implements Academic, Research, Extracurricular {
    private String major;
    private double gpa;
    private int paperCount;
    private int clubCount;
    private String[] courses;
    
    public Student(String name, int age, String address, String major) {
        super(name, age, address);
        this.major = major;
        this.gpa = 0.0;
        this.paperCount = 0;
        this.clubCount = 0;
        this.courses = new String[]{"Math", "Physics", "Computer Science"};
    }
    
    @Override
    public void introduce() {
        System.out.println("Hi, I'm " + name + ", a student majoring in " + major);
    }
    
    // Academic methods
    @Override
    public void study() {
        System.out.println(name + " is studying " + major);
        gpa += 0.1;
    }
    
    @Override
    public void takeExam() {
        System.out.println(name + " is taking an exam");
    }
    
    @Override
    public double getGPA() {
        return gpa;
    }
    
    // Research methods
    @Override
    public void conductResearch() {
        System.out.println(name + " is conducting research in " + major);
        paperCount++;
    }
    
    @Override
    public void publishPaper() {
        System.out.println(name + " published a paper!");
        paperCount++;
    }
    
    @Override
    public int getPaperCount() {
        return paperCount;
    }
    
    // Extracurricular methods
    @Override
    public void participateInSports() {
        System.out.println(name + " is playing sports");
    }
    
    @Override
    public void joinClub() {
        System.out.println(name + " joined a club");
        clubCount++;
    }
    
    @Override
    public int getClubCount() {
        return clubCount;
    }
    
    // Additional methods
    public void attendClass() {
        System.out.println(name + " is attending class");
    }
    
    public void doAssignment() {
        System.out.println(name + " is doing assignment");
    }
}

// Another implementation demonstrating multiple interfaces
class ResearchScholar extends Person implements Academic, Research {
    private String researchArea;
    private double gpa;
    private int paperCount;
    
    public ResearchScholar(String name, int age, String address, String researchArea) {
        super(name, age, address);
        this.researchArea = researchArea;
        this.gpa = 0.0;
        this.paperCount = 0;
    }
    
    @Override
    public void introduce() {
        System.out.println("Hello, I'm " + name + ", a research scholar in " + researchArea);
    }
    
    @Override
    public void study() {
        System.out.println(name + " is studying advanced topics in " + researchArea);
    }
    
    @Override
    public void takeExam() {
        System.out.println(name + " is taking a research exam");
    }
    
    @Override
    public double getGPA() {
        return gpa;
    }
    
    @Override
    public void conductResearch() {
        System.out.println(name + " is conducting groundbreaking research in " + researchArea);
        paperCount++;
    }
    
    @Override
    public void publishPaper() {
        System.out.println(name + " published a research paper in a top journal!");
        paperCount++;
    }
    
    @Override
    public int getPaperCount() {
        return paperCount;
    }
}