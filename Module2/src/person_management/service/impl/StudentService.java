package person_management.service.impl;

import person_management.model.Person;
import person_management.model.Student;
import person_management.service.IStudentService;
import person_management.service.utils.read_write.ReadFile;
import person_management.service.utils.read_write.WriteFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private static final Scanner sc = new Scanner(System.in);
    private static final String PATH_STUDENT = "Module2/src/person_management/service/data/student.txt";
    private static List<Student> students = readFileStudent(PATH_STUDENT);

    private static List<Student> readFileStudent(String path) {
        List<String> studentListString = ReadFile.readFile(path);
        List<Student> studentList = new ArrayList<>();
        if(studentListString.size() == 0) {
            System.out.println("Khong co du lieu");;
            return studentList;
        } else {
            for(String s : studentListString) {
                String[] studentString = s.split(",");
                studentList.add(new Student(
                        Integer.parseInt(studentString[0]),
                        studentString[1],
                        studentString[2],
                        studentString[3],
                        studentString[4],
                        Double.parseDouble(studentString[5])));
            }
        }

        return studentList;
    }

    private static final String[] GENDER = {"Male", "FMale", "Other"};

    private void writeFileStudent(String path) {
        List<String> studentsString = convertStudentToString(students);
        WriteFile.writeFile(path, studentsString);
    }

    private List<String> convertStudentToString(List<Student> studentList) {
        List<String> studentsString = new ArrayList<>();
        String line = "";
        for(Student s : students) {
            line =      s.getId() +","
                        + s.getName() +","
                        + s.getDateOfBirth() +","
                        + s.getGender()+","
                        + s.getPoint()+","
                        +s.getName();
            studentsString.add(line);
        }
        return studentsString;
    }

    @Override
    public void addAStudent() {
        Student student = inputStudentInfo();
        students = readFileStudent(PATH_STUDENT);
        students.add(student);
        writeFileStudent(PATH_STUDENT);
        System.out.println("Thêm học sinh thành công!");
        showStudentList();
    }

    @Override
    public void showStudentList() {
        students = readFileStudent(PATH_STUDENT);
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
                writeFileStudent(PATH_STUDENT);
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
        students = readFileStudent(PATH_STUDENT);
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

    /**
     * Tìm kiếm và hiển thị một học sinh tìm thấy
     * tìm kiếm dựa theo id của học sinh
     */
    @Override
    public void findById() {
        int id;
        int findStudentIndex;
        students = readFileStudent(PATH_STUDENT);
        System.out.println("Nhập id của học sinh cần tìm:");
        id = Integer.parseInt(sc.nextLine());
        findStudentIndex = indexOf(id);
        if (findStudentIndex > -1) {
            System.out.println(students.get(findStudentIndex));
        } else {
            System.out.println("Không tìm thấy học sinh nào!");
        }
    }

    /**
     * Tìm kiếm học sinh theo tên
     * Hiển thị tất cả học sinh tìm được
     */
    @Override
    public void sortByName() {
        boolean isSwap = true;
        students = readFileStudent(PATH_STUDENT);
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

    /**
     * Tìm kiếm vị trí của học sinh trong students theo id của
     * @param id mã số của học sinh cần tìm
     * @return vị trí , trả về -1 nếu ko tìm thấy
     */
    private int indexOf(int id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Nhập thông tin cho học sinh
     * @return học sinh mới
     */
    private Student inputStudentInfo() {
        int id;
        String name;
        String dob;
        String className;
        String gender;
        System.out.println("Nhập vào các thông tin sau");
        id = getIdAndCheck();
        name = InputService.getName("Tên học sinh: ");
        dob = InputService.getDate("Ngày sinh dd/mm/yyyy:");
        gender = InputService.getStr("Giới tính: ");
        className = InputService.getClassName("Lớp");
        return new Student(id, name, dob, gender, className, 0.0);
    }

    /**
     * Nhập một mã số mới, và kiểm tra nó đã tồn tại chưa,
     * nếu tồn tại yêu cầu nhập lại
     * mã số từ 01 -> 99999
     * @return mã số mới
     */
    private int getIdAndCheck() {
        int id;
        while (true) {
            id = InputService.getNumberInteger("Mã số: ", 1, 99999);
            if (checkID(id)) {
                break;
            }else {
                System.out.println(id + ": đã tồn tại");
            }
        }
        return id;

    }

    /**
     * Kiểm tra mã số học sinh đã tồn tại chưa
     * @param id mã số của sinh viên
     * @return false: id đã tồn tại
     */
    private boolean checkID(int id) {
        for (Student student: students) {
            if(student.getId() == id)
                return false;
        }
        return true;
    }
}
