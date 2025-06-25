package com.techbulls.PizzaPalace.Dto;

import com.techbulls.PizzaPalace.Entities.Orders;

import java.util.List;

public class OrderList {
    private List<Orders> order;

    public OrderList() {
    }

    public void setOrderList(List<Orders> order) {
        this.order = order;
    }

    public List<Orders> getOrder() {
        return order;
    }

    public void setOrder(List<Orders> order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderList{" +
                "order=" + order +
                '}';
    }
}
