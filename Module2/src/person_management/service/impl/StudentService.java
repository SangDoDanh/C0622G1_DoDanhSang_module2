package person_management.service.impl;

import person_management.model.Student;
import person_management.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "A", "1/1/1996", "nam", "CO6",0.0));
        students.add(new Student(2, "B", "1/1/1998", "nu", "CO6",0.0));
    }

    @Override
    public void addAStudent() {
        Student student = inputStudentInfo();
        students.add(student);
        System.out.println("Thêm học sinh thành công!");
        showStudentList();
    }

    @Override
    public void showStudentList() {
        System.out.printf("|%-6s|%-15s|%-10s|%-5s|%-7s|%-5s|\n",
                "ID", "NAME", "DOB", "GENDER","CLASS", "POINT");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     * Xóa một sinh viên ra khỏi students dựa theo id của sinh viên
     */
    @Override
    public void removeStudent() {
        System.out.print("Nhập id muốn xóa: \n");
        int id = Integer.parseInt(sc.nextLine());
        int studentIndex = indexOf(id);

        if(studentIndex > -1) {
            System.out.println("Chọn 1 để xóa học sinh có id = " + id);
            int conform = Integer.parseInt(sc.nextLine());
            if(conform == 1) {
                students.remove(studentIndex);
                System.out.println("Xóa thành công!");
                showStudentList();
            }
        }
    }

    private int indexOf(int id) {
        for(int i = 0; i < students.size(); i++) {
            if(students.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    private Student inputStudentInfo() {
        int id;
        String name;
        String dob;
        String className;
        String gender;
        System.out.println("Nhập vào các thông tin sau");
        System.out.print("Mã số:");
        id = Integer.parseInt(sc.nextLine());

        System.out.print("\nTên học sinh:");
        name = sc.nextLine();

        System.out.print("\nNgày sinh:");
        dob = sc.nextLine();

        System.out.print("\nGiới tính");
        gender = sc.nextLine();

        System.out.print("\nLớp:");
        className = sc.nextLine();
        return new Student(id, name, dob, gender, className, 0.0);
    }
}