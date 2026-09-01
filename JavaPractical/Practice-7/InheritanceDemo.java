public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== PART 1: EMPLOYEE MANAGEMENT SYSTEM ===\n");
        testEmployeeSystem();
        
        System.out.println("\n=== PART 2: VEHICLE SYSTEM WITH ABSTRACT CLASSES ===\n");
        testVehicleSystem();
        
        System.out.println("\n=== PART 3: MULTIPLE INHERITANCE WITH INTERFACES ===\n");
        testMultipleInheritance();
        
        System.out.println("\n=== PART 4: BANKING SYSTEM ===\n");
        testBankingSystem();
    }
    
    private static void testEmployeeSystem() {
        // Creating employees
        Manager manager = new Manager("Alice Johnson", 1001, 5000, "IT", 2000, 5);
        Developer developer = new Developer("Bob Smith", 1002, 4000, "IT", 
                                           "Java", 3, 500);
        Intern intern = new Intern("Charlie Brown", 1003, 2000, "IT", 
                                   "MIT", 6);
        
        // Displaying information
        System.out.println("=== Manager ===");
        manager.displayInfo();
        manager.work();
        manager.conductMeeting();
        manager.reviewWork();
        
        System.out.println("\n=== Developer ===");
        developer.displayInfo();
        developer.work();
        developer.writeCode();
        developer.debugCode();
        
        System.out.println("\n=== Intern ===");
        intern.displayInfo();
        intern.work();
        intern.learn();
        intern.assistTeam();
        
        // Polymorphism demonstration
        System.out.println("\n=== Polymorphism Demonstration ===");
        Employee[] employees = {manager, developer, intern};
        for (Employee emp : employees) {
            System.out.println("\nProcessing employee: " + emp.getName());
            emp.work();
            System.out.println("Salary: $" + emp.calculateSalary());
        }
    }
    
    private static void testVehicleSystem() {
        Car car = new Car("Toyota", "Camry", 2022, 60, 4, "Automatic");
        Bike bike = new Bike("Honda", "CBR500", 2023, 15, true);
        Truck truck = new Truck("Volvo", "FH16", 2021, 300, 40);
        
        // Test Car
        System.out.println("=== Car ===");
        car.displayInfo();
        car.refuel(40);
        car.startEngine();
        car.accelerate();
        car.accelerate();
        car.brake();
        car.stopEngine();
        car.openTrunk();
        car.playMusic();
        
        // Test Bike
        System.out.println("\n=== Bike ===");
        bike.displayInfo();
        bike.refuel(10);
        bike.startEngine();
        bike.accelerate();
        bike.brake();
        bike.stopEngine();
        bike.wheelie();
        bike.carryLuggage();
        
        // Test Truck
        System.out.println("\n=== Truck ===");
        truck.displayInfo();
        truck.refuel(100);
        truck.loadCargo(20);
        truck.startEngine();
        truck.accelerate();
        truck.brake();
        truck.stopEngine();
        truck.unloadCargo(10);
        
        // Polymorphism with abstract class
        System.out.println("\n=== Vehicle Polymorphism ===");
        Vehicle[] vehicles = {car, bike, truck};
        for (Vehicle v : vehicles) {
            System.out.println("\n" + v.brand + " " + v.model + " Efficiency: " + 
                             v.calculateFuelEfficiency() + " km/l");
        }
    }
    
    private static void testMultipleInheritance() {
        Student student = new Student("John Doe", 20, "123 Main St", "Computer Science");
        ResearchScholar scholar = new ResearchScholar("Dr. Jane Smith", 30, "456 Oak Ave", 
                                                     "Artificial Intelligence");
        
        System.out.println("=== Student ===");
        student.introduce();
        student.displayInfo();
        student.study();
        student.study();
        student.takeExam();
        System.out.println("GPA: " + student.getGPA());
        
        student.conductResearch();
        student.publishPaper();
        System.out.println("Papers published: " + student.getPaperCount());
        
        student.participateInSports();
        student.joinClub();
        student.joinClub();
        System.out.println("Clubs joined: " + student.getClubCount());
        
        System.out.println("\n=== Research Scholar ===");
        scholar.introduce();
        scholar.displayInfo();
        scholar.study();
        scholar.conductResearch();
        scholar.conductResearch();
        scholar.publishPaper();
        System.out.println("Papers published: " + scholar.getPaperCount());
        
        // Interface polymorphism
        System.out.println("\n=== Interface Polymorphism ===");
        Academic[] academics = {student, scholar};
        for (Academic a : academics) {
            System.out.println("GPA: " + a.getGPA());
            a.study();
        }
    }
    
    private static void testBankingSystem() {
        // Savings Account
        SavingsAccount savings = new SavingsAccount("SAV001", "Alice Smith", 5000);
        System.out.println("=== Savings Account ===");
        savings.displayBalance();
        savings.deposit(1000);
        savings.withdraw(300);
        savings.withdraw(200);
        savings.withdraw(100);
        System.out.println("After withdrawals:");
        savings.displayBalance();
        
        // Checking Account
        CheckingAccount checking = new CheckingAccount("CHK001", "Bob Johnson", 3000);
        System.out.println("\n=== Checking Account ===");
        checking.displayBalance();
        checking.deposit(500);
        checking.withdraw(4000); // Overdraft
        checking.withdraw(500);
        System.out.println("After transactions:");
        checking.displayBalance();
        System.out.println("Transaction count: " + checking.getTransactionCount());
        checking.applyTransactionFee();
        
        // Fixed Deposit Account
        FixedDepositAccount fd = new FixedDepositAccount("FD001", "Carol White", 10000, 12);
        System.out.println("\n=== Fixed Deposit Account ===");
        fd.displayBalance();
        fd.withdraw(500); // Premature withdrawal
        System.out.println("After premature withdrawal:");
        fd.displayBalance();
        
        fd.mature(); // Maturity
        System.out.println("After maturity:");
        fd.displayBalance();
        
        // Polymorphism with BankAccount
        System.out.println("\n=== Bank Account Polymorphism ===");
        BankAccount[] accounts = {savings, checking, fd};
        for (BankAccount account : accounts) {
            System.out.println("\nAccount Type: " + account.getAccountType());
            account.displayBalance();
        }
    }
}
