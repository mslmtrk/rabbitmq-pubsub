package com.rabbitmq.consumer.consumer;

import com.rabbitmq.consumer.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @RabbitListener(queues = "q.example", concurrency = "2", containerFactory = "prefetchTwentyContainerFactory")
    public void exampleListener(Message message) {
        LOGGER.info("Message consumed with id {}: {}", message.getId(), message.getContent());
    }
}