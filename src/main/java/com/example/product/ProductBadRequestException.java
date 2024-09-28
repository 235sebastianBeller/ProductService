package com.example.product;

public class ProductBadRequestException extends RuntimeException{
    public ProductBadRequestException(String message) {
        super(message);
    }
}
