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
        System.out.println("Th??m h???c sinh th??nh c??ng!");
        showStudentList();
    }

    @Override
    public void showStudentList() {
        students = readFileStudent(PATH_STUDENT);
        System.out.println("--DANH S??CH H???C SINH--");
        System.out.printf("|%-6s|%-15s|%-10s|%-5s|%-7s|%-5s|\n",
                "ID", "NAME", "DOB", "GENDER", "CLASS", "POINT");
        for (Student student : students) {
            System.out.println(student);
        }
    }

    /**
     * X??a m???t sinh vi??n ra kh???i students d???a theo id c???a sinh vi??n
     */
    @Override
    public void removeStudent() {
        System.out.print("Nh???p id mu???n x??a: \n");
        int id = Integer.parseInt(sc.nextLine());
        int studentIndex = indexOf(id);
        if (studentIndex > -1) {
            System.out.printf("Nh???p 1 s??? x??a h???c sinh c?? id = %d: ", id);
            int conform = Integer.parseInt(sc.nextLine());
            if (conform == 1) {
                students.remove(studentIndex);
                writeFileStudent(PATH_STUDENT);
                System.out.println("X??a th??nh c??ng!");
                showStudentList();
            }
        }
    }

    /**
     * T??m ki???m c??c v?? hi???n th??? c??c gi??o vi??n c?? t??n ch???a t??? kh??a t??m ki???m
     * v?? d???: C?? 3 h???c sinh l?? Hoa, H???ng, Tu???n
     * t??? kh??a t??m ki???m l?? : H
     * s??? hi???n th??? th??ng tin c???a 2 h???c sinh Hoa v?? h???ng
     */
    @Override
    public void findByName() {
        String nameFind;
        students = readFileStudent(PATH_STUDENT);
        System.out.println("Nh???p t??n h???c sinh c???n t??m:");
        nameFind = sc.nextLine();
        List<Person> personListByName = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().contains(nameFind)) {
                personListByName.add(student);
            }
        }
        if (personListByName.size() < 1) {
            System.out.println("Kh??ng t??m th???y h???c sinh n??o!");
        } else {
            System.out.println("--DANH S??CH H???C SINH T??M ???????C--");
            System.out.printf("|%-6s|%-15s|%-10s|%-5s|%-7s|%-5s|\n",
                    "ID", "NAME", "DOB", "GENDER", "CLASS", "POINT");
            for (Person person : personListByName) {
                System.out.println(person);
            }
        }

    }

    /**
     * T??m ki???m v?? hi???n th??? m???t h???c sinh t??m th???y
     * t??m ki???m d???a theo id c???a h???c sinh
     */
    @Override
    public void findById() {
        int id;
        int findStudentIndex;
        students = readFileStudent(PATH_STUDENT);
        System.out.println("Nh???p id c???a h???c sinh c???n t??m:");
        id = Integer.parseInt(sc.nextLine());
        findStudentIndex = indexOf(id);
        if (findStudentIndex > -1) {
            System.out.println(students.get(findStudentIndex));
        } else {
            System.out.println("Kh??ng t??m th???y h???c sinh n??o!");
        }
    }

    /**
     * T??m ki???m h???c sinh theo t??n
     * Hi???n th??? t???t c??? h???c sinh t??m ???????c
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
     * T??m ki???m v??? tr?? c???a h???c sinh trong students theo id c???a
     * @param id m?? s??? c???a h???c sinh c???n t??m
     * @return v??? tr?? , tr??? v??? -1 n???u ko t??m th???y
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
     * Nh???p th??ng tin cho h???c sinh
     * @return h???c sinh m???i
     */
    private Student inputStudentInfo() {
        int id;
        String name;
        String dob;
        String className;
        String gender;
        System.out.println("Nh???p v??o c??c th??ng tin sau");
        id = getIdAndCheck();
        name = InputService.getName("T??n h???c sinh: ");
        dob = InputService.getDate("Ng??y sinh dd/mm/yyyy:");
        gender = InputService.getStr("Gi???i t??nh: ");
        className = InputService.getClassName("L???p");
        return new Student(id, name, dob, gender, className, 0.0);
    }

    /**
     * Nh???p m???t m?? s??? m???i, v?? ki???m tra n?? ???? t???n t???i ch??a,
     * n???u t???n t???i y??u c???u nh???p l???i
     * m?? s??? t??? 01 -> 99999
     * @return m?? s??? m???i
     */
    private int getIdAndCheck() {
        int id;
        while (true) {
            id = InputService.getNumberInteger("M?? s???: ", 1, 99999);
            if (checkID(id)) {
                break;
            }else {
                System.out.println(id + ": ???? t???n t???i");
            }
        }
        return id;

    }

    /**
     * Ki???m tra m?? s??? h???c sinh ???? t???n t???i ch??a
     * @param id m?? s??? c???a sinh vi??n
     * @return false: id ???? t???n t???i
     */
    private boolean checkID(int id) {
        for (Student student: students) {
            if(student.getId() == id)
                return false;
        }
        return true;
    }
}
