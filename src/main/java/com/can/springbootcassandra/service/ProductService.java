package com.can.springbootcassandra.service;

import com.can.springbootcassandra.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();
    Product getProductById(int productId);
    Product createProduct(Product product);
    Product updateProduct(int productId, Product product);
    void deleteProduct(int productId);
}
