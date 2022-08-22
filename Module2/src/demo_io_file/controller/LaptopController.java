package demo_io_file.controller;

import demo_io_file.service.ILaptopService;
import demo_io_file.service.iplm.LaptopService;

public class LaptopController {
    private static final ILaptopService I_LAPTOP_SERVICE = new LaptopService();

    public void add() {
        I_LAPTOP_SERVICE.add();
    }

    public void display() {
        I_LAPTOP_SERVICE.display();
    }
}
