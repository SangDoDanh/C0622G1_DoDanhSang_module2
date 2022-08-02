package ss5_access_modifier_static.exercise.read_only;

public class Main {
    public static void main(String[] args) {
        Student std1 = new Student();
        Student std2 = new Student();
        // set new name for std1
        std1.setName("No name");
        // set new classes for std1
        std1.setClasses("No Classes");
        //info std1
        System.out.println(std1.toString());
        System.out.println(std2.toString());
    }
}
