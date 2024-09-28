package com.example.product;

import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<ProductDto,String> {
    private final IProductRepository iProductRepository;
    public CreateProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }

    @Override
    public String excute(ProductDto input) {
        Product product = input.toProduct();
       int id= iProductRepository.save(product).getId();
       return String.format("Product with id %d created", id);
    }
}
