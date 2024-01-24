package com.rabbitmq.producer.producer;

import com.rabbitmq.producer.config.RabbitmqConfig;
import com.rabbitmq.producer.entity.Message;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Producer {

    private RabbitTemplate rabbitTemplate;

    public void sendMessages(Message message) {
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_NAME, RabbitmqConfig.ROUTING_KEY, message);
    }
}
