package com.Km_Agri.controllers;


import com.Km_Agri.entities.Message;
import com.Km_Agri.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
public class WebSocketChatController {

    private final MessageService messageService;
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat.sendMessage") // /app/chat.sendMessage
    public void sendMessage(@Payload Message message) {
        message.setTimestamp(LocalDateTime.now());
        Message saved = messageService.addMessage(message);

        // Send to subscribers of /topic/roomId
        messagingTemplate.convertAndSend("/topic/" + message.getRoom().getRoomId(), saved);
    }
}
