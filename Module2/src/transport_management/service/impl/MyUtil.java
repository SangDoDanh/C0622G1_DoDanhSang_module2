package transport_management.service.impl;


import transport_management.model.Transport;

import java.util.List;
import java.util.Scanner;

public class MyUtil {
    public static final Scanner SC = new Scanner(System.in);
    public static String licensePlates;// biển số xe
    public static String manufacture;// hãng sản xuất
    public static String yearOfManufacture;//năm sản xuất
    public static String owner;// chủ sở hữu

    /**
     * Nhập thông tin cho transport
     */
    public static void inputInfo() {
        System.out.println("Vui lòng nhập các thông tin sau cho xe: ");
        System.out.print("Biển kiểm soát: \n");
        licensePlates = SC.nextLine();
        System.out.println("Hãng sản xuất: ");
        manufacture = SC.nextLine();
        System.out.println("Năm sản xuất");
        yearOfManufacture = SC.nextLine();
        System.out.println("Chủ sở hữu");
        owner = SC.nextLine();
    }

    /**
     * tìm kiếm Transport trong danh sách đối Transport nếu có trả về vị trí dầu tiên tìm thấy
     * @param list danh sách Transport
     * @param licensePlates biển số Transport cần tìm
     * @return vị trí Transport
     */
    public static int indexOf(List<Transport> list, String licensePlates) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getLicensePlates().equals(licensePlates)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * tìm kiếm xe trong danh sách xe, nếu tìm thấy sẽ hiển thị xe đó ra
     * tìm xe dựa trên biển số xe
     * @param list danh sách xe
     */
    public static void find(List<Transport> list) {
        String licensePlates;
        int indexTransoprt;
        System.out.print("Nhập biển số xe cần tìm:");
        licensePlates = SC.nextLine();
        indexTransoprt = indexOf(list, licensePlates);
        if(indexTransoprt > -1) {
            System.out.println(list.get(indexTransoprt));
        } else {
            System.out.println("Khong tim thấy xe!");
        }
    }

    /**
     * xóa một xe trong danh sách xe, sẽ xóa xe khi được xác nhận xóa
     * @param list danh sách xe
     */
    public static void remove(List<Transport> list) {
        String licensePlates;
        System.out.print("Nhập biển số xe ô tô muốn xóa: \n");
        licensePlates = SC.nextLine();
        int indexRemove;
        indexRemove = indexOf(list, licensePlates);
        if (indexRemove > -1) {
            boolean isConfirm = confirmRemove(licensePlates);
            if (isConfirm) {
                list.remove(indexRemove);
                System.out.println("Xóa xe thành công");
            }
        } else {
            System.out.println("Không tìm thấy xe nào !");
        }
    }

    /**
     * hiển thị tất cả xe có trong danh sách xe
     * @param list danh sách xe
     */
    public static void display(List<Transport> list) {
        if(list.size() > 0) {
            for (Transport transport : list) {
                System.out.println(transport);
            }
        } else {
            System.out.println("Không có gì!");
        }

    }

    /**
     * Xác nhận có chắc xóa xe hay không?
     * @param licensePlates biển số xe
     * @return xác nhận xóa xe
     */
    private static boolean confirmRemove(String licensePlates) {
        int chooseRemove;
        System.out.printf("Bạn muốn xóa xe ô tô có biển số: %s\n", licensePlates);
        System.out.println("1. Xóa\t2.Hủy");
        chooseRemove = Integer.parseInt(SC.nextLine());
        return chooseRemove == 1;
    }
}
