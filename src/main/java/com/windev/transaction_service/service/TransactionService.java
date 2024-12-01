package com.windev.transaction_service.service;

import com.windev.transaction_service.entity.Transaction;
import com.windev.transaction_service.event.CreateTransactionEvent;

public interface TransactionService {
    Transaction createTransaction(CreateTransactionEvent transactionEvent);
}
