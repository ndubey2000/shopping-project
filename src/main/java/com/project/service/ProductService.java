package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Product;
import com.project.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product getProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

	public List<Product> getAllProducts() {
		return productRepository.findAll();
		
	}

    // Other product-related methods
}
