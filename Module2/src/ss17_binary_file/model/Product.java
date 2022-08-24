package ss17_binary_file.model;

import java.io.Serializable;

public class Product implements Serializable {
    private String id;
    private String name;
    private String produce;
    private double price;

    public Product() {
    }

    public Product(String id, String name, String produce, double price) {
        this.id = id;
        this.name = name;
        this.produce = produce;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", produce='" + produce + '\'' +
                ", price=" + price +
                '}';
    }
}
