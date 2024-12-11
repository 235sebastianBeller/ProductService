package com.example.product;

import com.example.product.model.ErrorResponse;
import com.example.product.model.ProductDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Products", description = "API for managing products")
public interface ProductApi {

    /**
     * Get a list of all products.
     *
     * @return List of ProductDto objects.
     */
    @Operation(summary = "List all products", description = "Retrieve a list of all available products.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the list of products",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDto.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/products")
    ResponseEntity<List<ProductDto>> index();

    /**
     * Get a product by its ID.
     *
     * @param id ID of the product.
     * @return The requested ProductDto object.
     */
    @Operation(summary = "Get a product by ID", description = "Retrieve a product by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved the product",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDto.class))),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)))
    })
    @GetMapping("/products/{id}")
    ResponseEntity<ProductDto> obtain(@PathVariable Integer id);

    /**
     * Create a new product.
     *
     * @param product Product data to create.
     * @return A message indicating successful creation.
     */
    @Operation(summary = "Create a new product", description = "Create a new product with the given details.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Product successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PostMapping("/products")
    ResponseEntity<String> create(@RequestBody ProductDto product);

    /**
     * Update an existing product.
     *
     * @param id      ID of the product to update.
     * @param product Updated product data.
     * @return The updated ProductDto object.
     */
    @Operation(summary = "Update a product", description = "Update an existing product by its ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully updated",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProductDto.class))),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)))
    })
    @PutMapping("/products/{id}")
    ResponseEntity<ProductDto> update(@PathVariable Integer id, @RequestBody ProductDto product);

    /**
     * Delete a product by its ID.
     *
     * @param id ID of the product to delete.
     * @return A boolean indicating whether the deletion was successful.
     */
    @Operation(summary = "Delete a product", description = "Delete a product by its unique ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Product successfully deleted"),
            @ApiResponse(responseCode = "404", description = "Product not found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ErrorResponse.class)))
    })
    @DeleteMapping("/products/{id}")
    ResponseEntity<Boolean> delete(@PathVariable Integer id);
}
