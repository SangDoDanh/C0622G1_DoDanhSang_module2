package ss7_abstract_interface.exercise.colorable.control;

import ss7_abstract_interface.exercise.colorable.model.*;

public class MainController {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 10);
        Shape circle = new Circle(5);
        Shape square = new Square(5);

        Shape[] shapes = new Shape[]{rectangle, circle, square};
        for(Shape shape: shapes) {
            if(shape instanceof Colorable) {
                ((Colorable) shape).howToColor();
            } else {
                System.out.println( shape.getArea());
            }
        }
    }
}
