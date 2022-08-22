package demo_io_file.controller;

import demo_io_file.model.Laptop;

import java.util.Scanner;

public class MainController {
    private static final Scanner SC = new Scanner(System.in);
    private static final LaptopController LAPTOP_CONTROLLER = new LaptopController();
    public void run() {
        System.out.println("Hello");
        int choose;
       while (true) {
           menu();
           choose = Integer.parseInt(SC.nextLine());
           switch (choose) {
               case 1:
                   LAPTOP_CONTROLLER.add();
                   break;
               case 2:
                   LAPTOP_CONTROLLER.display();
                   break;
               case 3:
                   return;
           }
       }
    }

    private void menu() {
        System.out.println("1. Thêm mới laptop");
        System.out.println("2. Hiển thị danh sách laptop");
        System.out.println("3. Thoát");
        System.out.print("Chọn chức năng: ");
    }
}
