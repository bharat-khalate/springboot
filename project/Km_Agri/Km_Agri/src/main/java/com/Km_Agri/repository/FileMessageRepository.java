package com.Km_Agri.repository;

import com.Km_Agri.entities.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileMessageRepository extends JpaRepository<FileEntity, Long> {
}
