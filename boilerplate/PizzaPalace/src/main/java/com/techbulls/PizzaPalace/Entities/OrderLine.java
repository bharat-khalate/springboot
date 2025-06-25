package com.techbulls.PizzaPalace.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "order_line")
public class OrderLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_line_id")
    private Integer id;

    @ManyToOne(
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH,
            }
    )
    @JoinColumn(name = "order_id")
    @JsonBackReference("order-orderline")
    private Orders orders;

    @ManyToOne(cascade = {
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH
    })
    @JoinColumn(name ="pizza_id")
    @JsonBackReference("pizza-orderline")
    private Pizza pizza;

    @NotNull @NotEmpty(message = "invalid size")
    @Column(name = "size")
    private String size;


    @NotNull(message = "Can't be null")
    @Min(value = 1,message = "select atleast 1 pizza")
    @Column(name = "quantity")
    private Integer quantity;

    @NotNull(message = "Total price cant be nulll")
    @Column(name = "total_price")
    private Integer totalPrice;

    public OrderLine() {
    }

    public OrderLine(Integer id, Orders orders, String size, Integer quantity, Integer totalPrice) {
        this.id = id;
        this.orders = orders;
        this.size = size;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public OrderLine(Integer id, Orders orders, Pizza pizza, String size, Integer quantity, Integer totalPrice) {
        this.id = id;
        this.orders = orders;
        this.pizza = pizza;
        this.size = size;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "OrderLine{" +
                "id=" + id +
                ", orders=" + orders +
                ", pizza=" + pizza +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
