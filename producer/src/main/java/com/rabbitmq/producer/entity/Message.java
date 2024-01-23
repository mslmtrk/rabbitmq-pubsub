package com.rabbitmq.producer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Message {

    private Integer id;

    private String content;
}
