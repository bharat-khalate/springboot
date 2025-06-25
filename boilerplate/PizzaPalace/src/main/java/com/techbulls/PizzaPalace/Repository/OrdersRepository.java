package com.techbulls.PizzaPalace.Repository;

import com.techbulls.PizzaPalace.Entities.Orders;
import org.springframework.data.repository.CrudRepository;

import java.lang.Integer;

public interface OrdersRepository extends CrudRepository<Orders,Integer> {
}
