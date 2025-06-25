package com.mpping.OneToMany.Controller;

import com.mpping.OneToMany.Entities.Course;
import com.mpping.OneToMany.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Responder {

    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public ResponseEntity<List<Course>> getCourse(){
        List<Course> l= courseService.getCourse();
        if(l==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.of(Optional.of(l));
    }

    @PostMapping("/addCourse")
    public ResponseEntity<String> addCourse(@RequestBody Course c){
        System.out.println(c);
        c=courseService.saveCourse(c);
        if(c==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("Added Successfully");
    }


}
