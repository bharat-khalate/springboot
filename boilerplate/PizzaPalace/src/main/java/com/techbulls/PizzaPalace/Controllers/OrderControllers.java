package com.techbulls.PizzaPalace.Controllers;


import com.techbulls.PizzaPalace.Dto.CreateOrderRequestObject;
import com.techbulls.PizzaPalace.Dto.OrderList;
import com.techbulls.PizzaPalace.Dto.ResponseObject;
import com.techbulls.PizzaPalace.Entities.Orders;
import com.techbulls.PizzaPalace.Service.ServeOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderControllers {

    private ServeOrder serveOrder;

    @Autowired
    public void setServeOrder(ServeOrder serveOrder){
        this.serveOrder=serveOrder;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody CreateOrderRequestObject order){
        System.out.println(order);
        Orders orders=serveOrder.saveOrder(order);
        OrderList data=new OrderList();
        data.setOrder(List.of(orders));
        ResponseObject responseObject=new ResponseObject(true,"order Created Successfully", data);
        return ResponseEntity.ok(responseObject);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDetail(@PathVariable Integer id){
        Orders order=serveOrder.getOrderById(id);
        OrderList data=new OrderList();
        data.setOrder(List.of(order));
        ResponseObject responseObject=new ResponseObject(true, "Data Found",data);
        return ResponseEntity.ok(responseObject);
    }
}
