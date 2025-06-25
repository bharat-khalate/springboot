package com.mpping.OneToMany.Repository;

import com.mpping.OneToMany.Entities.Course;
import org.springframework.data.repository.CrudRepository;

public interface InstrucorRepository extends CrudRepository<Course,Integer> {
}
