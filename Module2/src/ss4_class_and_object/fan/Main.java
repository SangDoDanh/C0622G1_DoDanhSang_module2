package ss4_class_and_object.fan;

public class Main {
    public static void main(String[] args) {
        Fan fan1 = new Fan();
        Fan fan2 = new Fan(3, true, 30, "red");
        System.out.println("-----------------------");
        System.out.println(fan1.toString());
        System.out.println(fan2.toString());
    }
}
