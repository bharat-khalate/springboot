package com.Techbulls.MyBatis.Controllers;
import com.Techbulls.MyBatis.Entities.Employee;
import com.Techbulls.MyBatis.Service.ServeEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
public class Responder {

    @Autowired
    ServeEmployee serveEmployee;

    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAllEmployees(){
        return ResponseEntity.ok(serveEmployee.getAllEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEMployeeBYId(@PathVariable Integer id){
        return ResponseEntity.ok(serveEmployee.getEmployeeById(id));

    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Employee> getEmployeeByName (@PathVariable String name){
        return  ResponseEntity.ok(serveEmployee.getEmployeeByName(name));
    }

    @PostMapping("/")
    public ResponseEntity<?> addEmployee(@RequestBody Employee e){
        serveEmployee.addEmployee(e);
        return ResponseEntity.ok("added Successfully");
    }

    @PutMapping("/")
    public ResponseEntity<?> updateEmployee(@RequestBody Employee e){
        serveEmployee.updateEmployee(e);
        return ResponseEntity.ok("Updated Successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployeeBYId(@PathVariable Integer id){
        Integer result = serveEmployee.deleteEmployee(id);
        if (result > 0) {
            return ResponseEntity.ok("Deleted successfully");
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee not found");
        }
    }
}
