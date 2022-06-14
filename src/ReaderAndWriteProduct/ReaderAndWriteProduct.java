package ReaderAndWriteProduct;
import java.io.*;
import Classs.Product;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderAndWriteProduct {
    File file = new File("QLSP.csv");
    public  void Write(List<Product> Products) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Product s : Products) {
                bufferedWriter.write(s.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Product> reader() {
        ArrayList<Product> Products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str =  bufferedReader.readLine();
            while (str != null) {
                String[] arr = str.split(",");
                String idProduct = arr[0];
                String nameProduct = arr[1];
                double price = Double.parseDouble(arr[2]);
                int total = Integer.parseInt(arr[3]);
                String description = arr[4];
                Products.add(new Product(idProduct,nameProduct,price,total,description));
                str=bufferedReader.readLine();
            }
            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("");
        } catch (IOException e) {
            System.out.println("");
        }
        return Products;
    }
}
