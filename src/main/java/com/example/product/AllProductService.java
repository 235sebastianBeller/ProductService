package com.example.product;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllProductService implements Query<Void, List<ProductDto>>{
    private final IProductRepository iproductRepository;


    public AllProductService(IProductRepository iproductRepository) {
        this.iproductRepository = iproductRepository;
    }

    @Override
    public List<ProductDto> execute(Void input){
        List<Product> products = iproductRepository.findAll();
        return products.stream().map(ProductDto::new).toList();
    }

}
