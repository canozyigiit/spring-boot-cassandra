package com.can.springbootcassandra.api;


import com.can.springbootcassandra.model.Product;
import com.can.springbootcassandra.service.ProductQueryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product-query")
@Tag(name = "Product Query controller", description = "Get Product APIs using Queries")
public class ProductQueryController {

    @Autowired
    private ProductQueryService productQueryService;


    @Operation(summary = "Get all Products by name using query")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products list",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = Product.class)))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/name/{name}")
    public List<Product> getProductByName(@Parameter(description = "Product name to be fetched") @PathVariable String name) {
        return productQueryService.getProductByName(name);
    }


    @Operation(summary = "Get one Product by name using query")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get one Product by name",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = Product.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/one-by-name/{name}")
    public Product getOneProductByName(@Parameter(description = "Product name to be fetched") @PathVariable String name) {
        return productQueryService.getOneProductByName(name);
    }


    @Operation(summary = "Get all Products whose unitPrice greater than using query")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products list",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = Product.class)))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/unitPrice-greater-than/{unitPrice}")
    public List<Product> getProductByUnitPriceGreaterThan(@Parameter(description = "Products fetched whose UnitPrice greater than") @PathVariable int unitPrice) {
        return productQueryService.getProductByUnitPriceGreaterThan(unitPrice);
    }

    @Operation(summary = "Get all Products by unitInStock using query")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Products list",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = Product.class)))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/unitInStock/{unitInStock}")
    public List<Product> getProductByUnitInStock(@Parameter(description = "Product unitInStock to be fetched") @PathVariable int unitInStock) {
        return productQueryService.getProductByUnitInStock(unitInStock);
    }
}


