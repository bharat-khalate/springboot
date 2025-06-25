package com.Employee.Management_System.Controllers;

import com.Employee.Management_System.Entities.Employee;
import com.Employee.Management_System.Repository.EmployeeRepository;
import com.Employee.Management_System.Service.ServeEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Responder {
    @Autowired
    private ServeEmployee employeeRepository;

    @PostMapping("/createEmployee")
    public ResponseEntity<String> addEmployee(@RequestBody Employee e){
        e.setId(null);
        e=employeeRepository.saveEmployee(e);
        if(e!=null)
        return ResponseEntity.ok("Employee created Successfully");

        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @PutMapping("/updateEmployee/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable("id") Integer id,@RequestBody Employee e){
        System.out.println("hiii");
        System.out.println(e);
        e=employeeRepository.changeEmployee(id,e);
        if(e==null){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("Employee Update Successfully");
    }

    @GetMapping("/viewEmployeeById/{id}")
    public ResponseEntity<Employee> viewEmployee(@PathVariable("id") Integer id){
        Employee e=employeeRepository.getEmployee(id);
        if(e!=null)
            return  ResponseEntity.ok(e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping("/viewAllEmployee")
    public ResponseEntity<List<Employee>> viewAllEmployee(){
        List<Employee> l=employeeRepository.getAllEmployee();
        if(l!=null)
            return ResponseEntity.ok(l);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @DeleteMapping("/deleteEmployeeById/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id){
        boolean b=employeeRepository.deleteEmployeeById(id);
        if(b)
            return ResponseEntity.ok("Deleted successfully");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @GetMapping("/viewEmployeeByFirstName/{name}")
    public ResponseEntity<Employee> viewEmployeeByName(@PathVariable("name") String name ) {
        Employee e = employeeRepository.viewEmployeeByFirstName(name);
        if (e == null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        return ResponseEntity.ok(e);

    }

}
