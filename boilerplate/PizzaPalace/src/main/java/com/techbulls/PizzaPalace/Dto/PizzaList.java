package com.techbulls.PizzaPalace.Dto;

import com.techbulls.PizzaPalace.Entities.Pizza;

import java.util.List;

public class PizzaList {

    private List<Pizza> pizzas;

    public PizzaList() {
    }

    public PizzaList(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }

    @Override
    public String toString() {
        return "PizzaList{" +
                "pizzas=" + pizzas +
                '}';
    }
}
