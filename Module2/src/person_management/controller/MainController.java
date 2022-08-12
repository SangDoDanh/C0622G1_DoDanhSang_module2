package person_management.controller;

import person_management.service.IStudentService;
import person_management.service.ITeacher;
import person_management.service.impl.StudentService;
import person_management.service.impl.TeacherService;

import java.util.Scanner;

public class MainController {
    private final static Scanner sc = new Scanner(System.in);
    public static IStudentService iStudentService = new StudentService();

    public static ITeacher iTeacher = new TeacherService();


    public void run() {
        int choise;
        while (true) {
            showMenu();
            choise = Integer.parseInt(sc.nextLine());
            switch (choise) {
                case 1:
                    studentMenu();
                    break;
                case 2:
                    teacherMenu();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Vui lòng nhập chức năng từ 1...3!");
            }
        }
    }


    /**
     * Chương trình quản lý học sinh
     */
    public void studentMenu() {
        while (true) {
            menuOption("học sinh");
            System.out.print("Chọn chức năng: ");
            int choise = Integer.parseInt(sc.nextLine());
            switch (choise) {
                case 1:
                    iStudentService.addAStudent();
                    break;
                case 2:
                    iStudentService.removeStudent();
                    break;
                case 3:
                    iStudentService.showStudentList();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Vui lòng chọn chức năng từ 1...4 !");
            }
        }
    }

    /**
     * Chương trình quản lý giáo viên
     */
    public void teacherMenu() {
        while (true) {
            menuOption("giáo viên");
            System.out.print("Chọn chức năng: ");
            int choise = Integer.parseInt(sc.nextLine());
            switch (choise) {
                case 1:
                    iTeacher.add();
                    break;
                case 2:
                    iTeacher.remove();
                    break;
                case 3:
                    iTeacher.display();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Vui lòng chọn chức năng từ 1...4 !");
            }
        }

    }
    private void showMenu() {
        System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ GIÁO VIÊN VÀ HỌC SINH--");
        System.out.println("1. Chương trình quản lý học sinh");
        System.out.println("2. Chương trình quản lý giáo viên");
        System.out.println("3. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    private void menuOption(String option) {
        System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ "+option.toUpperCase()+"--");
        System.out.println("1. Thêm mới " + option);
        System.out.println("2. Xóa một " + option);
        System.out.println("3. Xem danh sách " + option);
        System.out.println("4. Thoát");
    }
}
