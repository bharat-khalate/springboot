package com.Km_Agri.service;

import com.Km_Agri.entities.Room;
import com.Km_Agri.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public Room addRoom(Room room) {
        return roomRepository.save(room);
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public List<Room> getAllPublicRooms() {
        return roomRepository.getAllPublicRooms();
    }

    public Room getRoomById(Long roomId) {
        return roomRepository.findById(roomId).orElseThrow(() -> new NoSuchElementException("No room found"));
    }

    public Room updateRoomById(Long roomId, Room room) {
        room.setRoomId(roomId);
        return roomRepository.save(room);
    }

    public boolean deleteRoomById(Long roomId) {
        this.getRoomById(roomId);
        roomRepository.deleteById(roomId);
        return true;
    }
}
