package com.can.springbootcassandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@SpringBootApplication
@EnableCassandraRepositories

public class SpringBootCassandraApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootCassandraApplication.class, args);
    }

}
