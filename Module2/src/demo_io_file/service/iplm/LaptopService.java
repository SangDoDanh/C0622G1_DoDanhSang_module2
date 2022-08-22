package demo_io_file.service.iplm;

import demo_io_file.model.Laptop;
import demo_io_file.service.ILaptopService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LaptopService implements ILaptopService {
    private List<Laptop> laptops = readFile();
    private static final Scanner SC = new Scanner(System.in);

    public LaptopService() {
    }

    @Override
    public void add() {
        Laptop laptop = createLaptop();
        laptops.add(laptop);
        writeFile();
    }

    @Override
    public void display() {
        for (Laptop laptop : laptops) {
            System.out.println(laptop);
        }
    }

    private void writeFile() {
        try {
            File file = new File("Module2/src/demo_io_file/service/data/laptop.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Laptop laptop : laptops) {
                bufferedWriter.write(laptop.toString());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<Laptop> readFile() {
        List<Laptop> result = new ArrayList<>();
        File laptopFiles = new File("Module2/src/demo_io_file/service/data/laptop.txt");
        try {
            FileReader fileReader = new FileReader(laptopFiles);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                Laptop laptop = new Laptop();
                String[] laptopString = line.split(",");
                laptop.setId(laptopString[0]);
                laptop.setName(laptopString[1]);
                laptop.setPrice(Double.parseDouble(laptopString[2]));
                result.add(laptop);
            }
            bufferedReader.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    private Laptop createLaptop() {
        System.out.println("Nhập các thông tin sau cho laptop mới:");
        System.out.println("Mã số: ");
        String id = SC.nextLine();
        System.out.println("Tên: ");
        String name = SC.nextLine();
        System.out.println("Giá: ");
        double price = Double.parseDouble(SC.nextLine());

        return new Laptop(id, name, price);
    }
}
