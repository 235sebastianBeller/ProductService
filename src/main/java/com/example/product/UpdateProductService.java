package com.example.product;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class UpdateProductService implements Command<UpdateProductDto,
        ProductDto> {
    private final IProductRepository iProductRepository;

    UpdateProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }
    @Override
    public ProductDto execute(UpdateProductDto input) {
        Optional<Product> product =
                iProductRepository.findById(input.getId());
        if (product.isPresent()) {
            product.get().setDescription(input.getProductDto().getDescription());
            product.get().setName(input.getProductDto().getName());
            return new ProductDto(iProductRepository.save(product.get()));
        }
        return null;
    }


}
