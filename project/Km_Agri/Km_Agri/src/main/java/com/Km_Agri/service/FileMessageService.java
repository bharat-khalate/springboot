package com.Km_Agri.service;

import com.Km_Agri.entities.FileEntity;
import com.Km_Agri.repository.FileMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FileMessageService {
    private final FileMessageRepository fileMessageRepository;

    public FileEntity createFileMessage(FileEntity fileEntity) {
        return fileMessageRepository.save(fileEntity);
    }

    public List<FileEntity> getAllFileEntities() {
        return fileMessageRepository.findAll();
    }

    public FileEntity getFileMessageById(Long fileMessageId) {
        return fileMessageRepository.findById(fileMessageId).orElseThrow(() -> new NoSuchElementException("No Such File Message Found with id"));
    }

//    public FileEntity updateFileMessageById(Long fileMessageId, FileEntity fileEntity) {
//        FileEntity oldFileEntity = this.getFileMessageById(fileMessageId);
//        if(fileEntity.ge)
//    }

    public boolean deleteFileMessageById(Long fileMessageId) {
        this.getFileMessageById(fileMessageId);
        fileMessageRepository.deleteById(fileMessageId);
        return true;
    }

}
