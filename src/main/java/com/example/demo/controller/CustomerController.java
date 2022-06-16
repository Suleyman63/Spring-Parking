package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;


    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/save")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        Customer result = customerService.saveCustomer(customer);
        return ResponseEntity.ok(result);
    }


    @GetMapping("/getAll")
    public List<Customer> getAll(){
        List<Customer> list = customerService.getAll();
        return  list;
    }


    @GetMapping("/getById/{id}")
    public ResponseEntity<Customer> getById(@PathVariable("id") Long id){
        Customer customer = customerService.getById(id);
        return  ResponseEntity.ok(customer);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Customer> editCustomer(@PathVariable Long id, @RequestBody Customer customer){
        Customer result = customerService.editCustomer(id, customer);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable("id") Long id){
        Boolean status = customerService.deleteCustomer(id);
        return ResponseEntity.ok(status);
    }

    @GetMapping("/plate")
    public List<Customer> getByPlate(@PathVariable String plate){
        List<Customer> customer = customerService.getByPlate(plate);

        return customer;
    }

    @PostMapping("/login")
    public List<Customer> login(@RequestBody Customer customer){
        Customer result =  customerService.login(customer);

        return Collections.singletonList(result);
    }
}
