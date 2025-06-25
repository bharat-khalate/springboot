package com.Techbulls.MyBatis.Service;

import com.Techbulls.MyBatis.Entities.Employee;
import com.Techbulls.MyBatis.Mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ServeEmployee {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> getAllEmployees(){
        return employeeMapper.getAllEmployees();
    }

    public Employee getEmployeeById(Integer id){
        return employeeMapper.getEmployeeById(id);
    }

    public Integer addEmployee(Employee e){
        return employeeMapper.addEmployee(e);
    }

    public Integer updateEmployee(Employee e){
        return employeeMapper.updateEmployee(e);
    }

    public Integer deleteEmployee(Integer id){
        return employeeMapper.deleteEmployeeById(id);
    }

    public Employee getEmployeeByName(String name){
        System.out.println(name);
        Employee e=employeeMapper.getEmployeeByFirstName(name);
        System.out.println(e);
        if(e==null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        return e;
    }

}
