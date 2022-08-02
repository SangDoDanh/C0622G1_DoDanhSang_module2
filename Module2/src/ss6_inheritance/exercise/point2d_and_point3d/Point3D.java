package ss6_inheritance.exercise.point2d_and_point3d;

public class Point3D extends Point2D {
    private float z;

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        return new float[] {this.getX(), this.getY(), this.getY()};
    }

    @Override
    public String toString() {
        return String.format("[point 2d] x: %f\ty: %f\tz: %f", this.getX(), this.getY(), this.z);

    }
}
