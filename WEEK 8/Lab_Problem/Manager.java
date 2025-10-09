abstract class Employee {
    protected String name;
    protected double salary;
    abstract double calculateBonus();
}

interface Payable {
    void generatePaySlip();
}

class Manager extends Employee implements Payable {
    private String department;
    Manager(String name, double salary, String department) {
        this.name = name;
        this.salary = salary;
        this.department = department;
    }
    double calculateBonus() {
        return salary * 0.2;
    }
    public void generatePaySlip() {
        System.out.println("Pay Slip - Name: " + name + ", Department: " + department + ", Total Pay: " + (salary + calculateBonus()));
    }
    public static void main(String[] args) {
        Manager m = new Manager("Amit", 50000, "HR");
        m.generatePaySlip();
    }
}
