package service.impl;

import bean.Product;
import service.ProductService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;


    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "Sony xz1", "12000", "11"));
        products.put(2, new Product(2, "Iphone 11", "10000", "100"));
        products.put(3, new Product(3, "Samsung A32", "11000", "25"));
        products.put(4, new Product(4, "Oppo A11", "15000", "30"));
        products.put(5, new Product(5, "Xiaomi 11", "8000", "40"));
        products.put(6, new Product(6, "Vsmart 1", "20000", "80"));
    }
    @Override
    public List<Product> findAll() {

        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(),product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
