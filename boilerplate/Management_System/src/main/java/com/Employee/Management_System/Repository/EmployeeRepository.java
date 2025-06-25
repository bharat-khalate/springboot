package com.Employee.Management_System.Repository;

import com.Employee.Management_System.Entities.Employee;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {
    @Query(value = "select * from employee where first_name=:n", nativeQuery = true)
    public Employee findEByFirstName(@Param("n") String name);
}
