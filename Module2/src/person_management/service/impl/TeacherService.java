package person_management.service.impl;

import person_management.model.Person;
import person_management.model.Student;
import person_management.model.Teacher;
import person_management.service.ITeacher;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherService implements ITeacher {
    private static final Scanner sc = new Scanner(System.in);
    private static final String PATH_TEACHER = "Module2/src/person_management/service/data/teacher.txt";
    private static  List<Teacher> teachers = readFile(PATH_TEACHER);

    private static List<Teacher> readFile(String path) {
        File fileStudent = new File(path);
        List<Teacher> teacherList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileStudent);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] studentsString = line.split(",");
                Teacher teacher = new Teacher();

                teacher.setId(Integer.parseInt(studentsString[0]));
                teacher.setName(studentsString[1]);
                teacher.setDateOfBirth(studentsString[2]);
                teacher.setGender(studentsString[3]);
                teacher.setBest(studentsString[4]);
                teacherList.add(teacher);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Đường dẫn bị lỗi!");
        } catch (IOException e) {
            System.out.println("Khong co du lieu!");
        }
        return teacherList;
    }

    private void write(String path) {
        File file = new File(path);
        try{
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line;
            for(Teacher teacher: teachers) {
                line = String.format("%s,%s,%s,%s,%s,",
                        teacher.getId(),
                        teacher.getName(),
                        teacher.getDateOfBirth(),
                        teacher.getGender(),
                        teacher.getBest());
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ko tim thay file student");
        } catch (IOException e)  {
            System.out.println("ko co noi dung!");
        }
    }

    /**
     * thêm một giáo viên vào teachers
     */
    @Override
    public void add() {
        Teacher teacher = createTeacher();
        teachers = readFile(PATH_TEACHER);
        teachers.add(teacher);
        write(PATH_TEACHER);
        System.out.println("Thêm mới giáo viên thành công!");
    }

    public void findById() {
        int id;
        int findStudentIndex;
        teachers = readFile(PATH_TEACHER);
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
        teachers = readFile(PATH_TEACHER);
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
        teachers = readFile(PATH_TEACHER);
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
        teachers = readFile(PATH_TEACHER);
        if (teacherIndex > -1) {
            System.out.printf("Nhập 1 sẽ xóa giáo viên có id = %d: ", id);
            int conform = Integer.parseInt(sc.nextLine());
            if (conform == 1) {
                teachers.remove(teacherIndex);
                write(PATH_TEACHER);
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
        teachers = readFile(PATH_TEACHER);
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
        id = getIdAndCheck();
        name = InputService.getStr("Tên học sinh: ");
        dob = InputService.getDate("Ngày sinh dd/mm/yyyy:");
        gender = InputService.getStr("Giới tính: ");
        best = InputService.getStr("Best");
        return new Teacher(id, name, dob, gender, best);
    }

    /**
     * Nhập một mã số mới cho giáo viên , và kiểm tra nó đã tồn tại chưa,
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
     * Kiểm tra mã số giáo viên đã tồn tại chưa
     * @param id mã số của giáo viên
     * @return false: nếu id đã tồn tại
     */
    private boolean checkID(int id) {
        for (Teacher teacher: teachers) {
            if(teacher.getId() == id)
                return false;
        }
        return true;
    }
}
