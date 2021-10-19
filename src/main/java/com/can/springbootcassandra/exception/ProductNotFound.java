package com.can.springbootcassandra.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
@Getter
public class ProductNotFound extends RuntimeException{
    private final String message = "Product not found!";
}