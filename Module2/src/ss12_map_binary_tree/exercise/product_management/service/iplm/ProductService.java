package ss12_map_binary_tree.exercise.product_management.service.iplm;

import ss12_map_binary_tree.exercise.product_management.model.Product;
import ss12_map_binary_tree.exercise.product_management.service.IProductService;

import java.util.*;

public class ProductService implements IProductService {
    public static List<Product> productList = new ArrayList<>();
    private final static Scanner sc = new Scanner(System.in);
    @Override
    public void add() {
        Product productNew = createProduct("Nhập các thông tin sau cho sản phẩm mới: ");
        productList.add(productNew);
        System.out.println("Thêm mới thành công!");
        display();
    }

    @Override
    public void display() {
        if (productList.size() < 1) {
            System.out.println("Danh sách trống!");
        } else {
            showProducts(productList);
        }
    }
    private void showProducts(List<Product> products) {
        String displayFormat = String.format("|%-10s|%-15s|%20.5s|", "ID", "Name", "Price");
        System.out.println(displayFormat);
        for (Product product : products) {
            System.out.println(product);
        }
    }
    public void inIt() {
        productList.add(new Product(1, "Product_1", 100));
        productList.add(new Product(2, "Product_1", 200));
        productList.add(new Product(3, "Product_1", 300));
    }

    @Override
    public void edit() {
        int findProduct;
        findProduct = findProductByID();
        if(findProduct > -1) {
            Product productUpdate = createProduct("Nhập các thông tin cần chỉnh sửa: ");
            productList.get(findProduct).setId(productUpdate.getId());
            productList.get(findProduct).setName(productUpdate.getName());
            productList.get(findProduct).setName(productUpdate.getName());
            System.out.println("Cập nhật thành công!");
            display();
        }
    }

    @Override
    public void remove() {
        if(productList.size() > 0) {
            int findProduct;
            findProduct = findProductByID();
            if(findProduct > -1) {
                productList.remove(findProduct);
                System.out.println("Xóa thành công!");
                display();
            } else {
                System.out.println("Không tìm thấy !");
            }
        } else {
            System.out.println("Danh sách trống!");
        }
    }

    @Override
    public void findProductByName() {
        String name;
        String productName;
        List<Product> productFindByName = new ArrayList<>();

        System.out.print("Nhập id của sản phẩm cần tìm: ");
        name = sc.nextLine();
        name = name.toLowerCase();
        for (Product product : productList) {
            productName = product.getName().toLowerCase();
            if (productName.contains(name)) {
                productFindByName.add(product);
            }
        }

        if(productFindByName.size() > 0) {
            System.out.printf("Với name = '%s', tìm thấy các sản phẩn sau\n", name);
            showProducts(productFindByName);
        } else {
            System.out.println("Không tìm thấy !");
        }
    }

    @Override
    public void sortByPrice() {
        System.out.println("Danh sách sản phẩm tăng dần theo giá");
        sortAscendByPrice(productList);
        showProducts(productList);

        System.out.println("Danh sách sản phẩm giảm dần theo giá");
        sortDecreaseByPrice(productList);
        showProducts(productList);

    }

    private void sortDecreaseByPrice(List<Product> products) {
        products.sort((o1, o2) -> {
            if (o1.getPrice() > o2.getPrice()) {
                return -1;
            } else if (o1.getPrice() < o2.getPrice()) {
                return 1;
            }
            return 0;
        });
    }

    private void sortAscendByPrice(List<Product> products) {
        products.sort((o1, o2) -> {
            if (o1.getPrice() > o2.getPrice()) {
                return 1;
            } else if (o1.getPrice() < o2.getPrice()) {
                return -1;
            }
            return 0;
        });
    }


    private int findProductByID() {
        int id;
        System.out.print("Nhập id của sản phẩm cần tìm: ");
        id = Integer.parseInt(sc.nextLine());

        for(int i = 0; i < productList.size(); i++) {
            if(productList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private Product createProduct(String msg) {
        String name;
        int id;
        double price;
        System.out.println(msg);
        System.out.print("Name: ");
        name = sc.nextLine();
        System.out.print("Id: ");
        id = Integer.parseInt(sc.nextLine());
        System.out.println("Price: 1");
        price = Double.parseDouble(sc.nextLine());
        return new Product(id, name, price);
    }

}
