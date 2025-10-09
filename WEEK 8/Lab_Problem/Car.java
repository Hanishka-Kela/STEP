abstract class Vehicle {
    protected int speed;
    protected String fuelType;
    abstract void startEngine();
}

interface Maintainable {
    void serviceInfo();
}

class Car extends Vehicle implements Maintainable {
    private String brand;
    Car(int speed, String fuelType, String brand) {
        this.speed = speed;
        this.fuelType = fuelType;
        this.brand = brand;
    }
    void startEngine() {
        System.out.println(brand + " car engine started. Fuel: " + fuelType);
    }
    public void serviceInfo() {
        System.out.println("Service every 6 months or 10,000 km.");
    }
    public static void main(String[] args) {
        Car c = new Car(180, "Petrol", "Honda");
        c.startEngine();
        c.serviceInfo();
    }
}
