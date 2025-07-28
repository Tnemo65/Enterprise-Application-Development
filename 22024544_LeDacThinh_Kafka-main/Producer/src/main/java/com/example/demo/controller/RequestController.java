package com.example.demo.controller;

import com.example.demo.model.RequestData;
import com.example.demo.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController {
    @Autowired
    private KafkaProducerService producerService;

    @PostMapping("/send")
    public String sendRequest(@RequestBody RequestData request) {
        producerService.sendRequest(request);
        return "Request sent to Kafka";
    }
}
