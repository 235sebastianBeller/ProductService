package com.example.product.controller;

import com.example.product.ProductApi;
import com.example.product.config.ObserveService;
import com.example.product.model.ProductDto;
import com.example.product.model.UpdateProductDto;
import com.example.product.service.*;
import io.micrometer.observation.annotation.Observed;
import io.micrometer.tracing.Span;
import io.micrometer.tracing.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/greet")
public class ProductController implements ProductApi {
    AllProductService allProductService;
    CreateProductService createProductService;
    UpdateProductService updateProductService;
    GetProductService getProductService;
    DeleteProductService deleteProductService;
    private final Tracer tracer;

    ProductController(AllProductService allProductService,
                      CreateProductService createProductService,
                      UpdateProductService updateProductService,
                      GetProductService getProductService,DeleteProductService deleteProductService,
                      Tracer tracer
    ){
        this.allProductService = allProductService;
        this.createProductService = createProductService;
        this.updateProductService=updateProductService;
        this.getProductService=getProductService;
        this.deleteProductService=deleteProductService;
        this.tracer=tracer;

    }

    private static final Logger log = LoggerFactory.getLogger(ProductController.class);

    @PostMapping
    public ResponseEntity<String> create(@RequestBody ProductDto productDto) {
        return this.createProductService.execute(productDto);
    }
    @GetMapping("{id}")
    public ResponseEntity<ProductDto> obtain(@PathVariable Integer id) {
        return this.getProductService.execute(id);

    }
    @PutMapping("{id}")
    public ResponseEntity<ProductDto> update(@PathVariable Integer id,
                                             @RequestBody ProductDto productDto) {
        return this.updateProductService.execute(new UpdateProductDto(id,
                productDto));

    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Integer id) {
        return this.deleteProductService.execute(id);
    }

    @Observed(name = "index.method", contextualName = "index-request", lowCardinalityKeyValues = {"controller", "ProductController"})
    @GetMapping("all")
    public ResponseEntity<List<ProductDto>> index() {
        Span currentSpan = tracer.currentSpan();
        ResponseEntity<List<ProductDto>> response=this.allProductService.execute(null);
        if (currentSpan != null) {
            currentSpan.tag("http.request", "/all");
            currentSpan.tag("http.response", response.toString());
        }
        return response;
    }


}
