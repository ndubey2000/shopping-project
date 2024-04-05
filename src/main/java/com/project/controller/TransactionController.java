package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Transaction;
import com.project.model.TransactionRequestDto;
import com.project.service.TransactionService;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/{orderId}")
    public ResponseEntity<Transaction> createTransaction(@PathVariable Long orderId, @RequestBody TransactionRequestDto transactionRequest) {
        Transaction transaction = transactionService.createTransaction(orderId, transactionRequest);
        if (transaction == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(transaction);
    }

}
