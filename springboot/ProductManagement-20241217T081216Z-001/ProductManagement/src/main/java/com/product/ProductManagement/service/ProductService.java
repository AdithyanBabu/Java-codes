package com.product.ProductManagement.service;

import com.product.ProductManagement.model.Product;
import com.product.ProductManagement.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private static final Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> searchProductsByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    public void saveProduct(Product product) {
        logger.info("Saving product: {}", product);
        productRepository.save(product);
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }
}
