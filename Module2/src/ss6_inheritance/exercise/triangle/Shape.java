package ss6_inheritance.exercise.triangle;

public class Shape {
    private double side;

    public Shape() {
        this.side = 1.0;
    }

    public Shape(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void set(double side) {
        this.side = side;
    }
    public double getArea() {
        return  0;
    }

    public double getPerimeter() {
        return  0;
    }

    @Override
    public String toString() {
        return String.format("[Shape] side%f", this.side);
    }
}
