package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Add custom query methods if needed
}
