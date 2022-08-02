package ss5_access_modifier_static.exercise.read_only;

public class Student {
    private String name;
    private String classes;

    public Student() {
        this.name = "john";
        this.classes = "C0622G1";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\tClasses: %s", this.name, this.classes);
    }
}
