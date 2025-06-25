package com.techbulls.PizzaPalace.Dto;




public class OrderLineRequest {
    private Integer pizzaId;
    private String size;
    private Integer quantity;

    public OrderLineRequest() {
    }

    public OrderLineRequest(String size, Integer pizzaId, Integer quantity) {
        this.size = size;
        this.pizzaId = pizzaId;
        this.quantity = quantity;
    }

    public Integer getPizzaId() {
        return pizzaId;
    }

    public void setPizzaId(Integer pizzaId) {
        this.pizzaId = pizzaId;
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

    @Override
    public String toString() {
        return "OrderLineRequest{" +
                "pizzaId=" + pizzaId +
                ", size='" + size + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
