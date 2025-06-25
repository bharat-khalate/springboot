package com.Km_Agri.controllers;

import com.Km_Agri.dto.ResponseStructure;
import com.Km_Agri.utils.Constants;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping(path = "/files")
public class FileController {

    @GetMapping("/{fileName}")
    public ResponseEntity<?> getFile(@PathVariable String fileName) throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"), "files", fileName);
        if (!Files.exists(path) || Files.isDirectory(path)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(("File not found" + fileName).getBytes());
        }
        byte[] fileBytes = Files.readAllBytes(path);
        HttpHeaders httpHeaders = new HttpHeaders();
        String contentType = Files.probeContentType(path);
        if (contentType == null) contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
        httpHeaders.setContentType(MediaType.parseMediaType(contentType));
        return new ResponseEntity<>(fileBytes, httpHeaders, HttpStatus.OK);
    }
}
