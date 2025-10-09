abstract class Shape {
    protected double area;
    protected double perimeter;
    abstract void calculateArea();
    abstract void calculatePerimeter();
}

interface Drawable {
    void draw();
}

class Circle extends Shape implements Drawable {
    private double radius;
    Circle(double radius) {
        this.radius = radius;
    }
    void calculateArea() {
        area = Math.PI * radius * radius;
    }
    void calculatePerimeter() {
        perimeter = 2 * Math.PI * radius;
    }
    public void draw() {
        System.out.println("Drawing a circle with radius " + radius);
    }
    public static void main(String[] args) {
        Circle c = new Circle(5);
        c.calculateArea();
        c.calculatePerimeter();
        c.draw();
        System.out.println("Area: " + c.area + ", Perimeter: " + c.perimeter);
    }
}
