package com.kafkaconsumer.consumer;

import com.kafkaconsumer.dto.CustomerConsume;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class KafkaMessageListener {

    Logger logger = Logger.getLogger(KafkaMessageListener.class.getName());

    @KafkaListener(topics = "customer-topic", groupId = "customer-topic-group")
    public void consumeEvents(CustomerConsume customer) {
        logger.info("Consumer Consuming Customer: " + customer.toString());
    }

//    @KafkaListener(topics = "quickstart2", groupId = "jt-group-new")
//    public void consume(String message) {
//        logger.info("Consumer Consuming Message: " + message);
//    }
//
//    @KafkaListener(topics = "quickstart2", groupId = "jt-group-new")
//    public void consume2(String message) {
//        logger.info("Consumer Consuming2 Message: " + message);
//    }
//
//    @KafkaListener(topics = "quickstart2", groupId = "jt-group-new")
//    public void consume3(String message) {
//        logger.info("Consumer Consuming3 Message: " + message);
//    }
//
//    @KafkaListener(topics = "quickstart2", groupId = "jt-group-new")
//    public void consume4(String message) {
//        logger.info("Consumer Consuming4 Message: " + message);
//    }
}
