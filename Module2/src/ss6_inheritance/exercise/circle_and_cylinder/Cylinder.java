package ss6_inheritance.exercise.circle_and_cylinder;

public class Cylinder extends Circle{
    private double height;

    public Cylinder() {
        super();
        this.height = 1.0;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    private double vCylinder() {
        return  Math.PI * (this.getRadius() * this.getRadius()) * this.height;
    }

    @Override
    public String toString() {
        return String.format("[Cylinder] color: %s\tradius: %f\tvArea: %.2f", this.getColor(), this.getRadius(), this.vCylinder());
    }
}
