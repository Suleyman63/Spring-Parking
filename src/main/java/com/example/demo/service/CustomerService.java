package com.example.demo.service;

import com.example.demo.model.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Customer saveCustomer(Customer customer);

    List<Customer> getAll();

    Customer getById(Long id);

    Customer editCustomer(Long id,Customer customer);

    Boolean deleteCustomer(Long id);


}
