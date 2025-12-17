
// an abstruct method Calculate area
// a cncrete method displayShape()
// Create two sub class
// 1.Rectangle(with lenght and width)
// Circle (with radius )
abstract class Shape {
    abstract void calculateArea();

    void displayShape() {
        System.out.println("Shape.");
    }
}

// Subclass 1
class Rectangle extends Shape {
    double length;
    double width;

    Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    void calculateArea() {
        double area = length * width;
        System.out.println("Area of a rectangle: " + area);
    }
}

// subclass2
class Circle extends Shape {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    void calculateArea() {
        double area = Math.PI * Math.pow(radius, 2);
        System.out.println("Area of the circle is : " + area);
    }
}

public class AbstractQ1 { //
    public static void main(String[] args) {
        Shape s1 = new Rectangle(12.4, 4.5);
        Shape s2 = new Circle(4.5);

        s1.displayShape();
        s1.calculateArea();
        s2.displayShape();
        s2.calculateArea();
    }
}