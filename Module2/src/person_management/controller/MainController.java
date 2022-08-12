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
                    runStudent();
                    break;
                case 2:
                    runTeacher();
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
    public void runStudent() {
        while (true) {
            menuAll("học sinh");
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
    public void runTeacher() {
        while (true) {
            menuAll("giáo viên");
            System.out.print("Chọn chức năng: ");
            int choise = Integer.parseInt(sc.nextLine());
            switch (choise) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:

                    break;
                case 4:
                    return;
                default:
                    System.out.println("Vui lòng chọn chức năng từ 1...4 !");
            }
        }

    }
    public void showMenu() {
        System.out.println("1. Quản lý học sinh");
        System.out.println("2. Quản lý giáo viên");
        System.out.println("3. Thoát");
    }

    public void menuAll(String option) {
        System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ "+option.toUpperCase()+"--");
        System.out.println("1. Thêm mới " + option);
        System.out.println("2. Xóa một " + option);
        System.out.println("3. Xem danh sách " + option);
        System.out.println("4. Thoát");
    }
}
