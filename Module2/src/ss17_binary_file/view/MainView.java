package ss17_binary_file.view;

import ss17_binary_file.controller.ProductController;

public class MainView {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        productController.start();
    }
}
