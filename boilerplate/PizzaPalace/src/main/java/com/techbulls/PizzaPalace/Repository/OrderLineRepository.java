package com.techbulls.PizzaPalace.Repository;

import com.techbulls.PizzaPalace.Entities.OrderLine;
import org.springframework.data.repository.CrudRepository;

public interface OrderLineRepository extends CrudRepository<OrderLine,Integer> {
}
