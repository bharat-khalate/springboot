package com.techbulls.PizzaPalace.Controllers;



import com.techbulls.PizzaPalace.Dto.PizzaList;
import com.techbulls.PizzaPalace.Entities.Pizza;
import com.techbulls.PizzaPalace.Service.ServePizza;
import com.techbulls.PizzaPalace.Dto.ResponseObject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;


import javax.xml.crypto.Data;
import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminConroller {

    private ServePizza servePizza;

    @Autowired
    public void setPizzaService(ServePizza servePizza) {
        this.servePizza = servePizza;
    }

    @PostMapping("/pizzas")
    public ResponseEntity<?> createPizza(@Valid @RequestBody Pizza pizza) {
        pizza = servePizza.createPizza(pizza);
        PizzaList data=new PizzaList(List.of(pizza));
        ResponseObject responseObject = new ResponseObject(true, "SuccessFully Created Pizza", data);
        return ResponseEntity.ok(responseObject);
    }

    @GetMapping("/pizzas/{id}")
    public ResponseEntity<?> getPizza(@PathVariable Integer id) throws MethodArgumentNotValidException {
        Pizza pizza = servePizza.getPizzaById(id);
        PizzaList data=new PizzaList(List.of(pizza));
        ResponseObject responseObject = new ResponseObject(true, "Data Found", data);
        return ResponseEntity.ok(responseObject);
    }

    @GetMapping("/pizzas")
    public ResponseEntity<?> getAllPizzas(){
        List<Pizza> pizzaList=servePizza.getAllPizzas();
        PizzaList data=new PizzaList(pizzaList);
        ResponseObject responseObject=new ResponseObject(true, "Data Found", data);
        return ResponseEntity.ok(responseObject);
    }

    @PutMapping("/pizzas/{id}")
    public ResponseEntity<?> updatePizzacustomer(@PathVariable Integer id,@Valid @RequestBody Pizza pizza){
        pizza=servePizza.updatePizza(id,pizza);
        PizzaList data=new PizzaList(List.of(pizza));
        ResponseObject responseObject=new ResponseObject(true, "Data Updated", data);
        return ResponseEntity.ok(responseObject);
    }

    @DeleteMapping("/pizzas/{id}")
    public ResponseEntity<?> deletePizza(@PathVariable Integer id){
        servePizza.deletePizzaById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }



}
