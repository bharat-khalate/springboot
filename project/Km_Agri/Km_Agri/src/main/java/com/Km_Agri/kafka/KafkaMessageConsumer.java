package com.Km_Agri.kafka;

import com.Km_Agri.entities.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class KafkaMessageConsumer {

    private final List<Message> receivedMessages = Collections.synchronizedList(new ArrayList<>());

    @KafkaListener(topics = "chat-messages", groupId = "chat-group")
    public void listen(Message message) {
        receivedMessages.add(message);
    }

    public List<Message> drainMessages() {
        synchronized (receivedMessages) {
            List<Message> drained = new ArrayList<>(receivedMessages);
            receivedMessages.clear();
            return drained;
        }
    }

    public List<Message> drainMessagesByRoomId(Long roomId) {
        synchronized (receivedMessages) {
            List<Message> drained = new ArrayList<>(receivedMessages).stream().filter((message -> roomId.equals(message.getRoom().getRoomId()))).toList();
            return drained;
        }
    }
}

