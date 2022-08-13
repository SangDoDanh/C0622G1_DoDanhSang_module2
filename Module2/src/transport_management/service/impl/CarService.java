package transport_management.service.impl;

import transport_management.model.Car;
import transport_management.model.Transport;
import transport_management.service.ICarService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarService implements ICarService {
    public static final Scanner SC = new Scanner(System.in);
    private static final List<Transport> CAR_LIST = new ArrayList<>();// danh sách xe ô tô

    /**
     * thêm mới một Car vào CAR_LIST
     */
    @Override
    public void add() {
        CAR_LIST.add(inputInfoCar());
        System.out.println("Thêm ô tô thành công");
        show();
    }

    /**
     * Hiển thị Car có trong CAR_LIST
     */
    @Override
    public void show() {
        MyUtil.display(CAR_LIST);
    }

    /**
     * Xóa một xe ra khỏi CAR_LIST
     */
    @Override
    public void remove() {
        MyUtil.remove(CAR_LIST);
        show();
    }

    /**
     * Khởi tạo dữ liệu cho CAR_LIST
     */
    @Override
    public void inIt() {
        CAR_LIST.add(new Car("123456", "Honda", "1998", "My",30, "Bus"));
        CAR_LIST.add(new Car("567899", "TOYOTA", "1998", "My",30, "Bus"));
    }

    @Override
    public void find() {
        MyUtil.find(CAR_LIST);
    }

    /**
     * tạo và gán các thuộc tính cho Car mới
     * @return Car mới
     */
    private Car inputInfoCar() {
        int seats;
        String carStyle;
        MyUtil.inputInfo();
        System.out.println("Số chỗ ngồi");
        seats = Integer.parseInt(SC.nextLine());
        System.out.println("Kiểu xe");
        carStyle = SC.nextLine();
        return new Car(MyUtil.licensePlates, MyUtil.manufacture, MyUtil.yearOfManufacture, MyUtil.owner, seats, carStyle);
    }
}
