package com.project.model;

import lombok.Data;

@Data
public class TransactionRequestDto {
    private Long orderId;
    private String transactionId;
    private String status;

}
