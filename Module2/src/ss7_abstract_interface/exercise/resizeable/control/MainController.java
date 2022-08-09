package ss7_abstract_interface.exercise.resizeable.control;

import ss7_abstract_interface.exercise.resizeable.model.Circle;
import ss7_abstract_interface.exercise.resizeable.model.Rectangle;
import ss7_abstract_interface.exercise.resizeable.model.Shape;

public class MainController {
    public static void main(String[] args) {

        Shape circle = new Circle(3);
        Shape rectangle = new Rectangle(3, 9);


        // test Circle
        System.out.println(circle);
        circle.resize((Math.random()) * ((100 - 1) + 1) + 1);
        System.out.println(circle);

        // test Rectangle
        System.out.println(rectangle);
        rectangle.resize((Math.random()) * ((100 - 1) + 1) + 1);
        System.out.println(rectangle);

    }
}
