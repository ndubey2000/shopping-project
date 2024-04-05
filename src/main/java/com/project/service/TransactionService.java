package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.model.Transaction;
import com.project.model.TransactionRequestDto;
import com.project.repositories.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private OrderService orderService;

    public Transaction createTransaction(Long orderId, TransactionRequestDto transactionRequest) {
		Transaction transaction = new Transaction();
		transaction.setOrder(orderService.getOrder(orderId));
		transaction.setStatus(transactionRequest.getStatus());
		transaction.setTransactionId(transactionRequest.getTransactionId());
		return transactionRepository.save(transaction);
    }
}
