package ss6_inheritance.exercise.circle_and_cylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(2, "black");
        Circle cylinder = new Cylinder(2, "red", 3);

        System.out.println(circle.toString());
        System.out.println(cylinder.toString());
    }
}
