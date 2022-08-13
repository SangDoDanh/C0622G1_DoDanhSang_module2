package transport_management.service.impl;

import transport_management.model.Transport;
import transport_management.model.Truck;
import transport_management.service.ITruckService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TruckService implements ITruckService {
    private static final Scanner SC = new Scanner(System.in);
    public static final List<Transport> TRUCK_LIST = new ArrayList<>();
    @Override
    public void add() {
        Transport truck = inputInfoTruck();
        TRUCK_LIST.add(truck);
        System.out.println("Thêm xe tải thành công");
        show();
    }

    @Override
    public void show() {
        MyUtil.display(TRUCK_LIST);
    }

    @Override
    public void remove() {
        MyUtil.remove(TRUCK_LIST);
        show();
    }

    @Override
    public void inIt() {
        TRUCK_LIST.add(new Truck("456789", "HYUNDAI", "1999", "Hue", 30));
    }

    @Override
    public void find() {
        MyUtil.find(TRUCK_LIST);
    }

    public Truck inputInfoTruck() {
        double tonnage;
        MyUtil.inputInfo();
        System.out.println("Trọng tải: ");
        tonnage = Double.parseDouble(SC.nextLine());
        return new Truck(MyUtil.licensePlates, MyUtil.manufacture, MyUtil.yearOfManufacture, MyUtil.owner, tonnage);
    }
}
