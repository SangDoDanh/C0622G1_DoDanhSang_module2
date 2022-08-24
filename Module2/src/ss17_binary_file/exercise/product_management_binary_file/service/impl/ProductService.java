package ss17_binary_file.exercise.product_management_binary_file.service.impl;

import ss17_binary_file.exercise.product_management_binary_file.model.Product;
import ss17_binary_file.exercise.product_management_binary_file.service.IProductService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static List<Product> productList;
    private static final Scanner SC = new Scanner(System.in);
    private final String PATH_PRODUCT = "Module2/src/ss17_binary_file/service/data/product.dat";

    /**
     * Tạo và thêm mới một sản phẩm vào danh sách
     */
    @Override
    public void add() {
        productList = readFileProduct(PATH_PRODUCT);
        Product product = createNewProduct();
        productList.add(product);
        System.out.println("Add success!");
        writeFileProduct(PATH_PRODUCT, productList);
    }

    @Override
    public void display() {
        productList = readFileProduct(PATH_PRODUCT);
       showInfo(productList);
    }
    /**
     * tìm kiếm sản phẩm trong danh sách sản phẩm theo tên sản phẩm
     * sản phẩm tìm thấy sẽ được hiển thị dưới dạnh sách sản phẩm
     * tìm thấy
     */
    @Override
    public void findByName() {
        String name;
        List<Product> productsFound = new ArrayList<>();
        productList = readFileProduct(PATH_PRODUCT);
        System.out.print("Enter product name: ");
        name = SC.nextLine();
        for(Product product : productList) {
            if(product.getName().contains(name)) {
                productsFound.add(product);
            }
        }
        showInfo(productsFound);
    }

    /**
     * Hiển thị sản phẩm có trong danh sách sản phẩm
     * @param products danh sách sản phẩm
     */
    private void showInfo(List<Product> products) {
        if(products.size() ==0) {
            System.out.println("Product list is empty!");
        } else {
            for(Product product : products) {
                System.out.println(product);
            }
        }
    }

    /**
     * ghi dữ liệu có trong danh sách sản phẩm vào file
     * @param path_product đường dẫn file
     * @param productList danh sách sản phẩn
     */
    private void writeFileProduct(String path_product, List<Product> productList) {
        try{
            FileOutputStream outputStream = new FileOutputStream(path_product);
            ObjectOutputStream oos = new ObjectOutputStream(outputStream);
            oos.writeObject(productList);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Đọc dữ liệu trong file Product
     * @param path_product đường dẫn file
     * @return danh sách sản phẩm
     */
    private List<Product> readFileProduct(String path_product) {
        List<Product> products = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(path_product);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            products = (List<Product>) objectInputStream.readObject();
            objectInputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    /**
     * Nhập thông tin cho Product
     * @return Product
     */
    private Product createNewProduct() {
        String id;
        String name;
        double price;
        String produce;
        System.out.print("Enter product id: ");
        id = SC.nextLine();
        System.out.print("Enter product name: ");
        name = SC.nextLine();
        System.out.print("Enter product produce: ");
        produce = SC.nextLine();
        System.out.print("Enter product price: ");
        price = Double.parseDouble(SC.nextLine());
        return  new Product(id, name, produce, price);
    }
}
