package com.example.product;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class GetProductService implements Query<Integer, Product> {
    private final IProductRepository iProductRepository;
    public GetProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }
    @Override
    public Product execute(Integer id) {
        Optional<Product> product = this.iProductRepository.findById(id);
        return product.orElse(null);
    }
}