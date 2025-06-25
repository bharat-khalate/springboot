package com.Km_Agri.controllers;

import com.Km_Agri.dto.ResponseStructure;
import com.Km_Agri.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/room")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @GetMapping
    public ResponseEntity<?> getAllPublicRooms() {
        return ResponseEntity.ok(new ResponseStructure(200, true, roomService.getAllPublicRooms()));
    }
}
