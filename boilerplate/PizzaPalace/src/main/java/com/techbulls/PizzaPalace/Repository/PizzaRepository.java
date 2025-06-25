package com.techbulls.PizzaPalace.Repository;

import com.techbulls.PizzaPalace.Entities.Pizza;
import org.springframework.data.repository.CrudRepository;

public interface PizzaRepository  extends CrudRepository<Pizza,Integer> {
}
