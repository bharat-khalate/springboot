package com.Km_Agri.Service;

import com.Km_Agri.Entities.FileEntity;
import org.apache.logging.log4j.util.InternalException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class FileStorageService {

public String uplaodFile(MultipartFile file) {
    try {
        if (file.isEmpty()) throw new FileNotFoundException("File cant be empty");

        File dir = new File("Files/");
        if (!dir.exists()) dir.mkdirs();

        String orignalFileName = file.getOriginalFilename();
        String extension = "";
        if (orignalFileName != null && orignalFileName.contains(".")) {
            extension = orignalFileName.substring(orignalFileName.lastIndexOf("."));
        }
        String newFileName = UUID.randomUUID().toString() + extension;
        Path targetPath = Paths.get("Files/").resolve(newFileName);
        Files.write(targetPath, file.getBytes());
        return newFileName;
    } catch (Exception ex) {
        ex.printStackTrace();
        throw new InternalException("hii");
    }
}
}
