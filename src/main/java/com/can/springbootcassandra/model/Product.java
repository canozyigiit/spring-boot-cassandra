package com.can.springbootcassandra.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("products")
public class Product {

    @PrimaryKey
    private Integer productId;
    @Size(min = 2,max = 15)
    @NotEmpty
    private String productName;
    @Size(min = 2,max = 15)
    @NotEmpty
    private String description;
    @Positive
    @NotNull
    private Integer unitPrice;
    @Positive
    @NotNull
    private Integer unitInStock;
}
