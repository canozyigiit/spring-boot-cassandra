package com.can.springbootcassandra.service;

import com.can.springbootcassandra.model.Product;

import java.util.List;

public interface ProductQueryService {

    List<Product> getProductByName(String name);
    Product getOneProductByName(String name);
    List<Product> getProductByUnitInStock(Integer unitInStock);
    List<Product> getProductByUnitPriceGreaterThan(int unitPrice);
}
