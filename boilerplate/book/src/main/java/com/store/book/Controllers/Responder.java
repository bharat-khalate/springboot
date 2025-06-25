package com.store.book.Controllers;

import com.store.book.Entity.Books;
import com.store.book.Service.ServeBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@RestController
public class Responder {
    @Autowired
    ServeBook servebook;

    @PostMapping("/addbook")
    public ResponseEntity<Books> addbooks(@RequestBody Books b){
        b=servebook.addBook(b);
        if(b==null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(b));
    }

    @PostMapping("/uploadfile")
    public ResponseEntity<String> uploadfiles(@RequestParam("file") MultipartFile file){
        boolean b=servebook.saveFile(file);
        if(b)
            return ResponseEntity.of(Optional.of("File Uploaded"));
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
