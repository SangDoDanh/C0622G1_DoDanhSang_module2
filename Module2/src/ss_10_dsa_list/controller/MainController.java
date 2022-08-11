package ss_10_dsa_list.controller;

import ss_10_dsa_list.model.MyArrayList;
import ss_10_dsa_list.model.Student;

public class MainController {
    public static void main(String[] args) {
        Student s1 = new Student(1, "Nam");
        Student s4 = new Student(2, "Hue");
        Student s3 = new Student(3, "Ty");
        Student s2 = new Student(4, "Minh");

        MyArrayList<Student> studentList = new MyArrayList<>(10);
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
//        for(int i = 0; i < studentList.size(); i++) {
//            System.out.println(studentList.get(i));;
//        }
//        System.out.println(studentList.contains(new Student()));
//        MyArrayList<Student> newM = studentList.clone();
//
//        for(int i = 0; i < newM.size(); i++) {
//            System.out.println(newM.get(i).getName());
//        }
        studentList.remove(2);
        for(int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i).getName());
        }
    }
}
