package com.techbulls.PizzaPalace.Repository;


import com.techbulls.PizzaPalace.Entities.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {
}
