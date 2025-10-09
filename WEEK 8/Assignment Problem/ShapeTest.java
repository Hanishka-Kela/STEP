abstract class Shape {
    abstract double area();
    abstract double perimeter();
    void displayInfo() {
        System.out.println("Area: " + area() + ", Perimeter: " + perimeter());
    }
}

class Circle extends Shape {
    private double r;
    Circle(double r) { this.r = r; }
    double area() { return Math.PI * r * r; }
    double perimeter() { return 2 * Math.PI * r; }
}

class Rectangle extends Shape {
    private double w, h;
    Rectangle(double w, double h) { this.w = w; this.h = h; }
    double area() { return w * h; }
    double perimeter() { return 2 * (w + h); }
}

public class ShapeTest {
    public static void main(String[] args) {
        Shape c = new Circle(5);
        c.displayInfo();
        Shape r = new Rectangle(4, 6);
        r.displayInfo();
    }
}