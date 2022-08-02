package ss5_access_modifier_static.exercise.access_modifier;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(3);
        System.out.println("circle1 radius: " + circle1.getRadius());
        System.out.println("circle2 area: " + circle1.getArea());

    }
}
