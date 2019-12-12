package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void add(Product product);

    Product findById(int id);

    void edit(int id, Product product);

    void delete(int id);

    Product findByName(String name);
}
