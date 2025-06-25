package com.techbulls.PizzaPalace.Service;


import com.techbulls.PizzaPalace.Entities.Customer;
import com.techbulls.PizzaPalace.Repository.CustomerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class ServeCustomer {

    private CustomerRepository customerRepository;


    @Autowired
    public void setCustomer(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    public Customer addCustomer(Customer customer){
        customer=customerRepository.save(customer);
        return customer;
    }

    public Customer findCustomerById(Integer id){
        Customer customer=customerRepository.findById(id).orElseThrow(()->
                new NoSuchElementException("Customer With Id "+id+" not found"));
        return customer;
    }

    public List<Customer> getAllCustomers(){
        Iterable<Customer> res=customerRepository.findAll();
        List<Customer> customerList=new ArrayList<Customer>();
        res.forEach(ele->customerList.add(ele));
        return customerList;
    }

    public Customer updateCustomers(Integer id, Customer customer){
        Customer customerToUpdate=customerRepository.findById(id).orElseThrow(()->
                new NoSuchElementException("No Customer With id "+id+" exists"));
        customerToUpdate.setAddtress(customer.getAddtress());
        customerToUpdate.setEmailAddress(customer.getEmailAddress());
        customerToUpdate.setFirstName(customer.getFirstName());
        customerToUpdate.setLastName(customer.getLastName());
        customerToUpdate.setPhoneNumber(customer.getPhoneNumber());
        customer = customerRepository.save(customerToUpdate);
        return customer;
    }

    public void deleteCustomerById(Integer id){
        if (!customerRepository.existsById(id)) {
            throw new NoSuchElementException("Customer with ID " + id + " not found");
        }
        customerRepository.deleteById(id);
    }

}
