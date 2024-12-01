package com.anh.product.controller;

import com.anh.product.model.Product;
import com.anh.product.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @GetMapping("/{id}")
    @Operation(tags = "Product", summary = "Find product by ID")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Optional<Product> product = productService.getProductById(id);
        return product.isEmpty() ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : new ResponseEntity<>(product.get(), HttpStatus.OK);
    }

    @GetMapping
    @Operation(tags = "Product", summary = "Find all product")
    public ResponseEntity<List<Product>> getAllProduct() {
        List<Product> products = productService.getAllProducts();
        return products.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping("/create")
    @Operation(tags = "Product", summary = "Create product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }
}
