package com.rabbitmq.consumer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Message {

    private Integer id;

    private String content;
}
