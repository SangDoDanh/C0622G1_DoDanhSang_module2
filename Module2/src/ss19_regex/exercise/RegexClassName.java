package ss19_regex.exercise;

import java.util.Scanner;

public class RegexClassName {
    public static void main(String[] args) {
        boolean isClassName;
        String className;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Class name: ");
        className = sc.nextLine();
        isClassName = checkClassName(className);
        System.out.println(isClassName);
    }
    static boolean checkClassName(String name) {
        String regex = "[CAP]\\d{4}[GHIKLM]";
        return name.matches(regex);
    }
}
