package CreatProduct;

import Classs.Product;
import ReaderAndWriteProduct.ReaderAndWriteProduct;
import Validate.ValidateProduct;
import SortByPrice.SortByPrice;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Creat {
    List<Product> products = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    ValidateProduct validateProduct = new ValidateProduct();
    ReaderAndWriteProduct readerAndWriteProduct = new ReaderAndWriteProduct();

    public void menu(){
        System.out.println("------ CHƯƠNG TRÌNH QUẢN LÝ SẢN PHẨM ------ ");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Tìm sản phấm có giá đắt nhất");
        System.out.println("7. Đọc từ file");
        System.out.println("8. Ghi vào File");
        System.out.println("9. Thoát");
        switch (Integer.parseInt(scanner.nextLine())){
            case 1:
                showProduct();
                break;
            case 2:
                addProduct(createProduct());
                break;
            case 3:
                updateProduct();
                break;
            case 4:
                removeProduct();
                break;
            case 5:
                sortPriceAscending();
                break;
            case 6:
                showMaxPrice();
                break;
            case 7:
                products= readerAndWriteProduct.reader();
                break;
            case 8:
                readerAndWriteProduct.Write(products);
                System.out.println("Ghi thành công");
                break;
            case 9:
                System.exit(0);
                break;
            default:
                System.out.println("Nhập sai , mời nhập lại đẻ chạy chương trình");
        }
    }

    public void showProduct(){
        for (Product s: products) {
            System.out.println(s);
        }
    }

    public Product createProduct(){
        String idProduct = validateProduct.validateString("id sản phẩm: ");
        String nameProduct = validateProduct.validateString("tên sản phẩm: ");
        Double price = validateProduct.validatePrice();
        int total = validateProduct.validateTotal();
        String description = validateProduct.validateString("mô tả sản phẩm: ");
        return new Product(idProduct, nameProduct, price, total,description);
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void updateProduct(){
        System.out.println("Nhập id sản phẩm cần sửa");
        String idPoduct = scanner.nextLine();
        int index = validateProduct.getIndexID(idPoduct, products);
        if (index != -1){
            products.set(index, createProduct());
        }else {
            System.out.println("Mã sản phẩm không tồn tại");
        }
    }

    public void removeProduct(){
        System.out.println("Nhập id sản phẩm cần xóa");
        String idProduct = scanner.nextLine();
        int index = validateProduct.getIndexID(idProduct, products);

        System.out.println("Bạn có thật sự muốn xóa \"y\"");
        String confirm = scanner.nextLine();

        if (confirm.equals("y")) {
            if (index != -1) {
                products.remove(index);
            } else {
                System.out.println("Không tìm được sản phẩm với mã sản phẩm trên");
            }
        }else {
            menu();
        }
    }

    public void sortPriceAscending(){
        System.out.println("Danh sách sản phẩm theo giá tăng dần");
        products.sort(new SortByPrice());
        for (Product s: products
        ) {
            System.out.println(s.toString());
        }
    }

    public void showMaxPrice(){
        products.sort(new SortByPrice());
        System.out.println(products.get(products.size()-1).toString());
    }
}
