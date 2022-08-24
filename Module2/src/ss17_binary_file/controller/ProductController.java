package ss17_binary_file.controller;

import ss17_binary_file.service.IProductService;
import ss17_binary_file.service.impl.ProductService;

import java.util.Scanner;

public class ProductController {
    private static final Scanner SC = new Scanner(System.in);
    private static final IProductService I_PRODUCT_SERVICE = new ProductService();

    public void start() {
        int choose;
        while (true) {
            showMainMenu();
            choose = Integer.parseInt(SC.nextLine());
            switch (choose) {
                case 1:
                    I_PRODUCT_SERVICE.add();
                    break;
                case 2:
                    I_PRODUCT_SERVICE.display();
                    break;
                case 3:
                    I_PRODUCT_SERVICE.findByName();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("please enter choose 1...4");
                    break;
            }
        }
    }

    private void showMainMenu() {
        System.out.println("1. Add product");
        System.out.println("2. Display product list");
        System.out.println("3. Find by name");
        System.out.println("4. exit");
    }
}
