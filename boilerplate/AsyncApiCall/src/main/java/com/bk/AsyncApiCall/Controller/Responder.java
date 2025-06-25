package com.bk.AsyncApiCall.Controller;

import com.bk.AsyncApiCall.Callers.AddNewEmployeeApi;
import com.bk.AsyncApiCall.Callers.GetAllEmployeesApi;
import com.bk.AsyncApiCall.Responses.Employee;
import org.springframework.beans.factory.annotation.Autowired;
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
    private GetAllEmployeesApi getAllEmployeesApi;

    @Autowired
    private AddNewEmployeeApi addNewEmployeeApi;

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        List<Employee> Emp_l= getAllEmployeesApi.getEmployee();
        return ResponseEntity.ok(Emp_l);
    }

    @PostMapping("/")
    public ResponseEntity<?> addEmployee(@RequestBody Employee e){
        System.out.println(e);
        String a=addNewEmployeeApi.addEmployee(e);
        return ResponseEntity.of(Optional.of(a));
    }
}
