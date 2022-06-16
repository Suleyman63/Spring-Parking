package com.example.demo.service.imp;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public Customer editCustomer(Long id,Customer customer) {

        Customer newCustomer = customerRepository.findById(id).
                orElseThrow(()-> new IllegalArgumentException(id+"not found"));

        newCustomer.setCustomerFirstname(customer.getCustomerFirstname());
        newCustomer.setCustomerLastname(customer.getCustomerLastname());
        newCustomer.setCustomerPlate(customer.getCustomerPlate());
        newCustomer.setCustomerEmail(customer.getCustomerEmail());
        newCustomer.setCustomerPhone(customer.getCustomerPhone());
        newCustomer.setCustomerPassword(customer.getCustomerPassword());

        return customerRepository.save(newCustomer);
    }

    @Override
    public Boolean deleteCustomer(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);

        if (customer.isPresent()){
            customerRepository.deleteById(id);
            return true;
        }
        throw new RuntimeException("customer not deleted");
    }

    @Override
    public List<Customer> getByPlate(String plate) {
        List<Customer> customers = customerRepository.findAll();

        List<Customer> returnListe = new ArrayList<>();
        for (var customer : customers) {
            if (customer.getCustomerPlate().equals(plate)) {
                returnListe.add(customer);
            }
        }
        return returnListe;
    }


    @Override
    public Customer login(Customer customer) {
        List<Customer> customerList = customerRepository.findAll();

        for (var c : customerList) {
            if (c.getCustomerEmail().equals(customer.getCustomerEmail()) &&
                    c.getCustomerPassword().equals(customer.getCustomerPassword())) {
                return c;
            }
        }
        return new Customer(-1L, "", "", "", "", "", "");
    }
}
