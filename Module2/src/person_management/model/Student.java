package person_management.model;

public class Student extends Person{
    private String className;
    private double point;

    public Student() {
    }

    public Student(int id, String name, String dateOfBirth, String gender, String className, double point) {
        super(id, name, dateOfBirth, gender);
        this.className = className;
        this.point = point;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getPoint() {
        return point;
    }

    public void setPoint(double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return String.format("|%-6d|%-15s|%-10s|%-6s|%-7s|%-5.2f|",
                this.getId(), this.getName(), this.getDateOfBirth(), this.getGender(),className, point);
    }
}
