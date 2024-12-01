package com.windev.transaction_service.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

import com.windev.transaction_service.enums.TransactionStatus;
import com.windev.transaction_service.enums.TransactionType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "transactions")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    private String id;

    @Column(unique = true)
    private String accountId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionStatus status;

    @Column(nullable = false)
    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @PrePersist
    public void onCreate() {
        id = UUID.randomUUID().toString();
        createdAt = new Date();
        updatedAt = new Date();
        status = TransactionStatus.PENDING;
    }

    @PreUpdate
    public void onUpdate() {
        updatedAt = new Date();
    }
}
