package com.windev.transaction_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.windev.transaction_service.entity.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, String> {

}
