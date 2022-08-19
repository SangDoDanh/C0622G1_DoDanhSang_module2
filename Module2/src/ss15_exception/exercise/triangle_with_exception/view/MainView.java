package ss15_exception.exercise.triangle_with_exception.view;

import ss15_exception.exercise.triangle_with_exception.controller.TriangleController;

public class MainView {
    public static void main(String[] args) {
        TriangleController triangleController = new TriangleController();
        triangleController.inIt();
        triangleController.run();

    }
}
