/* Base class Shape */
abstract class Shape {
    double dimension1;
    double dimension2;

    public void initData(double d1, double d2) { // Method to initialize data members
        this.dimension1 = d1;
        this.dimension2 = d2;
    }

    public void displayArea() {
    } // method to compute the area
}

/* Derived class Triangle */
class Triangle extends Shape {
    public void displayArea() {
        double area = 0.5 * dimension1 * dimension2;
        System.out.println("Area of Triangle: " + area);
    }
}

/* Derived class Circle */
class Circle extends Shape {
    public void initData(double radius, double unused) {
        super.initData(radius, 0);
    }

    public void displayArea() {
        double area = Math.PI * Math.pow(dimension1, 2);
        System.out.println("Area of Circle: " + area);
    }
}

/* Derived class Rectangle */
class Rectangle extends Shape {
    public void displayArea() {
        double area = dimension1 * dimension2;
        System.out.println("Area of Rectangle: " + area);
    }
}


public class AreaOfShapes {


    public static void main(String[] args) {

        Shape triangle = new Triangle();
        triangle.initData(14, 7);
        triangle.displayArea();

        Shape circle = new Circle();
        circle.initData(5, 0);
        circle.displayArea();

        Shape rectangle = new Rectangle();
        rectangle.initData(2, 3);
        rectangle.displayArea();
    }
}
