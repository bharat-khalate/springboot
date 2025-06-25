package com.Km_Agri.repository;

import com.Km_Agri.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {
    @Query(value = "select * from rooms where is_private=false", nativeQuery = true)
    List<Room> getAllPublicRooms();
}
