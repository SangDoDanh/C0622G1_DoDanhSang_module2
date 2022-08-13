package transport_management.service.impl;

import transport_management.model.Motor;
import transport_management.model.Transport;
import transport_management.service.IMotorService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MotorService implements IMotorService {
    private static final Scanner SC = new Scanner(System.in);

    public static final List<Transport> MOTOR_LIST = new ArrayList<>();// danh sách xe máy

    /**
     * Thêm mới một Motor vào MOTOR_LIST
     */
    @Override
    public void add() {
        Transport motor = inputInfoMoto();
        MOTOR_LIST.add(motor);
        System.out.println("Thêm xe máy thành công");
        show();
    }

    /**
     * Xóa một Motor khỏi MOTOR_LIST
     */
    @Override
    public void remove() {
        MyUtil.remove(MOTOR_LIST);
        show();
    }

    /**
     * Hiển thị tất cả motor có trong MOTOR_LIST
     */
    @Override
    public void show() {
        MyUtil.display(MOTOR_LIST);
    }

    /**
     * Khỏi tạo dữ liệu cho MOTOR_LIST
     */
    @Override
    public void inIt() {
        MOTOR_LIST.add(new Motor("234567", "HONDA", "1998", "Hung", 150));
        MOTOR_LIST.add(new Motor("345678", "YAMAHA", "1998", "Hung", 150));
    }

    /**
     * Tìm kiếm motor trong MOTOR_LIST
     */
    @Override
    public void find() {
        MyUtil.find(MOTOR_LIST);
    }

    /**
     * tạo và nhập thông tin cho motor mới
     * @return motor mới
     */
    private Motor inputInfoMoto() {
        int power;
        MyUtil.inputInfo();
        System.out.println("Phân khối:");
        power = Integer.parseInt(SC.nextLine());
        return new Motor(MyUtil.licensePlates, MyUtil.manufacture, MyUtil.yearOfManufacture, MyUtil.owner, power);
    }

}
