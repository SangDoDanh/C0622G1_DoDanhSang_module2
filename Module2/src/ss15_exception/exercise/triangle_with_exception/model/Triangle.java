package ss15_exception.exercise.triangle_with_exception.model;

public class Triangle {
    private int a;
    private int b;
    private int c;

    public Triangle() {
        this.a = 1;
        this.b = 1;
        this.c = 1;
    }

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return String.format("Triangle |%4d|%4d|%4d", a, b, c);
    }

}
