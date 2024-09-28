package com.example.product.exception;

public enum ErrorMessages {
    PRODUCT_NOT_FOUND("Product Not Found"),
    PRODUCT_BAD_REQUEST_NAME_IS_REQUIRED("Name is required"),
    PRODUCT_BAD_REQUEST_DESC_IS_REQUIRED("Description is required");

    private final String message;
    ErrorMessages(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

}
