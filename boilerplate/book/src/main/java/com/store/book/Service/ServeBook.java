package com.store.book.Service;

import com.store.book.Entity.Books;
import com.store.book.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.nio.file.Paths;

@Service
public class ServeBook {
    @Autowired
    BookRepository bookrepository;

    public Books addBook(Books b){
        try {
            b=bookrepository.save(b);
            return b;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public boolean saveFile(MultipartFile file){
        boolean b=false;
    try {
        String path= Paths.get("src/main/resources/static/image").toAbsolutePath().toString();//new ClassPathResource("/").getFile().getAbsolutePath();
        byte[] data=file.getBytes();
        FileOutputStream fos=new FileOutputStream(path + file.getOriginalFilename());
        fos.write(data);
        fos.close();
        b=true;
    }
    catch (Exception e){
        e.printStackTrace();
        return b;
    }
    return b;

    }

}