abstract class Vehicle { abstract void start(); void stop() { System.out.println("Vehicle stopped"); } }

interface Fuel { void refuel(); }

class Car extends Vehicle implements Fuel { private String name; Car(String name) { this.name = name; } void start() { System.out.println(name + " started"); } public void refuel() { System.out.println(name + " refueled"); } }

public class VehicleTest { public static void main(String[] args) { Car c = new Car("Honda"); c.start(); c.stop(); c.refuel(); } }