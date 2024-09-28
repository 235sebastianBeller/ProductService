package com.example.product;
import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class UpdateProductDto {
    private final Integer id;
    private ProductDto productDto;
}