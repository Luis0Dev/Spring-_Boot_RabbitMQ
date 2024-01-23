package com.Illusion0DEV.Api.Controller;

import com.Illusion0DEV.Domain.Service.RabbitMQProducerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMQProducerService rabbitMQProducerService;

    // http://localhost:8080/api/v1/publish
    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){

        rabbitMQProducerService.sendMessage(message);
        return  ResponseEntity.ok("Message sent to Rabbitmq....");
    }
}
