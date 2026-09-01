// Abstract Class
abstract class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
    protected double fuelCapacity;
    protected double fuelLevel;
    
    public Vehicle(String brand, String model, int year, double fuelCapacity) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelCapacity = fuelCapacity;
        this.fuelLevel = 0;
    }
    
    // Abstract methods - must be implemented by subclasses
    public abstract void startEngine();
    public abstract void stopEngine();
    public abstract void accelerate();
    public abstract void brake();
    public abstract double calculateFuelEfficiency();
    
    // Concrete methods
    public void refuel(double amount) {
        if (fuelLevel + amount <= fuelCapacity) {
            fuelLevel += amount;
            System.out.println("Refueled " + amount + " liters. Current fuel: " + fuelLevel);
        } else {
            System.out.println("Fuel tank capacity exceeded!");
        }
    }
    
    public void displayInfo() {
        System.out.println("\n=== Vehicle Information ===");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
        System.out.println("Fuel Level: " + fuelLevel + "/" + fuelCapacity);
        System.out.println("Fuel Efficiency: " + calculateFuelEfficiency() + " km/l");
    }
    
    public double getFuelLevel() { return fuelLevel; }
    public double getFuelCapacity() { return fuelCapacity; }
}

// Concrete Subclass 1: Car
class Car extends Vehicle {
    private int numberOfDoors;
    private String transmissionType;
    private boolean isEngineRunning;
    
    public Car(String brand, String model, int year, double fuelCapacity,
               int numberOfDoors, String transmissionType) {
        super(brand, model, year, fuelCapacity);
        this.numberOfDoors = numberOfDoors;
        this.transmissionType = transmissionType;
        this.isEngineRunning = false;
    }
    
    @Override
    public void startEngine() {
        if (!isEngineRunning) {
            isEngineRunning = true;
            System.out.println("Car engine started. Vroom Vroom!");
        } else {
            System.out.println("Engine is already running");
        }
    }
    
    @Override
    public void stopEngine() {
        if (isEngineRunning) {
            isEngineRunning = false;
            System.out.println("Car engine stopped.");
        } else {
            System.out.println("Engine is already off");
        }
    }
    
    @Override
    public void accelerate() {
        if (isEngineRunning) {
            System.out.println("Car is accelerating...");
            fuelLevel -= 0.5;
        } else {
            System.out.println("Start the engine first!");
        }
    }
    
    @Override
    public void brake() {
        System.out.println("Car is braking...");
    }
    
    @Override
    public double calculateFuelEfficiency() {
        // Car efficiency: 15-20 km/l depending on year
        return 15 + (2025 - year) * 0.1;
    }
    
    // Car specific methods
    public void openTrunk() {
        System.out.println("Trunk opened");
    }
    
    public void playMusic() {
        System.out.println("Playing music in the car");
    }
}

// Concrete Subclass 2: Bike
class Bike extends Vehicle {
    private boolean hasCarrier;
    private boolean isEngineRunning;
    
    public Bike(String brand, String model, int year, double fuelCapacity, boolean hasCarrier) {
        super(brand, model, year, fuelCapacity);
        this.hasCarrier = hasCarrier;
        this.isEngineRunning = false;
    }
    
    @Override
    public void startEngine() {
        if (!isEngineRunning) {
            isEngineRunning = true;
            System.out.println("Bike engine started. Vroom!");
        } else {
            System.out.println("Engine is already running");
        }
    }
    
    @Override
    public void stopEngine() {
        if (isEngineRunning) {
            isEngineRunning = false;
            System.out.println("Bike engine stopped.");
        } else {
            System.out.println("Engine is already off");
        }
    }
    
    @Override
    public void accelerate() {
        if (isEngineRunning) {
            System.out.println("Bike is accelerating...");
            fuelLevel -= 0.3;
        } else {
            System.out.println("Start the engine first!");
        }
    }
    
    @Override
    public void brake() {
        System.out.println("Bike is braking...");
    }
    
    @Override
    public double calculateFuelEfficiency() {
        // Bike efficiency: 40-60 km/l
        return 45 + (2025 - year) * 0.5;
    }
    
    // Bike specific methods
    public void wheelie() {
        System.out.println("Performing a wheelie!");
    }
    
    public void carryLuggage() {
        if (hasCarrier) {
            System.out.println("Carrying luggage on bike carrier");
        } else {
            System.out.println("No carrier available");
        }
    }
}

// Concrete Subclass 3: Truck
class Truck extends Vehicle {
    private double cargoCapacity;
    private double currentCargo;
    private boolean isEngineRunning;
    
    public Truck(String brand, String model, int year, double fuelCapacity, double cargoCapacity) {
        super(brand, model, year, fuelCapacity);
        this.cargoCapacity = cargoCapacity;
        this.currentCargo = 0;
        this.isEngineRunning = false;
    }
    
    @Override
    public void startEngine() {
        if (!isEngineRunning) {
            isEngineRunning = true;
            System.out.println("Truck engine started. Rumble Rumble!");
        } else {
            System.out.println("Engine is already running");
        }
    }
    
    @Override
    public void stopEngine() {
        if (isEngineRunning) {
            isEngineRunning = false;
            System.out.println("Truck engine stopped.");
        } else {
            System.out.println("Engine is already off");
        }
    }
    
    @Override
    public void accelerate() {
        if (isEngineRunning) {
            System.out.println("Truck is accelerating slowly...");
            fuelLevel -= 1.0;
        } else {
            System.out.println("Start the engine first!");
        }
    }
    
    @Override
    public void brake() {
        System.out.println("Truck is braking with air brakes...");
    }
    
    @Override
    public double calculateFuelEfficiency() {
        // Truck efficiency: 5-10 km/l depending on load
        double baseEfficiency = 8 - (2025 - year) * 0.2;
        return baseEfficiency * (1 - currentCargo / (cargoCapacity * 2));
    }
    
    // Truck specific methods
    public void loadCargo(double weight) {
        if (currentCargo + weight <= cargoCapacity) {
            currentCargo += weight;
            System.out.println("Loaded " + weight + " tons. Total cargo: " + currentCargo);
        } else {
            System.out.println("Cargo capacity exceeded!");
        }
    }
    
    public void unloadCargo(double weight) {
        if (currentCargo >= weight) {
            currentCargo -= weight;
            System.out.println("Unloaded " + weight + " tons. Total cargo: " + currentCargo);
        } else {
            System.out.println("Not enough cargo to unload!");
        }
    }
}