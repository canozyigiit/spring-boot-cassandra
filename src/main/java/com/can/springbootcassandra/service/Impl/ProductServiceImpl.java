package com.can.springbootcassandra.service.Impl;


import com.can.springbootcassandra.exception.ProductNotFound;
import com.can.springbootcassandra.model.Product;
import com.can.springbootcassandra.repository.ProductRepository;
import com.can.springbootcassandra.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(int productId) {
        return productRepository.findById(productId).orElseThrow(ProductNotFound::new);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(int productId, Product product) {
        Product oldProduct = productRepository.findById(productId).orElseThrow(ProductNotFound::new);
        oldProduct.setProductName(product.getProductName());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setUnitInStock(product.getUnitInStock());
        oldProduct.setUnitPrice(product.getUnitPrice());
        return productRepository.save(oldProduct);
    }

    @Override
    public void deleteProduct(int productId) {
        Product oldProduct = productRepository.findById(productId).orElseThrow(ProductNotFound::new);
        productRepository.delete(oldProduct);
    }
}
