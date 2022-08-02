package ss6_inheritance.exercise.point2d_and_point3d;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // create 2 Point2d
        Point2D point2d = new Point2D(9, 9);
        Point2D point3d = new Point3D(9, 9, 9);

        System.out.println(point2d.toString());
        System.out.println(point3d.toString());

        // set and get for point2d
        point2d.setXY(5, 5);
        System.out.println("Point 2D: " + Arrays.toString(point2d.getXY()));

        // set and get for point3d
        ((Point3D) point3d).setXYZ(7, 8, 9);
        System.out.println("Point 3D: " + Arrays.toString(((Point3D)point3d).getXYZ()));

    }
}
