package com.example.demo.service;

import com.example.demo.model.RequestData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
    private static final String TOPIC = "requests";

    @Autowired
    private KafkaTemplate<String, RequestData> kafkaTemplate;

    public void sendRequest(RequestData request) {
        kafkaTemplate.send(TOPIC, request.getId(), request);
        System.out.println("Sent request: " + request);
    }
}