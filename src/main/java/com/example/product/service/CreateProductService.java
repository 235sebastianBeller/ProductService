package com.example.product.service;

import com.example.product.Command;
import com.example.product.IProductRepository;
import com.example.product.ProductBadRequestException;
import com.example.product.model.Product;
import com.example.product.model.ProductDto;
import org.springframework.stereotype.Service;
import io.micrometer.common.util.StringUtils;

@Service
public class CreateProductService implements Command<ProductDto,String> {
    private final IProductRepository iProductRepository;
    public CreateProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Override
    public String execute(ProductDto input) {
        Product product = input.toProduct();
        if(StringUtils.isEmpty(product.getName())){
            throw new ProductBadRequestException();
        }
       int id= iProductRepository.save(product).getId();
       return String.format("Product with id %d created", id);
    }
}