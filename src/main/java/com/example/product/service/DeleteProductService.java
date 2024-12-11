package com.example.product.service;

import com.example.product.Command;
import com.example.product.IProductRepository;
import com.example.product.exception.ProductNotFoundException;
import com.example.product.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductService implements Command<Integer, Boolean> {

    private final IProductRepository iProductRepository;


    public DeleteProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }


    @Override
    public ResponseEntity<Boolean> execute(Integer input) {
        Optional<Product> product = iProductRepository.findById(input);
        if(product.isPresent()) {
            iProductRepository.deleteById(product.get().getId());
            return ResponseEntity.ok(true);
        }
        throw new ProductNotFoundException();
    }
}
