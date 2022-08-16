package ss12_map_binary_tree.exercise.product_management.view;

import ss12_map_binary_tree.exercise.product_management.controller.ProductController;
import ss12_map_binary_tree.exercise.product_management.model.Product;

public class ViewMain {
    public static void main(String[] args) {
        ProductController productCtr = new ProductController();
        productCtr.start();
    }
}
