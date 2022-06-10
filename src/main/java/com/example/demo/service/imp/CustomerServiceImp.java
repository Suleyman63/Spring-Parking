package com.example.demo.service.imp;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImp implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);

    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.findAll();
    }



    @Override
    public Customer getById(Long id) {
        Optional<Customer> customer=customerRepository.findById(id);

        if (customer.isPresent()){
             return customer.get();
        }else {
            throw new RuntimeException("customer not found");
        }


    }

    @Override
    public Customer editCustomer(Long id, Customer customer) {
        Optional<Customer> result = customerRepository.findById(id);

        if (result.isPresent()){
            result.get().setCustomerFirstname(customer.getCustomerFirstname());
            result.get().setCustomerLastname(customer.getCustomerLastname());
            result.get().setCustomerPlate(customer.getCustomerPlate());
            result.get().setCustomerEmail(customer.getCustomerEmail());
            result.get().setCustomerPhone(customer.getCustomerPhone());
            result.get().setCustomerPassword(customer.getCustomerPassword());
            return customer;
        }

        return null;
    }

    @Override
    public Boolean deleteCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()){
            customerRepository.findById(id);
            return true;
        }
        throw new RuntimeException("customer not deleted");
    }
}
