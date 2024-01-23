package com.Illusion0DEV.Domain.Service;

import com.Illusion0DEV.Domain.Entity.User;

import lombok.Getter;
import lombok.Setter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Getter
@Setter
@Service
public class RabbitMQJsonProducerService {

    @Value("${rabbit.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonProducerService.class);

    private RabbitTemplate rabbitTemplate;

    public void  sendJsonMessage(User user){
        LOGGER.info(String.format("Json message sent ->", user.toString()));
        rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
    }
}
