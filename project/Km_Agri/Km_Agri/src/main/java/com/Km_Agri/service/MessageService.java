package com.Km_Agri.service;

import com.Km_Agri.entities.Message;
import com.Km_Agri.entities.Room;
import com.Km_Agri.entities.User;
import com.Km_Agri.kafka.KafkaMessageConsumer;
import com.Km_Agri.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepository messageRepository;
    private final RoomService roomService;
    private final UserService userService;
    private final KafkaMessageProducer kafkaMessageProducer;
    private final KafkaMessageConsumer kafkaMessageConsumer;

    @Transactional
    public Message addMessage(Message message) {
        if (message.getRoom() == null || message.getRoom().getRoomId() == null) {
            User fromUser = userService.getUserById(message.getFromUser().getId());
            User toUser = userService.getUserById(message.getToUser().getId());
            Room room = message.getRoom();
            room.setUserList(List.of(fromUser, toUser));
            message.setRoom(roomService.addRoom(room));
            message.setFromUser(fromUser);
            message.setToUser(toUser);
            return messageRepository.save(message);
        }
        return kafkaMessageProducer.send(message);
    }

    public List<Message> addAllMessage(List<Message> messageList) {
        return messageRepository.saveAll(messageList);
    }

    public List<Message> getAllMessage() {
        return messageRepository.findAll();
    }

    public Message getMessageById(Long messageId) {
        return messageRepository.findById(messageId).orElseThrow(() -> new NoSuchElementException("No such message found"));
    }

    public List<Message> getAllMessageByRoomId(Long roomId) {
        List<Message> messageList = messageRepository.findByRoom(roomService.getRoomById(roomId));
        messageList.addAll(kafkaMessageConsumer.drainMessagesByRoomId(roomId));
        return messageList;
    }

    public Message updateMessageById(Long messaeId, Message message) {
        message.setMessageId(messaeId);
        return messageRepository.save(message);
    }

    public boolean deleteMessageById(Long messageId) {
        this.getMessageById(messageId);
        messageRepository.deleteById(messageId);
        return true;

    }
}
