package ss6_inheritance.exercise.point_and_moveable_point;

public class Main {
    public static void main(String[] args) {
        // create 1 MoveAblePoint
        MoveAblePoint pointMove = new MoveAblePoint(2, 3,1, 1);
        System.out.println(pointMove.toString());

        // move speed xSpeed = 1, ySpeed = 1
        pointMove = pointMove.move();
        System.out.println(pointMove.toString());
        // move again
        pointMove = pointMove.move();
        System.out.println(pointMove);
    }
}
