package com.can.springbootcassandra.repository;

import com.can.springbootcassandra.model.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRepository extends CassandraRepository<Product,Integer> {
}
