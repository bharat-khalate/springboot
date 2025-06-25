package com.Km_Agri.service;

import com.Km_Agri.entities.Message;
import com.Km_Agri.kafka.KafkaMessageConsumer;
import com.Km_Agri.repository.MessageRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MessagePersistenceService {


    private final KafkaMessageConsumer kafkaMessageConsumer;
    private final MessageService messageService;

    @Scheduled(fixedRate = 10 * 60 * 300) // every 10 minutes
    public void dumpMessages() {
        List<Message> messages = kafkaMessageConsumer.drainMessages();
        messageService.addAllMessage(messages);
    }
}

