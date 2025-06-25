package com.Km_Agri.repository;

import com.Km_Agri.entities.Message;
import com.Km_Agri.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    public List<Message> findByRoom(Room room);

}
