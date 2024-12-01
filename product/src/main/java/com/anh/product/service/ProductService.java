package com.anh.product.service;

import com.anh.product.model.Product;
import com.anh.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product, long id) {
        Optional<Product> prod = productRepository.findById(id);
        if (prod.isPresent()) {
            return productRepository.save(product);
        } else {
            return null;
        }
    }

    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
