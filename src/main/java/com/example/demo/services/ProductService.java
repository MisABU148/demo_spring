package com.example.demo.services;

import com.example.demo.modules.Product;
import com.example.demo.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> listProducts(String title) {
        if (title != null) return productRepository.findByTitle(title);
        return productRepository.findAll(); }

    public void saveProduct(Product product) {
        log.info("Saving new prod");
        productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        log.info("deliting product");
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
