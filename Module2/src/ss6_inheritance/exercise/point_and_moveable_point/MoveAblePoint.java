package ss6_inheritance.exercise.point_and_moveable_point;

public class MoveAblePoint extends Point{
    private float xSpeed;
    private float ySpeed;

    public MoveAblePoint() {
        super();
        this.xSpeed = 1.0f;
        this.ySpeed = 1.0f;
    }

    public MoveAblePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MoveAblePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed (float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed() {
        return new float[] {this.xSpeed, this.ySpeed};
    }

    @Override
    public String toString() {
        return String.format("[%f, %f], speed = (%f, %f)", this.getX(), this.getY(), this.xSpeed, this.ySpeed);
    }

    public MoveAblePoint move () {
        this.setX(this.getX() + this.xSpeed);
        this.setY(this.getY() + this.ySpeed);
        return this;
    }
}
