package com.codegym.service;

import com.codegym.model.Product;

import java.util.*;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product("Addidas AlphaBoost",3500000,"ok"));
        products.put(2, new Product("Addidas AlphaEdge4D",7500000,"ok"));
        products.put(3, new Product("Addidas Solar Drive",2900000,"ok"));
        products.put(4, new Product("Addidas SenseBoost Go",3200000,"ok"));
        products.put(5, new Product("Addidas Solar Boost",3800000,"ok"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void add(Product product) {
        products.put(product.getCount(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void edit(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void delete(int id) {
        products.remove(id);
    }

    @Override
    public Product findByName(String name) {
        Set<Map.Entry<Integer, Product>> entrySet = products.entrySet();
        for (Map.Entry<Integer, Product> entry: entrySet) {
            if(entry.getValue().getName().equals(name)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
