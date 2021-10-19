package com.can.springbootcassandra.service.Impl;


import com.can.springbootcassandra.model.Product;
import com.can.springbootcassandra.repository.ProductQueryRepository;
import com.can.springbootcassandra.service.ProductQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductQueryServiceImpl implements ProductQueryService {

    private final ProductQueryRepository productQueryRepository;


    @Override
    public List<Product> getProductByName(String name) {
        return productQueryRepository.getProductByName(name);
    }

    @Override
    public Product getOneProductByName(String name) {
        return productQueryRepository.getOneProductByName(name);
    }

    @Override
    public List<Product> getProductByUnitInStock(Integer unitInStock) {
        return productQueryRepository.getProductByUnitInStock(unitInStock);
    }

    @Override
    public List<Product> getProductByUnitPriceGreaterThan(int unitPrice) {
        return productQueryRepository.getProductByUnitPriceGreaterThan(unitPrice);
    }
}
