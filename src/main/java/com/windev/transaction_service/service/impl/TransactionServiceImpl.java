package com.windev.transaction_service.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.windev.transaction_service.dto.TransactionDTO;
import com.windev.transaction_service.entity.Transaction;
import com.windev.transaction_service.enums.TransactionType;
import com.windev.transaction_service.event.CreateTransactionEvent;
import com.windev.transaction_service.repository.TransactionRepository;
import com.windev.transaction_service.service.TransactionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public Transaction createTransaction(CreateTransactionEvent transactionEvent) {
        Transaction newTransaction = new Transaction();
        newTransaction.setAccountId(transactionEvent.getAccount().getId());
        newTransaction.setAmount(transactionEvent.getAmount());

        switch (transactionEvent.getType()) {
            case "DEPOSIT":
                newTransaction.setType(TransactionType.DEPOSIT);
                break;
            case "WITHDRAWAL":
                newTransaction.setType(TransactionType.WITHDRAWAL);
                break;
            case "TRANSFER":
                newTransaction.setType(TransactionType.TRANSFER);
                break;
            default:
                throw new RuntimeException("Error: Unknown transaction type");
        }

        Transaction savedTransaction = transactionRepository.save(newTransaction);
        return savedTransaction;
    }
}
