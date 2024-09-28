package com.example.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    AllProductService allProductService;
    CreateProductService createProductService;

    ProductController(AllProductService allProductService, CreateProductService createProductService){
        this.allProductService = allProductService;
        this.createProductService = createProductService;
    }

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(createProductService.excute(productDto));
    }
    @GetMapping
    public ResponseEntity<String> obtain() {
        return ResponseEntity.status(HttpStatus.OK).body("The product");

    }
    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted");
    }
    @PutMapping
    public ResponseEntity<String> update() {
        return ResponseEntity.status(HttpStatus.OK).body("Updated");

    }
    @GetMapping("all")
    public ResponseEntity<List<ProductDto>> index() {
        return ResponseEntity.status(HttpStatus.OK).body(
                this.allProductService.execute(null)
        );
    }


}
