package person_management.service.impl;

import person_management.model.Person;
import person_management.model.Student;
import person_management.service.IStudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Student> students = new ArrayList<>();

    static {
        students.add(new Student(1, "A", "1/1/1996", "nam", "CO6", 0.0));
        students.add(new Student(2, "C", "1/1/1997", "nu", "CO6", 0.0));
        students.add(new Student(3, "E", "1/1/1998", "nam", "CO6", 0.0));
        students.add(new Student(4, "D", "1/1/1995", "nam", "CO6", 0.0));
        students.add(new Student(5, "B", "1/1/1999", "nu", "CO6", 0.0));
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
        System.out.println("--DANH SÁCH HỌC SINH--");
        System.out.printf("|%-6s|%-15s|%-10s|%-5s|%-7s|%-5s|\n",
                "ID", "NAME", "DOB", "GENDER", "CLASS", "POINT");
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

        if (studentIndex > -1) {
            System.out.printf("Nhập 1 sẽ xóa học sinh có id = %d: ", id);
            int conform = Integer.parseInt(sc.nextLine());
            if (conform == 1) {
                students.remove(studentIndex);
                System.out.println("Xóa thành công!");
                showStudentList();
            }
        }
    }
    /**
     * Tìm kiếm các và hiển thị các giáo viên có tên chứa từ khóa tìm kiếm
     * ví dụ: Có 3 học sinh là Hoa, Hồng, Tuấn
     * từ khóa tìm kiếm là : H
     * sẽ hiển thị thông tin của 2 học sinh Hoa và hồng
     */
    @Override
    public void findByName() {
        String nameFind;
        System.out.println("Nhập tên học sinh cần tìm:");
        nameFind = sc.nextLine();
        List<Person> personListByName = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(nameFind)) {
                personListByName.add(student);
            }
        }
        if (personListByName.size() < 1) {
            System.out.println("Không tìm thấy học sinh nào!");
        } else {
            System.out.println("--DANH SÁCH HỌC SINH TÌM ĐƯỢC--");
            System.out.printf("|%-6s|%-15s|%-10s|%-5s|%-7s|%-5s|\n",
                    "ID", "NAME", "DOB", "GENDER", "CLASS", "POINT");
            for (Person person : personListByName) {
                System.out.println(person);
            }
        }

    }

    @Override
    public void findById() {
        int id;
        int findStudentIndex;
        System.out.println("Nhập id của học sinh cần tìm:");
        id = Integer.parseInt(sc.nextLine());
        findStudentIndex = indexOf(id);
        if (findStudentIndex > -1) {
            System.out.println(students.get(findStudentIndex));
        } else {
            System.out.println("Không tìm thấy học sinh nào!");
        }
    }

    @Override
    public void sortByName() {
        boolean isSwap = true;
        int size = students.size();
        String s1;
        String s2;
        for (int i = 0; i < size && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < size - 1 - i; j++) {
                s1 = students.get(j).getName().toLowerCase();
                s2 = students.get(j + 1).getName().toLowerCase();
                if (s1.compareTo(s2) > 0) {
                    isSwap = true;
                    Student student = students.get(j);
                    students.set(j, students.get(j + 1));
                    students.set(j + 1, student);
                }
            }
        }
        showStudentList();
    }

    private int indexOf(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
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
