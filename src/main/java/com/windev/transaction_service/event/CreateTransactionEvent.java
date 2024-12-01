package com.windev.transaction_service.event;

import java.math.BigDecimal;

import com.windev.transaction_service.dto.AccountDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTransactionEvent {
    private AccountDTO account;
    private BigDecimal amount;
    private String type;
}
