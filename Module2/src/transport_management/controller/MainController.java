package transport_management.controller;

import transport_management.service.ICarService;
import transport_management.service.IMotorService;
import transport_management.service.ITruckService;
import transport_management.service.impl.CarService;
import transport_management.service.impl.MotorService;
import transport_management.service.impl.TruckService;

import java.util.Scanner;

public class MainController {
    public static final Scanner sc = new Scanner(System.in);
    public static final ICarService I_CAR_SERVICE = new CarService();
    public static final IMotorService I_MOTOR_SERVICE = new MotorService();
    public static final ITruckService I_TRUCK_SERVICE = new TruckService();
    public static final int FUNCTION_SELECT_1 = 1;
    public static final int FUNCTION_SELECT_2 = 2;
    public static final int FUNCTION_SELECT_3 = 3;
    public static final int FUNCTION_SELECT_4 = 4;
    public static final int FUNCTION_SELECT_5 = 5;

    public void start() {
        inIt();
        int choose;
        while (true) {
            mainMenu();
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case FUNCTION_SELECT_1:
                    addMenu();
                    break;
                case FUNCTION_SELECT_2:
                    displayMenu();
                    break;
                case FUNCTION_SELECT_3:
                    removeMenu();
                    break;
                case FUNCTION_SELECT_4:
                    findMenu();
                    break;
                case FUNCTION_SELECT_5:
                    return;
            }
        }
    }

    /**
     * Khỏi tạo dữ liệu ban đầu, tạo mới 2 Car, 2 Mortor, 1 Truck
     */
    public void inIt() {
        I_CAR_SERVICE.inIt();
        I_MOTOR_SERVICE.inIt();
        I_TRUCK_SERVICE.inIt();
    }

    /**
     * menu chức năng hiển thị các loại xe
     */
    private void displayMenu() {
        int displayChoose;
        while (true) {
            functionMenu("Hiển thị");
            displayChoose = Integer.parseInt(sc.nextLine());
            switch (displayChoose) {
                case FUNCTION_SELECT_1:
                    I_CAR_SERVICE.show();
                    break;
                case FUNCTION_SELECT_2:
                    I_MOTOR_SERVICE.show();
                    break;
                case FUNCTION_SELECT_3:
                    I_TRUCK_SERVICE.show();
                    break;
                case FUNCTION_SELECT_4:
                    return;
            }
        }
    }

    /**
     * menu chính hiển thị các chức năng của chươn trình quản lý phương tiện giao thông
     */
    void mainMenu() {
        System.out.println("--CHƯƠNG TRÌNH QUẢN LÝ PHƯƠNG TIỆN GIAO THÔNG--");
        System.out.println("1. Thêm phương tiện");
        System.out.println("2. Hiển thị phương tiện");
        System.out.println("3. Xóa phương tiện");
        System.out.println("4. Tìm kiếm theo biển kiểm soát");
        System.out.println("5. Thoát");
        System.out.print("Chọn chức năng: \n");
    }

    /**
     * menu chức năng thêm mới một xe
     */
    void addMenu() {
        int addChoose;
        while (true) {
            functionMenu("Thêm");
            addChoose = Integer.parseInt(sc.nextLine());
            switch (addChoose) {
                case FUNCTION_SELECT_1:
                    I_CAR_SERVICE.add();
                    break;
                case FUNCTION_SELECT_2:
                    I_MOTOR_SERVICE.add();
                    break;
                case FUNCTION_SELECT_3:
                    I_TRUCK_SERVICE.add();
                    break;
                case FUNCTION_SELECT_4:
                    return;
            }
        }

    }

    /**
     * menu chức năng xóa một xe
     */
    void removeMenu() {
        int chooseRemove;
        while (true) {
            functionMenu("Xóa");
            chooseRemove = Integer.parseInt(sc.nextLine());
            switch (chooseRemove) {
                case FUNCTION_SELECT_1:
                    I_CAR_SERVICE.remove();
                    break;
                case FUNCTION_SELECT_2:
                    I_MOTOR_SERVICE.remove();
                    break;
                case FUNCTION_SELECT_3:
                    I_TRUCK_SERVICE.remove();
                    break;
                case FUNCTION_SELECT_4:
                    return;
            }
        }
    }

    /**
     * menu chức năng tìm kiếm xe
     */
    void findMenu() {
        int chooseFind;
        while (true) {
            functionMenu("Tìm kiếm");
            chooseFind = Integer.parseInt(sc.nextLine());
            switch (chooseFind) {
                case FUNCTION_SELECT_1:
                    I_CAR_SERVICE.find();
                    break;
                case FUNCTION_SELECT_2:
                    I_MOTOR_SERVICE.find();
                    break;
                case FUNCTION_SELECT_3:
                    I_TRUCK_SERVICE.find();
                    break;
                case FUNCTION_SELECT_4:
                    return;
            }
        }
    }

    /**
     * menu hiển thị tên chức năng
     * @param function tên chức năng
     */
    void functionMenu(String function) {
        System.out.printf("1. %s ô tô\n", function);
        System.out.printf("2. %s xe máy\n", function);
        System.out.printf("3. %s xe tải\n", function);
        System.out.println("4. Thoát");
        System.out.print("Chọn chức năng: \n");
    }

}
