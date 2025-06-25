package com.Km_Agri.Controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("api/file")
public class FileController {

    @GetMapping("/{fileName}")
    public ResponseEntity<?> getFiles(@PathVariable String fileName) throws IOException {
        Path file= Paths.get(System.getProperty("user.dir"),"Files",fileName);
        if (!Files.exists(file) || Files.isDirectory(file)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(("File not found: " + fileName).getBytes());
        }
        byte[] fileBytes = Files.readAllBytes(file);
        HttpHeaders headers=new HttpHeaders();
        String contentType = Files.probeContentType(file);
        if (contentType == null) {
            contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE; // fallback
        }
        headers.setContentType(MediaType.parseMediaType(contentType));
        return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
    }
}
