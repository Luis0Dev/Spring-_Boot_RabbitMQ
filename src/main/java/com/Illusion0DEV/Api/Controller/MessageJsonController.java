package com.Illusion0DEV.Api.Controller;

import com.Illusion0DEV.Domain.Entity.User;
import com.Illusion0DEV.Domain.Service.RabbitMQJsonProducerService;
import com.Illusion0DEV.Domain.Service.RabbitMQProducerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class MessageJsonController {

    private RabbitMQJsonProducerService jsonProducerService;


    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonProducerService.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMq...");
    }

}
