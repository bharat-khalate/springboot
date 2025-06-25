package com.Techbulls.MyBatis.Mapper;

import  java.util.List;
import com.Techbulls.MyBatis.Entities.Employee;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employee")
    List<Employee> getAllEmployees();

    @Select("select * from employee where id=#{id}")
    Employee getEmployeeById(Integer id);

    @Insert("insert into employee (address, first_name, last_name) values (#{address},#{first_name},#{last_name})")
    Integer addEmployee(Employee e);

    @Update("update employee set address=#{address}, first_name=#{first_name}, last_name=#{last_name} where id=#{id}")
    Integer updateEmployee(Employee e);

    @Delete("delete from employee where id=#{id}")
    Integer deleteEmployeeById(Integer id);

    @Select("select * from employee where first_name=#{first_name}")
    Employee getEmployeeByFirstName(String first_name);


}
