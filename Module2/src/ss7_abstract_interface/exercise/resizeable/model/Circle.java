package ss7_abstract_interface.exercise.resizeable.model;

public class Circle extends Shape {
    private double radius = 1.0;

    public Circle() {
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }

    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    @Override
    public String toString() {
        return String.format("CIRCLE radius: %.2f area: %.2f", this.getRadius(), this.getArea());
    }

    @Override
    public void resize(double percent) {
        double newRadius = this.getRadius() * (1 + percent /100);
        this.setRadius(newRadius);
    }
}
