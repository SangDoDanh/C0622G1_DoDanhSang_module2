package person_management.service.impl;

import person_management.model.Teacher;
import person_management.service.ITeacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacher {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<Teacher> teachers = new ArrayList<>();
    static {
        teachers.add(new Teacher(1, "Quang", "12/12/2022", "Nam", "JAVA"));
        teachers.add(new Teacher(2, "Hue", "12/12/2022", "NU", "SQL"));
    }

    /**
     * thêm một giáo viên vào teachers
     */
    @Override
    public void add() {
        Teacher teacher = createTeacher();
        teachers.add(teacher);
        System.out.println("Thêm mới giáo viên thành công!");
    }

    /**
     * xóa một giáo viên khỏi teachers, dựa trên id giáo viên
     */
    @Override
    public void remove() {
        System.out.print("Nhập id muốn xóa: \n");
        int id = Integer.parseInt(sc.nextLine());
        int teacherIndex = indexOf(id);

        if (teacherIndex > -1) {
            System.out.printf("Nhập 1 sẽ xóa giáo viên có id = %d: ", id);
            int conform = Integer.parseInt(sc.nextLine());
            if (conform == 1) {
                teachers.remove(teacherIndex);
                System.out.println("Xóa thành công!");
                display();
            }
        }
    }

    /**
     * Hiển thị tất cả giáo viên có trong teachers
     */
    @Override
    public void display() {
        System.out.println("--DANH SÁCH GIÁO VIÊN--");
        System.out.printf("|%-6s|%-15s|%-10s|%-6s|%-7s|\n",
                "ID", "NAME", "DOB", "GENDER", "BEST");
        for (Teacher teacher : teachers) {
            System.out.println(teacher);
        }
    }
    private int indexOf(int id) {
        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Nhập thông tin cho giáo viên và tạo mới 1 giáo viên
     * @return : giáo viên mới
     */
    private Teacher createTeacher() {
        int id;
        String name;
        String dob;
        String best;
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

        System.out.print("\nChuyên môn:");
        best = sc.nextLine();
        return new Teacher(id, name, dob, gender, best);
    }
}
