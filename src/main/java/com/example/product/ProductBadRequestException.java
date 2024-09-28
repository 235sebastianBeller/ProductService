package com.example.product;

public class ProductBadRequestException extends RuntimeException{
    public ProductBadRequestException() {
        super(ErrorMessages.PRODUCT_BAD_REQUEST.getMessage());
    }
}
