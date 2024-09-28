package com.example.product;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {
    private final int id;
    private final String name;
    private final String description;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
    }

    public Product toProduct(){
        var product = new Product();
        product.setId(id);
        product.setName(name);
        product.setDescription(description);
        return product;
    }
}
