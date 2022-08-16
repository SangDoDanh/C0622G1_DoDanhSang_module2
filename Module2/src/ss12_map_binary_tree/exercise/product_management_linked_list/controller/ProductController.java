package ss12_map_binary_tree.exercise.product_management_linked_list.controller;

import ss12_map_binary_tree.exercise.product_management_linked_list.service.IProductService;
import ss12_map_binary_tree.exercise.product_management_linked_list.service.iplm.ProductService;

import java.util.Scanner;

public class ProductController {
    private static final Scanner sc = new Scanner(System.in);
    public static final IProductService I_PRODUCT_SERVICE = new ProductService();
    private static final int FUNCTION_1 = 1;
    private static final int FUNCTION_2 = 2;
    private static final int FUNCTION_3 = 3;
    private static final int FUNCTION_4 = 4;
    private static final int FUNCTION_5 = 5;
    private static final int FUNCTION_6 = 6;
    private static final int FUNCTION_7 = 7;
    public void start() {
        int choose;
        I_PRODUCT_SERVICE.inIt();
        while (true) {
            mainMenu();
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case FUNCTION_1 :
                    I_PRODUCT_SERVICE.add();
                    break;
                case FUNCTION_2 :
                    I_PRODUCT_SERVICE.edit();
                    break;
                case FUNCTION_3 :
                    I_PRODUCT_SERVICE.remove();
                    break;
                case FUNCTION_4 :
                    I_PRODUCT_SERVICE.display();
                    break;
                case FUNCTION_5 :
                    I_PRODUCT_SERVICE.findProductByName();
                    break;
                case FUNCTION_6 :
                    I_PRODUCT_SERVICE.sortByPrice();
                    break;
                case FUNCTION_7 :
                    return;
            }
        }
    }
    private void mainMenu() {
        System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM---");
        System.out.println("1. Thêm một sản phẩm");
        System.out.println("2. Sửa thông tin sản phẩm theo id");
        System.out.println("3. Xoá sản phẩm theo id");
        System.out.println("4. Hiển thị danh sách sản phẩm");
        System.out.println("5. Tìm kiếm sản phẩm theo tên");
        System.out.println("6. Sắp xếp sản phẩm tăng dần, giảm dần");
        System.out.println("7. Thoát");
        System.out.print("Chọn chức năng: ");
    }
}
