package ss7_abstract_interface.exercise.resizeable.model;

public class Rectangle extends Shape {
    private double width = 1.0;
    private double length = 1.0;

    public Rectangle() {
    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getArea() {
        return width * this.length;
    }

    public double getPerimeter() {
        return 2 * (width + this.length);
    }

    @Override
    public String toString() {
        return String.format("RECTANGLE width: %.2f length: %.2f area: %f.2", this.getWidth(), this.getLength(), this.getArea());
    }

    @Override
    public void resize(double percent) {
        double newWidth = this.getWidth() * (1 + percent /100);
        double newLength = this.getLength() * (1 + percent /100);
        this.setLength(newLength);
        this.setWidth(newWidth);
    }
}