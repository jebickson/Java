import java.util.Random;

class Customer {
    private int id;
    private int serviceTime;
    
    public Customer(int id, int serviceTime) {
        this.id = id;
        this.serviceTime = serviceTime;
    }
    
    public int getServiceTime() {
        return serviceTime;
    }
    
    @Override
    public String toString() {
        return "Customer #" + id + " (Service: " + serviceTime + "s)";
    }
}

public class BankSimulation {
    private GenericQueue<Customer> queue;
    private int customerCounter;
    
    public BankSimulation(int capacity) {
        queue = new GenericQueue<>(capacity);
        customerCounter = 0;
    }
    
    public void addCustomer(int serviceTime) {
        customerCounter++;
        Customer customer = new Customer(customerCounter, serviceTime);
        queue.enqueue(customer);
        System.out.println("➕ New customer joined queue: " + customer);
    }
    
    public void serveCustomer() {
        if (queue.isEmpty()) {
            System.out.println("📭 No customers in queue");
            return;
        }
        
        Customer customer = queue.dequeue();
        System.out.println("🔄 Serving: " + customer);
        System.out.println("⏱️ Estimated time: " + customer.getServiceTime() + " seconds");
        
        // Simulate service time
        try {
            Thread.sleep(customer.getServiceTime() * 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("✅ Customer served successfully!");
    }
    
    public void displayQueue() {
        System.out.println("\n📊 Current Queue Status:");
        System.out.println("Total waiting: " + queue.getSize() + " customers");
        queue.display();
    }
    
    public static void main(String[] args) throws InterruptedException {
        BankSimulation bank = new BankSimulation(10);
        Random random = new Random();
        
        System.out.println("=== BANK CUSTOMER SERVICE SIMULATION ===");
        System.out.println("🏦 Bank opens for business!");
        
        // Simulate customers arriving
        for (int minute = 0; minute < 10; minute++) {
            System.out.println("\n--- Minute " + (minute + 1) + " ---");
            
            // Random number of customers arrive
            int arrivals = random.nextInt(3);
            for (int i = 0; i < arrivals; i++) {
                int serviceTime = random.nextInt(3) + 1; // 1-3 seconds
                bank.addCustomer(serviceTime);
            }
            
            // Serve one customer if available
            bank.serveCustomer();
            
            Thread.sleep(1000);
        }
        
        // Serve remaining customers
        System.out.println("\n🕐 Serving remaining customers...");
        while (!bank.queue.isEmpty()) {
            bank.serveCustomer();
            Thread.sleep(500);
        }
        
        System.out.println("\n🏦 Bank closed! All customers served.");
    }
}