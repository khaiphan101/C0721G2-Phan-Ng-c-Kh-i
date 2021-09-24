package _16_binary_file_and_serialization.exercise.manage_product_save_at_binary_file;

import java.io.EOFException;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        productManager.add();
        productManager.productsList.add(new Product(123, "N72", "Nokia", 1000));
        productManager.productsList.add(new Product(127, "A30", "Samsung", 30000));
        productManager.productsList.add(new Product(125, "11 pro", "Iphone", 40000));
        productManager.productsList.add(new Product(126, "Redmi note 8", "Xiaomi", 20000));
        productManager.productsList.add(new Product(124, "XZ2", "Sony", 500000));
        productManager.writeToFile("src\\_16_binary_file_and_serialization\\exercise\\manage_product_save_at_binary_file\\product_list_file", productManager.productsList);
        productManager.showList();
        productManager.search("Xiaomi");
    }
}

