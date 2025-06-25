package com.Km_Agri.controllers;

import com.Km_Agri.dto.ResponseStructure;
import com.Km_Agri.entities.Message;
import com.Km_Agri.service.MessageService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(path = "/message")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    private final ObjectMapper objectMapper = new ObjectMapper();


    @PostMapping
    public ResponseEntity<?> createMessage(@RequestBody Message message) {
        objectMapper.registerModule(new JavaTimeModule());
        message.setTimestamp(LocalDateTime.now());
        return ResponseEntity.ok(new ResponseStructure(200, true, List.of(messageService.addMessage(message))));
    }

//    @GetMapping("/{userId}")
//    public ResponseEntity<?> getMessageByUserId(@PathVariable Long userId) {
//        return ResponseEntity.ok("");
//    }

    @GetMapping("/{roomId}")
    public ResponseEntity<?> getMessageByUserId(@PathVariable Long roomId) {
        return ResponseEntity.ok(new ResponseStructure(200, true, messageService.getAllMessageByRoomId(roomId)));
    }
}
