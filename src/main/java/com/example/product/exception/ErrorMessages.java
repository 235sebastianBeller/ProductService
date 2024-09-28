package com.example.product.exception;

public enum ErrorMessages {
    PRODUCT_NOT_FOUND("Product Not Found"),PRODUCT_BAD_REQUEST("Name is required");

    private final String message;
    ErrorMessages(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}
