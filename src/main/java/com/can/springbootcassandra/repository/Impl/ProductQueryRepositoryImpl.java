package com.can.springbootcassandra.repository.Impl;

import com.can.springbootcassandra.model.Product;
import com.can.springbootcassandra.repository.ProductQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ProductQueryRepositoryImpl implements ProductQueryRepository {

    @Autowired
    private CassandraOperations cassandraTemplate;



    @Override
    public List<Product> getProductByName(String productName) {
        return cassandraTemplate.select(Query.query(Criteria.where("productName").is(productName)).withAllowFiltering(), Product.class);
    }

    @Override
    public Product getOneProductByName(String productName) {
        return cassandraTemplate.selectOne(Query.query(Criteria.where("productName").is(productName)).withAllowFiltering(), Product.class);
    }

    @Override
    public List<Product> getProductByUnitInStock(Integer unitInStock) {
        return cassandraTemplate.select(Query.query(Criteria.where("unitInStock").is(unitInStock)).withAllowFiltering(), Product.class);
    }


    @Override
    public List<Product> getProductByUnitPriceGreaterThan(int unitPrice) {
        return cassandraTemplate.select(Query.query(Criteria.where("unitPrice").gt(unitPrice)).withAllowFiltering(), Product.class);
    }


}
