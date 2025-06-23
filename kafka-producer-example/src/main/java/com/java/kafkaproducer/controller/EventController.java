package com.java.kafkaproducer.controller;

import com.java.kafkaproducer.dto.Customer;
import com.java.kafkaproducer.service.KafkaMessagePublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer-app")
public class EventController {

    @Autowired
    private KafkaMessagePublisher publisher;

    @GetMapping("/publish/{message}")
    public ResponseEntity<String> publishMessage(@PathVariable String message) {
        try {
            for (int i = 1; i <= 1000000; i++) {
                publisher.sendMessage(message + " : " + i);
            }
            return ResponseEntity.ok("message published successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/publish")
    public ResponseEntity<String> sentEvents(@RequestBody Customer customer) {
        try {
            publisher.sendEventsToTopic(customer);
            return ResponseEntity.ok("message published successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
