package com.techbulls.PizzaPalace.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "orderId" // or the primary key field
)
@Table(name = "orders")
@Validated
public class Orders {


    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;


    @ManyToOne(cascade={
            CascadeType.PERSIST,
            CascadeType.DETACH,
            CascadeType.MERGE,
            CascadeType.REFRESH,
    })
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "status",columnDefinition = "VARCHAR(50) DEFAULT 'Created'", insertable = false)
    private String status;

    @Positive(message = "Total Amount cant be less then 0")
    @Column(name = "total_amount")
    private Integer totalAmount;

    @Column(name = "order_date_time")
    @CreationTimestamp
    private LocalDateTime orderDateTime;

    @Column(name = "delivery_address")
    private String deliveryAddress;


    @OneToMany(mappedBy = "orders",
            cascade = {
                    CascadeType.DETACH,
                    CascadeType.MERGE,
                    CascadeType.PERSIST,
                    CascadeType.REFRESH
            })
    @JsonManagedReference("order-orderline")
    private List<OrderLine> pizza;

    public Orders() {
    }

    public Orders(Integer orderId, String status, Integer totalAmount, LocalDateTime orderDateTime, String deliveryAddress, Customer customer) {
        this.orderId = orderId;
        this.status = status;
        this.totalAmount = totalAmount;
        this.orderDateTime = orderDateTime;
        this.deliveryAddress = deliveryAddress;
        this.customer = customer;
    }

    public Orders(Integer orderId, Customer customer, String status, Integer totalAmount, LocalDateTime orderDateTime, String deliveryAddress, List<OrderLine> pizza) {
        this.orderId = orderId;
        this.customer = customer;
        this.status = status;
        this.totalAmount = totalAmount;
        this.orderDateTime = orderDateTime;
        this.deliveryAddress = deliveryAddress;
        this.pizza = pizza;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getOrderDateTime() {
        return orderDateTime;
    }

    public void setOrderDateTime(LocalDateTime orderDateTime) {
        this.orderDateTime = orderDateTime;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<OrderLine> getPizza() {
        return pizza;
    }

    public void setPizza(List<OrderLine> pizza) {
        this.pizza = pizza;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "orderId=" + orderId +
                ", customer=" + customer +
                ", status='" + status + '\'' +
                ", totalAmount=" + totalAmount +
                ", orderDateTime='" + orderDateTime + '\'' +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", orderLine=" + pizza +
                '}';
    }
}