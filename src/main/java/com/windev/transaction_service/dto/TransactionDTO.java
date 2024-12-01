package com.windev.transaction_service.dto;

import java.math.BigDecimal;

import com.windev.transaction_service.enums.TransactionStatus;
import com.windev.transaction_service.enums.TransactionType;
import lombok.Data;

@Data
public class TransactionDTO {
    private String accountId;

    private TransactionType type;

    private TransactionStatus status;

    private BigDecimal amount;
}
