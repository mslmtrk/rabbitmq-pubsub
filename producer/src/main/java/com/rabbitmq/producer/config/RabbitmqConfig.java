package com.rabbitmq.producer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

	public static final String EXCHANGE_NAME = "x.example";

	public static final String QUEUE_NAME = "q.example";

	public static final String ROUTING_KEY = "routing-key";

	@Bean
	ObjectMapper objectMapper() {
		return JsonMapper.builder().findAndAddModules().build();
	}

	@Bean
	Jackson2JsonMessageConverter converter(ObjectMapper objectMapper) {
		return new Jackson2JsonMessageConverter(objectMapper);
	}

	@Bean
	Declarables createRabbitmqSchema() {

		DirectExchange exchange = ExchangeBuilder.directExchange(EXCHANGE_NAME).durable(true).build();
		Queue queue = QueueBuilder.durable(QUEUE_NAME).build();
		Binding binding = BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);

		return new Declarables(exchange, queue, binding);
	}
}
