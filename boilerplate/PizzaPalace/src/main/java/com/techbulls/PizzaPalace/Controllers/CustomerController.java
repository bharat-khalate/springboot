package com.techbulls.PizzaPalace.Controllers;


import com.techbulls.PizzaPalace.Dto.CustomerList;
import com.techbulls.PizzaPalace.Dto.ResponseObject;
import com.techbulls.PizzaPalace.Entities.Customer;
import com.techbulls.PizzaPalace.Service.ServeCustomer;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/customers")
@RestController
public class CustomerController {

    private ServeCustomer serveCustomer;

    @Autowired
    public void setServeCustomer(ServeCustomer serveCustomer){
        this.serveCustomer=serveCustomer;
    }

    @PostMapping
    public ResponseEntity<?> createCustomer(@Valid @RequestBody Customer customer){
        System.out.println(customer);
        customer=serveCustomer.addCustomer(customer);
        CustomerList data= new CustomerList(List.of(customer));
        ResponseObject responseObject=new ResponseObject(true,"Customer created successfully",data);
        return  ResponseEntity.ok(responseObject);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCustomer(@PathVariable Integer id){
        Customer customer=serveCustomer.findCustomerById(id);
        CustomerList data=new CustomerList(List.of(customer));
        ResponseObject responseObject=new ResponseObject(true,"Data Found",data);
        return ResponseEntity.ok(responseObject);
    }

    @GetMapping
    public ResponseEntity<?> getcustomers(){
        CustomerList data= new CustomerList(serveCustomer.getAllCustomers());
        ResponseObject responseObject=new ResponseObject(true,"Data Found",data);
        return ResponseEntity.ok(responseObject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Integer id, @Valid @RequestBody Customer customer){
        customer=serveCustomer.updateCustomers(id,customer);
        CustomerList data=new CustomerList(List.of(customer));
        ResponseObject responseObject=new ResponseObject(true,"Successfully updated the customer",data);
        return ResponseEntity.ok(responseObject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer id){
        serveCustomer.deleteCustomerById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
