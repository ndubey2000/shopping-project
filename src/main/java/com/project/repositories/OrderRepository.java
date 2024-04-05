package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Add custom query methods if needed
}
