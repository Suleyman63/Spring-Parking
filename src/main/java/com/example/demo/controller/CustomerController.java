package com.example.demo.controller;


import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


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
    public ResponseEntity<Customer> getById(@PathVariable("id" ) Long id){
        Customer customer = customerService.getById(id);
        return  ResponseEntity.ok(customer);
    }


    @PutMapping("edit/{id}")
    public ResponseEntity<Customer> editCustomer(@PathVariable("id") Long id, @RequestBody Customer customer){

        Customer result = customerService.editCustomer(id,customer);
        return ResponseEntity.ok(result);
    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<Boolean> deleteCustomer(@PathVariable("id") Long id){
        Boolean status = customerService.deleteCustomer(id);

        return ResponseEntity.ok(status);

    }
}
