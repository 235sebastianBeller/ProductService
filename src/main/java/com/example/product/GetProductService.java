package com.example.product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
@Service
public class GetProductService implements Query<Integer, ProductDto> {
    private final IProductRepository iProductRepository;
    public GetProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }
    @Override
    public  ResponseEntity<ProductDto> execute(Integer id) {
        Optional<Product> product = this.iProductRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    product.map(ProductDto::new).get()
            );
        }
        throw new ProductNotFoundException();
    }
}