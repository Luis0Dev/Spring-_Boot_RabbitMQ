package com.Illusion0DEV.Domain.Service;

import com.Illusion0DEV.Domain.Entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonConsumerService {
    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonConsumerService.class);

    @RabbitListener(queues ={"${rabbitmq.queue.json.name}"})
    public void consumerJsonMessage(User user){

        LOGGER.info(String.format("Received JSON Message -> %s", user.toString()));
    }
}
