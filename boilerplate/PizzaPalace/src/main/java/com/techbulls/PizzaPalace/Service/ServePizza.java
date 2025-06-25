package com.techbulls.PizzaPalace.Service;

import com.techbulls.PizzaPalace.Entities.Pizza;
import com.techbulls.PizzaPalace.Repository.PizzaRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.ArrayList;
import java.util.List;

import java.util.NoSuchElementException;
import java.util.Optional;

@Transactional
@Service
public class ServePizza {

    private PizzaRepository pizzaRepository;


    @Autowired
    public void setRepo(PizzaRepository p){
        this.pizzaRepository=p;

    }



    public Pizza createPizza(Pizza p){
           p = pizzaRepository.save(p);
           return p;
    }

    public Pizza getPizzaById(Integer id) throws  MethodArgumentNotValidException{
        Optional<Pizza> res=pizzaRepository.findById(id);
        Pizza p=res.get();
        return p;
    }

    public List<Pizza> getAllPizzas(){
        Iterable<Pizza> res=pizzaRepository.findAll();
        List<Pizza> pizzaList=new ArrayList<Pizza>();
        res.forEach(ele->pizzaList.add(ele));
        return pizzaList;
    }


    public Pizza updatePizza(Integer id, Pizza pizza){
        Pizza pizzaToUpdate = pizzaRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Pizza with ID " + id + " not found"));
        pizzaToUpdate.setName(pizza.getName());
        pizzaToUpdate.setDescription(pizzaToUpdate.getDescription());
        pizzaToUpdate.setImageUrl(pizza.getImageUrl());
        pizzaToUpdate.setType(pizza.getType());
        pizzaToUpdate.setPriceLargeSize(pizza.getPriceLargeSize());
        pizzaToUpdate.setPriceMediumSize(pizza.getPriceMediumSize());
        pizzaToUpdate.setPriceRegularSize(pizza.getPriceRegularSize());
        pizza=pizzaRepository.save(pizzaToUpdate);
        return pizza;
    }

    public void deletePizzaById(Integer id){
        if (!pizzaRepository.existsById(id)) {
            throw new NoSuchElementException("Pizza with ID " + id + " not found");
        }
        pizzaRepository.deleteById(id);

    }



}
