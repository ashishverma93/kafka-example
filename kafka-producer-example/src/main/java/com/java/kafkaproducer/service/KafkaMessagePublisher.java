package com.java.kafkaproducer.service;

import com.java.kafkaproducer.dto.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisher {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, Object>> future = template.send("quickstart2", message);
        future.whenComplete((result, e) -> {
            if (e == null) {
                System.out.println("Send result getRecordMetadata offset: " + result.getRecordMetadata().offset());
            } else {
                System.out.println("Unable to send message " + message + " due to " + e.getMessage());
            }
        });
    }

    public void sendEventsToTopic(Customer customer) {
        CompletableFuture<SendResult<String, Object>> future = template.send("customer-topic", customer);
        future.whenComplete((result, e) -> {
            if (e == null) {
                System.out.println("Send result getRecordMetadata offset: " + customer.toString() + ", Metadata " + result.getRecordMetadata().offset());
            } else {
                System.out.println("Unable to send message " + customer.toString() + " due to " + e.getMessage());
            }
        });
    }
}
