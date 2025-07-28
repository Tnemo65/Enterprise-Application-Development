package com.example.demo.service;

import com.example.demo.model.RequestData;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "requests", groupId = "my-group")
    public void consume(RequestData request) {
        System.out.println("Received request: " + request);
        // Xử lý heavy task ở đây
    }
}