package com.example.product.validator;


import com.example.product.exception.ErrorMessages;
import com.example.product.exception.ProductBadRequestException;
import com.example.product.model.Product;
import io.micrometer.common.util.StringUtils;

public class ProductValidator {
    public static  void validateNameProduct(Product product){
        if(StringUtils.isEmpty(product.getName()) || StringUtils.isBlank(product.getName())){
            throw new ProductBadRequestException(
                    ErrorMessages.PRODUCT_BAD_REQUEST_NAME_IS_REQUIRED.getMessage()
            );
        }
    }
    public static  void validateDescProduct(Product product){
        if(StringUtils.isBlank(product.getDescription()) || StringUtils.isEmpty(product.getDescription())){
            throw new ProductBadRequestException(
                    ErrorMessages.PRODUCT_BAD_REQUEST_DESC_IS_REQUIRED.getMessage()
            );
        }
    }
    public  static void validateProduct(Product product){
        validateNameProduct(product);
        validateDescProduct(product);
    }

}
