package com.example.product;

import com.example.product.exception.ErrorMessages;

public class ProductBadRequestException extends RuntimeException{
    public ProductBadRequestException() {
        super(ErrorMessages.PRODUCT_BAD_REQUEST.getMessage());
    }
}

