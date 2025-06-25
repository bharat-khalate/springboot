package com.mpping.OneToMany.Service;

import com.mpping.OneToMany.Entities.Course;
import com.mpping.OneToMany.Entities.Instructor;
import com.mpping.OneToMany.Repository.InstrucorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private InstrucorRepository instructorRepository;

    public Course saveCourse(Course c){
        try {
            System.out.println(c);
            c = instructorRepository.save(c);
            return c;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }

    public List<Course> getCourse(){
        try{
            Iterable<Course> i=instructorRepository.findAll();
            List<Course> c=new ArrayList<Course>();
            i.forEach(e->c.add(e));
            return c;
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
