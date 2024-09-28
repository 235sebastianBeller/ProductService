package com.example.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllProductService implements Query<Void, List<ProductDto>>{
    private final IProductRepository iproductRepository;


    public AllProductService(IProductRepository iproductRepository) {
        this.iproductRepository = iproductRepository;
    }

    @Override
    public ResponseEntity<List<ProductDto>> execute(Void input){
        List<Product> products = iproductRepository.findAll();
        return  ResponseEntity.status(HttpStatus.OK).body(
                products.stream().map(ProductDto::new).toList()
        );
    }

}
