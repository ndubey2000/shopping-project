package com.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Add custom query methods if needed
}
