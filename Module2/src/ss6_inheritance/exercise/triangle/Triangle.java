package ss6_inheritance.exercise.triangle;

public class Triangle extends Shape{
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        super();
        this.side1 = super.getSide();
        this.side2 = 1.0;
        this.side3 = 1.0;
    }

    public Triangle(double side, double side2, double side3) {
        super(side);
        this.side1 = super.getSide();
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public double getArea() {
        double p = this.getPerimeter() / 2;
        return Math.sqrt(p*(p - this.side1) * (p - this.side2) * (p - this.side3));
    }

    @Override
    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }

    @Override
    public String toString() {
        return String.format("[Triangle] side1: %f\tside2: %f\tside3: %f\tS: %f\tP: %f\t",
                this.side1, this.side2, this.side3, this.getArea(), this.getPerimeter());
    }
}
