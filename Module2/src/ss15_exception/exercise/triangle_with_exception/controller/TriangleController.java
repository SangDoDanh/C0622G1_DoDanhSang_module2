package ss15_exception.exercise.triangle_with_exception.controller;

import ss15_exception.exercise.triangle_with_exception.service.ITriangleService;
import ss15_exception.exercise.triangle_with_exception.service.impl.TriangleService;

import java.util.Scanner;

public class TriangleController {
    private static final Scanner sc = new Scanner(System.in);
    private ITriangleService iTriangleService  = new TriangleService();
    public void run() {
        int choose;
        while (true) {
            mainMenu();
            choose = Integer.parseInt(sc.nextLine());
            switch(choose) {
                case 1:
                    iTriangleService.add();
                    break;
                case 2:
                    iTriangleService.display();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Vui lòng chọn chức năng 1 - 3");
            }
        }
    }
    public void mainMenu() {
        System.out.println("1. Tạo một hình tam giác");
        System.out.println("2. Hiển thị danh sách các hình tam giác");
        System.out.println("3. Thoát");
        System.out.print("Chọn chức năng: ");
    }

    public void inIt() {
        iTriangleService.inIt();
    }
}
