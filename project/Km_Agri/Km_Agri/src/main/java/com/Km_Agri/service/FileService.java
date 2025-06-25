package com.Km_Agri.service;


import com.Km_Agri.utils.Constants;
import org.apache.tomcat.util.http.fileupload.InvalidFileNameException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

@Service
public class FileService {
    public String addFile(MultipartFile file) {
        try {
            if (file.isEmpty()) throw new FileNotFoundException("File is missing or corrupted");
            byte[] fileData = file.getBytes();
            String orignalFileName = file.getOriginalFilename();
            if (orignalFileName == null || !orignalFileName.contains("."))
                throw new InvalidFileNameException(orignalFileName, "Invalid File Name");
            int dotIndex = orignalFileName.lastIndexOf('.');
            String fileType = orignalFileName.substring(dotIndex);
            String newFileName = System.currentTimeMillis() + fileType;
            File uploadDir = new File(Constants.appliCationUploadPath);
            if (!uploadDir.exists()) uploadDir.mkdirs();
            File newFile = new File(uploadDir, newFileName);
            try (FileOutputStream fos = new FileOutputStream(newFile)) {
                fos.write(fileData);
            }
            return Constants.appliCationPath + "/files/" + newFileName;
        } catch (Exception ex) {
            throw new RuntimeException(ex.getLocalizedMessage());
        }
    }
}
