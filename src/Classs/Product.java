package Classs;

public class Product {
    private String idProduct ;
    private String nameProduct;
    private double price;
    private int total;
    private String description;

    public Product() {
    }

    public Product(String idProduct, String nameProduct, double price, int total, String description) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.total = total;
        this.description = description;
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct='" + idProduct + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                ", total=" + total +
                ", description='" + description + '\'' +
                '}';
    }

    public String write() {
        return idProduct + "," + nameProduct + "," + price + "," + total +  "," + description;
    }
}
