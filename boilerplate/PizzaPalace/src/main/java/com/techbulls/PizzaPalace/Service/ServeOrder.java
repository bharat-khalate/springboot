package com.techbulls.PizzaPalace.Service;

import com.techbulls.PizzaPalace.Dto.CreateOrderRequestObject;
import com.techbulls.PizzaPalace.Dto.OrderLineRequest;
import com.techbulls.PizzaPalace.Entities.Customer;
import com.techbulls.PizzaPalace.Entities.OrderLine;
import com.techbulls.PizzaPalace.Entities.Orders;
import com.techbulls.PizzaPalace.Entities.Pizza;
import com.techbulls.PizzaPalace.Repository.CustomerRepository;
import com.techbulls.PizzaPalace.Repository.OrderLineRepository;
import com.techbulls.PizzaPalace.Repository.OrdersRepository;
import com.techbulls.PizzaPalace.Repository.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServeOrder {

    private CustomerRepository customerRepository;
    private PizzaRepository pizzaRepository;
    private OrdersRepository ordersRepository;
    private OrderLineRepository orderLineRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    @Autowired
    public void setPizzaRepository(PizzaRepository pizzaRepository){
        this.pizzaRepository=pizzaRepository;
    }

    @Autowired
    public void setOrdersRepository(OrdersRepository ordersRepository){
        this.ordersRepository=ordersRepository;
    }

    @Autowired
    public void setOrderLineRepository(OrderLineRepository orderLineRepository){
        this.orderLineRepository=orderLineRepository;
    }




    public Orders saveOrder(CreateOrderRequestObject createOrderRequestObject){
        Customer customer = customerRepository.findById(createOrderRequestObject.getCustomerId())
                .orElseThrow(() -> new NoSuchElementException("Customer not found"));
        Orders order=new Orders();
        order.setCustomer(customer);
        order.setDeliveryAddress(createOrderRequestObject.getDeliveryAddress());
        order.setTotalAmount(createOrderRequestObject.getTotalAmount());
        order.setStatus("Created");

        List<OrderLine> orderLines = new ArrayList<>();


        for (OrderLineRequest olr : createOrderRequestObject.getPizza()) {
            Pizza pizza = pizzaRepository.findById(olr.getPizzaId())
                    .orElseThrow(() -> new NoSuchElementException("Pizza not found"));
            OrderLine ol = new OrderLine();
            ol.setPizza(pizza);
            ol.setSize(olr.getSize());
            ol.setQuantity(olr.getQuantity());
            ol.setTotalPrice(pizza.getPriceMediumSize() * olr.getQuantity());
            ol.setOrders(order);
            orderLines.add(ol);
        }
        order.setPizza(orderLines);
        order= ordersRepository.save(order);
        return order;
    }


    public Orders getOrderById(Integer id){
        Orders order =ordersRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Invalid Id"));
        return order;

    }

}
