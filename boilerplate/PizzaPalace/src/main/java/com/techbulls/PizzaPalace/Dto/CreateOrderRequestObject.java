package com.techbulls.PizzaPalace.Dto;
import java.util.List;


public class CreateOrderRequestObject {

    private Integer customerId;
    private String deliveryAddress;
    private  Integer totalAmount;
    private List<OrderLineRequest> pizza;

    public CreateOrderRequestObject() {
    }

    public CreateOrderRequestObject(Integer customerId, String deliveryAddress, Integer totalAmount, List<OrderLineRequest> pizza) {
        this.customerId = customerId;
        this.deliveryAddress = deliveryAddress;
        this.totalAmount = totalAmount;
        this.pizza = pizza;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<OrderLineRequest> getPizza() {
        return pizza;
    }

    public void setPizza(List<OrderLineRequest> pizza) {
        this.pizza = pizza;
    }

    @Override
    public String toString() {
        return "CreateOrderRequestObject{" +
                "customerId=" + customerId +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", totalAmount=" + totalAmount +
                ", pizza=" + pizza +
                '}';
    }
}
