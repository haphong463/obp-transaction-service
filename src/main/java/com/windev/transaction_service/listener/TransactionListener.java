package com.windev.transaction_service.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.windev.transaction_service.event.CreateTransactionEvent;
import com.windev.transaction_service.service.TransactionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TransactionListener {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private TransactionService transactionService;

    @KafkaListener(topics = "createTransaction", groupId = "${spring.kafka.consumer.group-id}")
    public void handleEvent(@Payload String event) {
        try {
            CreateTransactionEvent data = objectMapper.readValue(event, CreateTransactionEvent.class);
            transactionService.createTransaction(data);
            log.info("Decode data: {}", data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        log.info("Received event: {}", event);
    }
}
