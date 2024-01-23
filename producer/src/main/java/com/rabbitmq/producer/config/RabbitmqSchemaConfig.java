package com.rabbitmq.producer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqSchemaConfig {

    @Bean
    Declarables creatRabbitmqSchema() {
        return new Declarables(
                new DirectExchange("x.exchange", true, false, null),
                new Queue("q.queue"),
                new Binding("q.queue", Binding.DestinationType.QUEUE, "x.exchange", "routing-key", null)
        );
    }
}
