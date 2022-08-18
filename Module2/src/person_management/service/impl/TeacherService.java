package person_management.service.impl;

import person_management.model.Person;
import person_management.model.Student;
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
        teachers.add(new Teacher(3, "Hong", "12/12/2022", "NU", "SQL"));
        teachers.add(new Teacher(4, "Tu", "12/12/2022", "NU", "Python"));
        teachers.add(new Teacher(5, "Sang", "12/12/2022", "NU", "SQL"));
        teachers.add(new Teacher(6, "Trung", "12/12/2022", "NU", "SQL"));
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

    public void findById() {
        int id;
        int findStudentIndex;

        System.out.println("Nhập id của giáo viên cần tìm:");
        id = Integer.parseInt(sc.nextLine());
        findStudentIndex = indexOf(id);
        if(findStudentIndex > -1) {
            System.out.println(teachers.get(findStudentIndex));
        } else {
            System.out.println("Không tìm thấy giáo viên nào!");
        }
    }

    @Override
    public void sortByName() {
        boolean isSwap = true;
        int size = teachers.size();
        String s1;
        String s2;
        for (int i = 0; i < size && isSwap; i++) {
            isSwap = false;
            for (int j = 0; j < size - 1 - i; j++) {
                s1 = teachers.get(j).getName().toLowerCase();
                s2 = teachers.get(j + 1).getName().toLowerCase();
                if (s1.compareTo(s2) > 0) {
                    isSwap = true;
                    Teacher teacher = teachers.get(j);
                    teachers.set(j, teachers.get(j + 1));
                    teachers.set(j + 1, teacher);
                }
            }
        }
        display();
    }

    /**
     * Tìm kiếm các và hiển thị các giáo viên có tên chứa từ khóa tìm kiếm
     * ví dụ: Có 3 giáo viên là Hoa, Hồng, Tuấn
     * từ khóa tìm kiếm là : H
     * sẽ hiển thị thông tin của 2 giáo viên Hoa và hồng
     */
    public void findByName() {
        String nameFind;
        System.out.println("Nhập tên giáo viên cần tìm:");
        nameFind = sc.nextLine();
        List<Person> personListByName = new ArrayList<>();
        for(Teacher teacher : teachers) {
            if(teacher.getName().contains(nameFind)) {
                personListByName.add(teacher);
            }
        }
        if(personListByName.size() < 1) {
            System.out.println("Không tìm thấy giáo viên nào!");
        } else {
            System.out.println("--DANH SÁCH GIÁO VIÊN TÌM ĐƯỢC--");
            System.out.printf("|%-6s|%-15s|%-10s|%-5s|%-7s|%-5s|\n",
                    "ID", "NAME", "DOB", "GENDER", "CLASS", "POINT");
            for (Person person : personListByName) {
                System.out.println(person);
            }
        }

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
        System.out.println("Nhập vào các thông tin sau cho giáo viên.");
        System.out.print("Mã số:");
        id = Integer.parseInt(sc.nextLine());

        System.out.print("\nTên:");
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
