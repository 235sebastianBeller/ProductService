package com.example.product.controller;

import com.example.product.model.ProductDto;
import com.example.product.model.UpdateProductDto;
import com.example.product.service.AllProductService;
import com.example.product.service.CreateProductService;
import com.example.product.service.GetProductService;
import com.example.product.service.UpdateProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    AllProductService allProductService;
    CreateProductService createProductService;
    UpdateProductService updateProductService;
    GetProductService getProductService;

    ProductController(AllProductService allProductService,
                      CreateProductService createProductService,
                      UpdateProductService updateProductService,
                      GetProductService getProductService){
        this.allProductService = allProductService;
        this.createProductService = createProductService;
        this.updateProductService=updateProductService;
        this.getProductService=getProductService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(
                createProductService.execute(productDto)
        );
    }
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> obtain(@PathVariable Integer id) {
        return this.getProductService.execute(id);

    }
    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }
    @PutMapping
    public ResponseEntity<String> update() {
        return ResponseEntity.status(HttpStatus.OK).body("Updated");

    }
    @PutMapping("{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Integer id,
                                             @RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.updateProductService.execute(new UpdateProductDto(id,
                        productDto))
        );

    }
    @GetMapping("all")
    public ResponseEntity<List<ProductDto>> index() {
        return this.allProductService.execute(null);
    }


}
