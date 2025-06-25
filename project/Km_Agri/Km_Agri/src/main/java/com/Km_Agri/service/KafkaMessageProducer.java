package com.Km_Agri.service;

import com.Km_Agri.entities.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaMessageProducer {


    private final KafkaTemplate<String, Message> kafkaTemplate;

    public Message send(Message message) {
        kafkaTemplate.send("chat-messages", message);
        return message;
    }
}